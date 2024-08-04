// dependencies
import React, { useState, useEffect, useContext } from "react"
import { View, Text, StyleSheet, FlatList, ActivityIndicator, SafeAreaView, ImageBackground } from "react-native"
import { collection, getDocs, orderBy, query } from "firebase/firestore"

// contexts
import { DBContext } from "@/contexts/DBContext"

// I hope I did this right :p
interface UserDocument {
    email: string
    username: string
    highscore: number
}


export default function LeaderboardScreen() {
    const [users, setUsers] = useState<UserDocument[]>([]);
    const [loading, setLoading] = useState(true);
    const db = useContext(DBContext);

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
                // get all users in order of highest score
                const qry = query(collection(db, "users"), orderBy("highscore", "desc"))
                const querySnapshot = await getDocs(qry)
                const usersArray: UserDocument[] = querySnapshot.docs.map(doc => doc.data() as UserDocument)
                setUsers(usersArray)
            } catch (err: any) {
                console.log(err.message)
            } finally {
                setLoading(false)
            }
        };
        fetchData()
    }, [])


    // fancy loading I found
    if (loading) {
        return (
            <View style={styles.loadingContainer}>
                <ImageBackground
                    source={require("../../assets/images/background/Background_3.png")}
                    resizeMode="cover"
                    style={styles.backgroundImg}
                >
                    <View style={styles.loadingBar}>
                        <ActivityIndicator size="large" color="#0000FF" />
                    </View>
                </ImageBackground>
            </View>
        );
    }

    return (
        <SafeAreaView style={styles.container}>
        <ImageBackground
            source={require("../../assets/images/background/Background_3.png")}
            resizeMode="cover"
            style={styles.backgroundImg}
        >
            <Text style={styles.title}>Leaderboard</Text>
            <View style={styles.leaderboard}>
                <View style={styles.labels}>
                    <Text style={styles.labelText}>User</Text>
                    <Text style={styles.labelText}>Highscore</Text>
                </View>

                <FlatList
                    data={users}
                    keyExtractor={(item) => item.email}
                    renderItem={({item}) => (
                        <View style={styles.userContainer}>
                            <Text style={styles.username}>{item.username}</Text>
                            <Text style={styles.highscore}>{item.highscore}</Text>
                        </View>
                    )}
                />
            </View>
        </ImageBackground>
        </SafeAreaView>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 20,
    },
    backgroundImg: {
        height: "100%",
        width: "100%",
    },
    title: {
        fontSize: 35,
        fontWeight: "bold",
        textAlign: "center",
        margin: 15,
    },
    loadingContainer: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
    },
    loadingBar: {
        flex: 2,
        justifyContent: "center",
        alignItems: "center",
    },
    leaderboard: {
        backgroundColor: "#EEE",
        marginHorizontal: 30,
        flexGrow: 0,
        padding: 10,
        borderWidth: 2,
        borderColor: "#000",
        borderRadius: 10,
        shadowColor: "#000",
        shadowOffset: { width: 4, height: 4 },
        shadowOpacity: 0.8,
    },
    labels: {
        flexDirection: "row",
        justifyContent: "space-between",
        padding: 10,
    },
    labelText: {
        fontSize: 20,
        fontWeight: "bold",
    },
    userContainer: {
        flexDirection: "row",
        justifyContent: "space-between",
        padding: 10,
        borderTopWidth: 1,
        borderColor: "#000",
    },
    username: {
        fontSize: 18,
    },
    highscore: {
        fontSize: 18,
    },
});
