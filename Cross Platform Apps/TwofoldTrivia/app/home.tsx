import { View, Text, StyleSheet, Pressable, FlatList } from "react-native"
import { AuthContext } from "@/contexts/AuthContext"
import { useContext, useEffect } from "react"
import { signOut } from "@firebase/auth"
import { useRouter } from "expo-router"
import { useNavigation } from "expo-router"

export default function Home(props: any) {
    const auth = useContext(AuthContext)
    const router = useRouter()
    const navigation = useNavigation()
    navigation.setOptions({headerShown: true})

    const SignOutUser = () => {
        signOut(auth)
        .then(() => {
            router.replace("/")
        })
        .catch(( error) => {
            console.log(error.code, error.message)
        })
    }

    return(
        <View>
            <Text>Home</Text>
            <Pressable onPress={() => SignOutUser()}>
                <Text>Sign Out</Text>
            </Pressable>
        </View>
    )
}

const styles = StyleSheet.create({
    addButton: {
        backgroundColor: "#333333",
        padding: 8,
        alignSelf: "center",
        width: 200,
        borderRadius: 5,
    },
    addButtonText: {
        color: "#eeeeee",
        textAlign: "center",
    }
})
