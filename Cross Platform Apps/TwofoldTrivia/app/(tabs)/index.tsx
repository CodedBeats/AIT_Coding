import { View, Text, StyleSheet, Pressable, FlatList } from "react-native"
import { AuthContext } from "@/contexts/AuthContext"
import { useContext, useEffect } from "react"
import { signOut } from "@firebase/auth"
import { useRouter } from "expo-router"
import { useNavigation } from "expo-router"

export default function HomeScreen() {
    const auth = useContext(AuthContext)
    const router = useRouter()
    const navigation = useNavigation()
    navigation.setOptions({headerShown: true})

    return(
        <View>
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
