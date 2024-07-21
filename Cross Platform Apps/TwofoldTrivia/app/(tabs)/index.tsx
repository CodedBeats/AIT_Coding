// dependencies
import { View, Text, StyleSheet, Pressable } from "react-native"
import { useContext } from "react"
import { useRouter } from "expo-router"
import { useNavigation } from "expo-router"

// context
import { AuthContext } from "@/contexts/AuthContext"


export default function HomeScreen() {
    const auth = useContext(AuthContext)
    const router = useRouter()
    const navigation = useNavigation()
    navigation.setOptions({headerShown: true})

    return(
        <View style={styles.container}>
            <View>
                <Text style={styles.title}>Twodold Trivia</Text>
            </View>

            <View>
                <Pressable style={styles.gameBtn} onPress={() => router.replace("/game")}>
                    <Text style={styles.gameBtnText}>Start Trivia Game</Text>
                </Pressable>
            </View>

            <View style={styles.gameInfo}>
                <Text style={styles.gameInfoTitle}>Rules</Text>
                <Text>TBD</Text>

                <Text style={styles.gameInfoTitle}>Game Info</Text>
                <Text>TBD</Text>
            </View>
        </View>
    )
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
    gameBtn: {
        backgroundColor: "#333333",
        margin: 20,
        padding: 15,
        paddingTop: 10,
        alignSelf: "center",
        width: 200,
        borderRadius: 5,
    },
    gameBtnText: {
        color: "#FFF",
        textAlign: "center",
        fontSize: 40,
        fontWeight: "bold",
    },
    gameInfo: {
        marginTop: 30,
        marginBottom: 20,
        display: "flex",
        justifyContent: "space-around",
        alignItems: "center",
        flexDirection: "column",
        flexWrap: "wrap",
    },
    gameInfoTitle: {
        fontSize: 20,
        fontWeight: "bold",
        marginBottom: 10,
        marginTop: 20,
        textAlign: "center",
    }
})
