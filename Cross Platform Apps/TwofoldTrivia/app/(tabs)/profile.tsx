// dependencies
import { View, Text, StyleSheet, Pressable, SafeAreaView, ImageBackground  } from "react-native"
import { useContext, useState, useEffect } from "react"
import { doc, getDoc } from "firebase/firestore"
import { signOut } from "@firebase/auth"
import { useRouter } from "expo-router"

// components
import ConfirmationModal from "@/components/ConfirmationModal"

// context
import { AuthContext } from "../../contexts/AuthContext"
import { DBContext } from "@/contexts/DBContext"

export default function ProfileScreen(props: any) {
    const [userData, setUSerData] = useState({
        username: "",
        email: "",
        highscore: 0,
    })
    const [modalVisible, setModalVisible] = useState(false)
    const [modalAction, setModalAction] = useState<"changePassword" | "deleteAccount" | null>(null)

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

    // modal actions
    const handleConfirm = () => {
        setModalVisible(false);
        if (modalAction === "changePassword") {
            handleChangePassword()
        } else if (modalAction === "deleteAccount") {
            handleDeleteAccount()
        }
        console.log("confirmed")
    }
    const handleCancel = () => {
        setModalVisible(false)
        console.log("cancelled")
    }

    // sign out
    const SignOutUser = () => {
        signOut(auth)
            .then(() => {
                console.log("logged out")
                router.replace("/")
            })
            .catch((error) => {
                console.log(error.code, error.message)
            })
    }

    // change password
    const handleChangePassword = () => {
        console.log("change password")
    }

    // delete account
    const handleDeleteAccount = () => {
        console.log("delete account")
    }

    return (
        <SafeAreaView style={styles.container}>
        <ImageBackground
            source={require("../../assets/images/background/Background_2.png")}
            resizeMode="cover"
            style={styles.backgroundImg}
        >
            <View>
                <Text style={styles.title}>Profile</Text>
            </View>

            <View style={styles.userInfoContainer}>
                <Text style={styles.userInfo}>{userData.username}</Text>
                <Text style={styles.userInfo}>
                    Highscore: {userData.highscore}
                </Text>
            </View>

            <View style={styles.btnsContainer}>
                <Pressable onPress={() => { setModalAction('changePassword'); setModalVisible(true); }} style={styles.btn}>
                    <Text style={styles.btnText}>Change Password</Text>
                </Pressable>

                <Pressable onPress={SignOutUser} style={styles.btn}>
                    <Text style={styles.btnText}>Sign Out</Text>
                </Pressable>

                <Pressable onPress={() => { setModalAction('deleteAccount'); setModalVisible(true); }} style={styles.btn}>
                    <Text style={styles.btnText}>Delete Account</Text>
                </Pressable>
            </View>

            {/* modal */}
            <ConfirmationModal
                visible={modalVisible}
                message={`Are you sure you want to ${modalAction === 'changePassword' ? 'change your password' : 'delete your account'}?`}
                onConfirm={handleConfirm}
                onCancel={handleCancel}
            />
        </ImageBackground>
        </SafeAreaView>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 20,
    },
    backgroundImg: {
        height: "100%",
        width: "100%",
    },
    title: {
        fontSize: 35,
        fontWeight: "bold",
        textAlign: "center",
        margin: 15,
    },
    userInfoContainer: {
        marginVertical: 50,
    },
    userInfo: {
        textAlign: "center",
        fontWeight: "bold",
        fontSize: 50,
        margin: 10,
    },
    btnsContainer: {
        marginTop: 50,
        display: "flex",
        alignItems: "center",
        flexDirection: "column",
    },
    btn: {
        width: "50%",
        padding: 10,
        backgroundColor: "#333",
        borderRadius: 10,
        marginBottom: 20,
    },
    btnText: {
        textAlign: "center",
        color: "#fff",
        fontSize: 20,
    },
});
