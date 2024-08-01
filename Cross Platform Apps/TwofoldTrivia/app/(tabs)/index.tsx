// dependencies
import { View, Text, StyleSheet, Pressable, FlatList, SafeAreaView } from "react-native"
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
        <SafeAreaView style={styles.container}>
            <View>
                <Text style={styles.title}>Twodold Trivia</Text>
            </View>

            <View>
                <Pressable style={styles.gameBtn} onPress={() => router.replace("/game")}>
                    <Text style={styles.gameBtnText}>Start Trivia Game</Text>
                </Pressable>
            </View>

            <View style={styles.gameInfo}>
                <Text style={styles.gameInfoTitle}>Game Info</Text>
                <Text>
                    Welcome to Twofold Trivia! Test your knowledge and quick thinking by choosing the correct category for each word. Challenge yourself to score high and climb the leaderboard. Enjoy a fun and educational trivia experience designed for both casual players and trivia enthusiasts!
                </Text>

                <Text style={styles.gameInfoTitle}>Rules</Text>
                <FlatList
                    data={[
                    {key: "> Objective: Match each word with the correct category as quickly as possible."},
                    {key: "> You will be given a series of words, each with two possible category options."},
                    {key: "> Tap the left or right button to choose the category you think is correct."},
                    {key: "> Time Limit: Each game is timed, so think fast to maximize your score!"},
                    {key: "> Earn points for each correct answer. Aim for the highest score to top the leaderboard!"},
                    {key: "> Compare your scores with other players and strive to become the top trivia master!"},
                    ]}
                    renderItem={({item}) => <Text>{item.key}</Text>}
                />
            </View>
        </SafeAreaView>
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
