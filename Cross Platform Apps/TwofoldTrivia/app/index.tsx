import { View, Text, StyleSheet, StatusBar, TextInput } from "react-native"
import { Link } from "expo-router"
import { AuthContext } from "../contexts/AuthContext"
import { useContext, useState } from "react"
import { createUserWithEmailAndPassword, onAuthStateChanged } from "@firebase/auth"
import { useRouter } from "expo-router"

export default function Signup(props: any) {
    const auth = useContext( AuthContext )

    return (
        <View>
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
