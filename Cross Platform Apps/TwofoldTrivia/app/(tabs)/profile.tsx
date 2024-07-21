// dependencies
import { View, Text, StyleSheet, Pressable } from "react-native"
import { useContext, useState, useEffect } from "react"
import { doc, getDoc} from "firebase/firestore"
import { signOut } from "@firebase/auth"
import { useRouter } from "expo-router"

// context
import { AuthContext } from "../../contexts/AuthContext"
import { DBContext } from "@/contexts/DBContext"


export default function ProfileScreen(props: any) {
    const [userData, setUSerData] = useState({
        username: "",
        email: "",
        highscore: 0,
    })

    const db = useContext(DBContext)
    const auth = useContext(AuthContext)
    const router = useRouter()

    // fetch data
    useEffect(() => {
        fetchUser()
    }, [db])

    const fetchUser = async () => {
        // get auth user
        const user = auth.currentUser

        if (user) {
            // get db user
            const userDocRef = doc(db, "users", user.uid)
            const userDoc = await getDoc(userDocRef)

            if (userDoc.exists()) {
                // get user data
                const fetchedData = userDoc.data()

                // set user data
                setUSerData({
                    username: fetchedData.username,
                    email: fetchedData.email,
                    highscore: fetchedData.highscore,
                });
            } else {
                console.log("no user doc")
            }
        } else {
            console.log("no user signed in")
        }
    }

    

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
                <Text style={styles.title}>Profile</Text>
            </View>

            <View>
                <Text style={styles.userInfo}>{userData.username}</Text>
                <Text style={styles.userInfo}>Highscore: {userData.highscore}</Text>
            </View>

            <View style={styles.btnsContainer}>
                <Pressable onPress={() => console.log("change password")} style={styles.btn}>
                    <Text style={styles.btnText}>Change Password</Text>
                </Pressable>

                <Pressable onPress={() => SignOutUser()} style={styles.btn}>
                    <Text style={styles.btnText}>Sign Out</Text>
                </Pressable>

                <Pressable onPress={() => console.log("Delete Account")} style={styles.btn}>
                    <Text style={styles.btnText}>Delete Account</Text>
                </Pressable>
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 20,
    },
    title: {
        fontSize: 24,
        fontWeight: "bold",
        textAlign: "center",
        marginBottom: 20,
    },
    userInfo: {
        textAlign: "center",
    },
    btnsContainer: {
        marginTop: 30,
        marginBottom: 30,
        display: "flex",
        alignItems: "center",
        flexDirection: "column",
    },
    btn: {
        width: "50%",
        padding: 10,
        backgroundColor: "#ccc",
        borderRadius: 10,
        marginBottom: 10,
    },
    btnText: {
        textAlign: "center",
    },
})