import { Text, TextInput, StyleSheet, View, Pressable, SafeAreaView, ImageBackground } from "react-native"
import { Link } from "expo-router"
import { AuthForm } from "@/components/AuthForm"
import { AuthContext } from "../../contexts/AuthContext"
import { DBContext } from "@/contexts/DBContext"
import { useContext, useState, useEffect } from "react"
import { createUserWithEmailAndPassword, onAuthStateChanged } from "@firebase/auth"
import { setDoc, doc } from "firebase/firestore"
import { useRouter } from "expo-router"
import { BlurView } from "expo-blur"

export default function Signup(props: any) {
    const [email, setEmail] = useState("")
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [validEmail, setValidEmail] = useState(false)
    const [validUsername, setValidUsername] = useState(false)
    const [validPassword, setValidPassword] = useState(false)

    const db = useContext(DBContext)
    const auth = useContext(AuthContext)
    const router = useRouter()


    // regex
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/

    // handle form updates
    useEffect(() => {
        // validate email against regex 
        setValidEmail(emailRegex.test(email))
        // console.log(`email is valid?: ${emailRegex.test(email)}`)
    }, [email])

    useEffect(() => {
        setValidUsername(username.length > 0)
        // console.log(`username is valid?: ${validUsername}`)
    }, [username])

    useEffect(() => {
        setValidPassword(password.length >= 6)
        // console.log(`password is valid?: ${validPassword}`)
    }, [password])



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
    
    const handleCheckValid = () => {
        return validEmail && validPassword
    }


    return (
        <ImageBackground
            source={require("../../assets/images/background/trivia_background_img_1.png")}
            resizeMode="cover"
            style={styles.container}
        >

            <Text style={styles.title}>Twofold Trivia</Text>

            <View style={styles.formContainer}>
                <BlurView
                    style={styles.blurContainer}
                    intensity={50}
                    tint="light"
                >
                    <Text style={styles.title}>Sign Up</Text>
                    
                    <Text>Email</Text>
                    <TextInput 
                        style={styles.input} 
                        value={email} 
                        onChangeText={(text) => setEmail(text)}
                    />
                    <Text>Username</Text>
                    <TextInput 
                        style={styles.input}  
                        value={username} 
                        onChangeText={(text) => setUsername(text)}
                    />

                    <Text>Password</Text>
                    <TextInput 
                        style={styles.input}  
                        secureTextEntry={true} 
                        value={password} 
                        onChangeText={(text) => setPassword(text)}
                    />

                    <Pressable 
                        onPress={() => handleRegister(email, username, password)}
                        style={handleCheckValid() ? styles.button : styles.buttonDisabled}
                        disabled={handleCheckValid() ? false : true}
                    >
                        <Text style={styles.buttonText}>
                            Sign Up
                        </Text>
                    </Pressable>

                    <View style={styles.swapAuthForm}>
                        <Text>Already have an account?</Text>
                        <Link href="/auth/login">
                            <Text style={styles.link}>Go to Sign in</Text>
                        </Link>
                    </View>
                </BlurView>
            </View>
        </ImageBackground>
    )
}

const styles = StyleSheet.create({
    container: {
        padding: 20,
        justifyContent: "center",
        alignItems: "center",
    },
    formContainer: {
        marginHorizontal: 20,
        marginTop: 100,
    },
    blurContainer: {
        padding: 20,
        borderRadius: 10,
        borderWidth: 2,
        borderColor: "#000",
    },
    image: {
        flex: 1,
        justifyContent: "center",
    },
    title: {
        fontSize: 35,
        fontWeight: "bold",
        textAlign: "center",
        margin: 15,
    },
    swapAuthForm: {
        flexDirection: "row",
    },
    link: {
        color: "#b8111e",
        marginLeft: 5,
    },
    input: {
        borderStyle: "solid",
        borderWidth: 1,
        borderColor: "#cccccc",
        padding: 6,
        marginBottom: 20,
        backgroundColor: "#efefef",
        borderRadius: 6,
    },
    button: {
        backgroundColor: "#333333",
        borderRadius: 4,
    },
    buttonText: {
        color: "#efefef",
        textAlign: "center",
        padding: 8,
    },
    buttonDisabled: {
        backgroundColor: "#888888",
        borderRadius: 4,
    },
    buttonTextDisabled: {
        color: "#666666",
        textAlign: "center",
        padding: 8,
    },
})
