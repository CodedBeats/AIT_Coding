// dependencies
import { Text, TextInput, StyleSheet, View, Pressable, SafeAreaView, ImageBackground } from "react-native"
import { signInWithEmailAndPassword } from "@firebase/auth"
import { AuthContext } from "@/contexts/AuthContext"
import { useContext, useState, useEffect } from "react"
import { useRouter } from "expo-router"
import { BlurView } from "expo-blur"
import { Link } from "@react-navigation/native"

// components


export default function Login(props: any) {
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [validEmail, setValidEmail] = useState(false)
    const [validPassword, setValidPassword] = useState(false)

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
        setValidPassword(password.length >= 6)
        // console.log(`password is valid?: ${validPassword}`)
    }, [password])

    const handleLogin = (email: string, password: string) => {
        signInWithEmailAndPassword(auth, email, password)
        .then((userCredential) => {
            console.log(`user credential: ${userCredential}`)
            router.replace("/home")
        })
        .catch((error) => {
            console.log(error)
        })
    }
    
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
                    <Text style={styles.title}>Sign In</Text>
                    
                    <Text>Email</Text>
                    <TextInput 
                        style={styles.input} 
                        value={email} 
                        onChangeText={(text) => setEmail(text)}
                    />
                    
                    <Text>Password</Text>
                    <TextInput 
                        style={styles.input}  
                        secureTextEntry={true} 
                        value={password} 
                        onChangeText={(text) => setPassword(text)}
                    />
                    
                    <Pressable 
                        onPress={() => handleLogin(email, password)}
                        style={handleCheckValid() ? styles.button : styles.buttonDisabled}
                        disabled={handleCheckValid() ? false : true}
                    >
                        <Text style={styles.buttonText}>
                            Sign In
                        </Text>
                    </Pressable>
                    
                    <View style={styles.swapAuthForm}>
                        <Text>Don"t have an account?</Text>
                        <Link to="/register">
                            <Text style={styles.link}>
                                Go to Sign up
                            </Text>
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