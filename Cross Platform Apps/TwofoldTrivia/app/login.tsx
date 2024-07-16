import { View, Text, StyleSheet, StatusBar } from "react-native"
import { Link } from "expo-router"
import { AuthForm } from "@/components/AuthForm"
import { signInWithEmailAndPassword } from "@firebase/auth"
import { AuthContext } from "@/contexts/AuthContext"
import { useContext, useState } from "react"
import { useRouter } from "expo-router"

export default function Login(props: any) {
    const auth = useContext(AuthContext)
    const router = useRouter()

    const SignIn = (email: string, password: string) => {
        signInWithEmailAndPassword(auth, email, password)
        .then((userCredential) => {
            router.replace("/home")
        })
        .catch((error) => {
            console.log(error)
        })
    }

    return (
        <View>
            <AuthForm title="Sign in to your account" actionText="Sign in" action={SignIn} />
            <View style={styles.container}>
                <Text>Don"t have an account?</Text>
                <Link href="/">
                    <Text style={styles.link}>
                        Go to Sign up
                    </Text>
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