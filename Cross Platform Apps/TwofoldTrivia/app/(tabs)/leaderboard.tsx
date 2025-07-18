// dependencies
import React, { useState, useEffect, useContext } from "react"
import { View, Text, StyleSheet, FlatList, ActivityIndicator, SafeAreaView, ImageBackground, ScrollView } from "react-native"
import { collection, query, orderBy, onSnapshot } from "firebase/firestore"

// components
import ErrorMessage from "@/components/ErrorMessage"

// contexts
import { DBContext } from "@/contexts/DBContext"

// I hope I did this right :p
interface UserDocument {
    email: string
    username: string
    highscore: number
}


export default function LeaderboardScreen() {
    const [users, setUsers] = useState<UserDocument[]>([])
    const [loading, setLoading] = useState(true)
    const [errorVisible, setErrorVisible] = useState(false)
    const [error, setError] = useState("")

    const db = useContext(DBContext)

    useEffect(() => {
        const qry = query(collection(db, "users"), orderBy("highscore", "desc"))
        
        const unsubscribe = onSnapshot(qry, 
            (querySnapshot) => {
                const usersArray: UserDocument[] = querySnapshot.docs.map(doc => doc.data() as UserDocument)
                setUsers(usersArray)
                setLoading(false)
            },
            (err) => {
                setError(err.message)
                setErrorVisible(true)
                setLoading(false)
            }
        )

        return () => unsubscribe() // Clean up the listener on unmount
    }, [db])


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

                {/* Modal */}
                <ErrorMessage
                    visible={errorVisible}
                    title="Error"
                    message={error}
                    onDismiss={() => setErrorVisible(false)}
                />
            </View>
        )
    }

    return (
        <SafeAreaView style={styles.container}>
        <ImageBackground
            source={require("../../assets/images/background/Background_3.png")}
            resizeMode="cover"
            style={styles.backgroundImg}
        >
            <ScrollView>
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
            </ScrollView>
        </ImageBackground>
        </SafeAreaView>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        height: "100%",
        width: "100%",
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
        fontFamily: "Roboto-Regular",
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
        fontFamily: "Roboto-Regular",
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
        fontFamily: "NunitoSans-Regular",
    },
    highscore: {
        fontSize: 18,
        fontFamily: "NunitoSans-Regular",
    },
});
