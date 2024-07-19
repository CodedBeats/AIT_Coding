import { View, Text, StyleSheet, StatusBar, TextInput } from "react-native"
import { Link } from "expo-router"
import { AuthForm } from "@/components/AuthForm"
import { AuthContext } from "../contexts/AuthContext"
import { DBContext } from "@/contexts/DBContext"
import { useContext, useState } from "react"
import { createUserWithEmailAndPassword, onAuthStateChanged } from "@firebase/auth"
import { collection, addDoc } from "firebase/firestore"
import { useRouter } from "expo-router"

export default function Signup(props: any) {
    const db = useContext(DBContext)
    const auth = useContext(AuthContext)
    const router = useRouter()

    const handleRegister = async (email: string, username: String, password: string) => {
        console.log(email, username, password)
        // create auth user
        createUserWithEmailAndPassword(auth, email, password)
        .then((userCredential) => {
            router.replace("/home")
        })
        .catch( (error) => {
           console.log(error)
        })

        // create db user
        const highscore = 0
        await addDoc(collection(db, "users"), {
            email: email,
            username: username,
            highscore: highscore,
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
            <AuthForm title="Sign up for an account" actionText="Sign up" action={handleRegister} />
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
