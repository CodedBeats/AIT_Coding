import { View, Text, StyleSheet, StatusBar, TextInput } from "react-native"
import { Link } from "expo-router"
import { AuthForm } from "@/components/AuthForm"
import { AuthContext } from "../contexts/AuthContext"
import { useContext, useState } from "react"
import { createUserWithEmailAndPassword, onAuthStateChanged } from "@firebase/auth"
import { useRouter } from "expo-router"

export default function Signup(props: any) {
    const auth = useContext(AuthContext)
    const router = useRouter()

    const createAccount = (email: string, password: string) => {
        createUserWithEmailAndPassword(auth, email, password)
        .then((userCredential) => {
            router.replace("/home")
        })
        .catch( (error) => {
           console.log(error)
        })
    }

    onAuthStateChanged(auth, (user) => {
        if (user) {
            // authenticated
            // nav to home
            router.replace("/home")
        }
        else {
            // not authenticated
        }
    })

    return (
        <View>
            <AuthForm title="Sign up for an account" actionText="Sign up" action={createAccount} />
            <View style={styles.container}>
                <Text>Already have an account?</Text>
                <Link href="/login">
                    <Text style={styles.link} >Go to Sign in</Text>
                </Link>
            </View>
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
