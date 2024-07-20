import { View, Text, StyleSheet, StatusBar, TextInput } from "react-native"
import { Link } from "expo-router"
import { AuthForm } from "@/components/AuthForm"
import { AuthContext } from "../../contexts/AuthContext"
import { DBContext } from "@/contexts/DBContext"
import { useContext, useState } from "react"
import { createUserWithEmailAndPassword, onAuthStateChanged } from "@firebase/auth"
import { collection, setDoc, doc } from "firebase/firestore"
import { useRouter } from "expo-router"

export default function Signup(props: any) {
    const db = useContext(DBContext)
    const auth = useContext(AuthContext)
    const router = useRouter()

    const handleRegister = async (email: string, username: String, password: string) => {
        console.log(email, username, password)
        try {
            // create auth user
            const userCredential = await createUserWithEmailAndPassword(auth, email, password);
            const user = userCredential.user;
            const userDocRef = doc(db, "users", user.uid);
    
            // create db user with UID
            await setDoc(userDocRef, {
                email: email,
                username: username,
                highscore: 0,
            });
    
            router.replace("/");
        } catch (error) {
            console.log(error);
        }
    }

    onAuthStateChanged(auth, (user) => {
        if (user) {
            // authenticated
            // nav to home
            router.replace("(tabs)")
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
                <Link href="/auth/login">
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
