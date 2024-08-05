// dependencies
import { Text, TextInput, StyleSheet, View, Pressable, SafeAreaView, ImageBackground } from "react-native"
import { signInWithEmailAndPassword, onAuthStateChanged } from "@firebase/auth"
import { AuthContext } from "@/contexts/AuthContext"
import { useContext, useState, useEffect } from "react"
import { useRouter } from "expo-router"
import { BlurView } from "expo-blur"
import { Link } from "@react-navigation/native"

// components
import ErrorMessage from "@/components/ErrorMessage"


export default function Login(props: any) {
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [validEmail, setValidEmail] = useState(false)
    const [validPassword, setValidPassword] = useState(false)
    const [errorVisible, setErrorVisible] = useState(false)
    const [error, setError] = useState("")

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
            router.replace("/home")
        })
        .catch((error) => {
            setError(error.message)
            setErrorVisible(true)
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
    
    const handleCheckValid = () => {
        return validEmail && validPassword
    }


    return (
        <SafeAreaView style={styles.container}>
        <ImageBackground
            source={require("../../assets/images/background/Background_4.png")}
            resizeMode="cover"
            style={styles.backgroundImg}
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
                        <Text style={styles.swapAuthFormText}>Don't have an account?</Text>
                        <Link to="/register">
                            <Text style={styles.link}>
                                Go to Sign up
                            </Text>
                        </Link>
                    </View>
                </BlurView>
            </View>

            {/* Modal */}
            <ErrorMessage
                visible={errorVisible}
                title="Error"
                message={error}
                onDismiss={() => setErrorVisible(false)}
            />
        </ImageBackground>
        </SafeAreaView>
    )
}

const styles = StyleSheet.create({
    container: {
        height: "100%",
        width: "100%",
        justifyContent: "center",
        alignItems: "center",
    },
    backgroundImg: {
        height: "100%",
        width: "100%",
    },
    formContainer: {
        marginHorizontal: 40,
        marginTop: 100,
        borderWidth: 2,
        borderColor: "#000",
        borderRadius: 10,
        shadowColor: "#000",
        shadowOffset: { width: 4, height: 4 },
        shadowOpacity: 0.8,
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
        color: "#FFF",
        fontFamily: "Roboto-Regular",
    },
    swapAuthForm: {
        flexDirection: "row",
        justifyContent: "center",
    },
    swapAuthFormText: {
        fontFamily: "NunitoSans-Regular",
    },
    link: {
        color: "#b8111e",
        marginLeft: 5,
        fontWeight: "bold",
        fontFamily: "NunitoSans-Regular",
    },
    input: {
        borderStyle: "solid",
        borderWidth: 1,
        borderColor: "#cccccc",
        padding: 6,
        marginBottom: 20,
        backgroundColor: "#efefef",
        borderRadius: 6,
        fontFamily: "NunitoSans-Regular",
    },
    button: {
        backgroundColor: "#333333",
        borderRadius: 4,
    },
    buttonText: {
        color: "#efefef",
        textAlign: "center",
        padding: 8,
        fontFamily: "NunitoSans-Regular",
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