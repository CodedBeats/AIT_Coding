// dependencies
import { View, Text, StyleSheet, Pressable, FlatList } from "react-native"
import { useContext, useEffect } from "react"
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
            <Text>Twodold Trivia</Text>
            <Pressable style={styles.gameBtn} onPress={() => router.replace("/game")}>
                <Text style={styles.gameBtnText}>Start Trivia Game</Text>
            </Pressable>

            <View>
                <Text>Rules</Text>
                <Text>info</Text>
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
    },
    gameBtn: {
        backgroundColor: "#333333",
        padding: 8,
        alignSelf: "center",
        width: 200,
        borderRadius: 5,
    },
    gameBtnText: {
        color: "#FF0000",
        textAlign: "center",
    }
})
