// dependencies
import { View, Text, StyleSheet, Pressable, FlatList, SafeAreaView, ImageBackground } from "react-native"
import { useContext } from "react"
import { useRouter } from "expo-router"
import { useNavigation } from "expo-router"

// context
import { AuthContext } from "@/contexts/AuthContext"


export default function HomeScreen() {
    const auth = useContext(AuthContext)
    const router = useRouter()
    const navigation = useNavigation()

    return(
        <SafeAreaView style={styles.container}>
        <ImageBackground
            source={require("../../assets/images/background/Background_1.png")}
            resizeMode="cover"
            style={styles.backgroundImg}
        >
            <View>
                <Text style={styles.title}>Twofold Trivia</Text>
            </View>

            <View>
                <Pressable style={styles.gameBtn} onPress={() => router.replace("/game")}>
                    <Text style={styles.gameBtnText}>Start Trivia Game</Text>
                </Pressable>
            </View>

            <View style={styles.gameInfo}>
                <Text style={styles.gameInfoTitle}>Game Info</Text>
                <Text>
                    Welcome to Twofold Trivia! Test your knowledge and quick thinking by choosing the correct category for each word. 
                    You have 60 seconds to get as high a score as you can and climb the leaderboard.
                    Enjoy a fun and educational trivia experience designed for both casual players and trivia enthusiasts!
                </Text>

                <Text style={styles.gameInfoTitle}>Rules</Text>
                <FlatList
                    data={[
                    {key: "1. You will be given a series of words, each with two possible category options"},
                    {key: "2. Tap the left or right button to choose the category you think is correct"},
                    {key: "3. Match each word with the correct category as quickly as possible to get a high score and compete with the top of the leaderboard"},
                    ]}
                    renderItem={({item}) => <Text style={styles.rule}>{item.key}</Text>}
                />
            </View>
        </ImageBackground>
        </SafeAreaView>
    )
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
    gameBtn: {
        backgroundColor: "#333333",
        margin: 20,
        padding: 15,
        paddingTop: 10,
        alignSelf: "center",
        width: 200,
        borderWidth: 2,
        borderBlockColor: "#000",
        borderRadius: 10,
        shadowColor: "#000",
        shadowOffset: { width: 4, height: 4 },
        shadowOpacity: 0.8,
    },
    gameBtnText: {
        color: "#FFF",
        textAlign: "center",
        fontSize: 40,
        fontWeight: "bold",
    },
    gameInfo: {
        backgroundColor: "#EEE",
        display: "flex",
        justifyContent: "space-around",
        alignItems: "center",
        flexDirection: "column",
        flexWrap: "wrap",
        marginHorizontal: 30,
        marginTop: 30,
        marginBottom: 20,
        padding: 20,
        paddingTop: 0,
        borderWidth: 2,
        borderBlockColor: "#000",
        borderRadius: 10,
        shadowColor: "#000",
        shadowOffset: { width: 4, height: 4 },
        shadowOpacity: 0.8,
    },
    gameInfoTitle: {
        fontSize: 20,
        fontWeight: "bold",
        marginBottom: 10,
        marginTop: 20,
        textAlign: "center",
    },
    rule: {
        marginBottom: 20,
    }
})
