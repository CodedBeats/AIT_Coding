// dependencies
import React, { useState, useEffect, useContext } from "react"
import { View, Text, StyleSheet, FlatList, ActivityIndicator } from "react-native"
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
                <ActivityIndicator size="large" color="#FFFF00" />
            </View>
        );
    }

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Leaderboard</Text>
            <FlatList
                data={users}
                keyExtractor={(item) => item.email}
                renderItem={({item}) => (
                    <View style={styles.userContainer}>
                        <Text style={styles.username}>{item.username}</Text>
                        <Text style={styles.highscore}>Highcore: {item.highscore}</Text>
                    </View>
                )}
            />
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 20,
    },
    title: {
        fontSize: 24,
        fontWeight: "bold",
        textAlign: "center",
        marginBottom: 20,
    },
    loadingContainer: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
    },
    userContainer: {
        flexDirection: "row",
        justifyContent: "space-between",
        padding: 10,
        borderWidth: 1,
        borderColor: "#CCC",
    },
    username: {
        fontSize: 18,
    },
    highscore: {
        fontSize: 18,
    },
});
