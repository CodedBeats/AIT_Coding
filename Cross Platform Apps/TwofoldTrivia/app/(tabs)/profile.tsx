import { View, Text, StyleSheet, StatusBar, TextInput, Pressable } from "react-native"
import { Link } from "expo-router"
import { AuthForm } from "@/components/AuthForm"
import { AuthContext } from "../../contexts/AuthContext"
import { DBContext } from "@/contexts/DBContext"
import { useContext, useState } from "react"
import { signOut } from "@firebase/auth"
import { useRouter } from "expo-router"

export default function ProfileScreen(props: any) {
    const db = useContext(DBContext)
    const auth = useContext(AuthContext)
    const router = useRouter()

    const SignOutUser = () => {
        signOut(auth)
        .then(() => {
            router.replace("/auth/register")
        })
        .catch(( error) => {
            console.log(error.code, error.message)
        })
    }

    return (
        <View style={styles.container}>
            <View>
                <Text>profile</Text>
            </View>

            <Pressable onPress={() => SignOutUser()}>
                <Text>Sign Out</Text>
            </Pressable>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flexDirection: "row",
        justifyContent: "center",
        marginVertical: 15,
    },
    link: {
        color: "#b8111e",
        marginLeft: 5,
    }
})