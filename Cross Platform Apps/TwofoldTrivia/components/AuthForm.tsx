import { Text, TextInput, StyleSheet, View, Pressable } from "react-native"
import { useState, useEffect } from "react" 

export function AuthForm (props: any) {
    const [email, setEmail] = useState("")
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [validEmail, setValidEmail] = useState(false)
    const [validUsername, setValidUsername] = useState(false)
    const [validPassword, setValidPassword] = useState(false)

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


    // handle check valid for login or register form (at this point, why am I not making 2 seperate components??? haha)
    const handleCheckValid = () => {
        if (props.actionText === "Sign up") {
            return validEmail && validUsername && validPassword
        } else if (props.actionText === "Sign in") {
            return validEmail && validPassword
        }
    }


    // handle login or register
    const handlePress = () => {
        if (props.actionText === "Sign up") {
            props.action(email, username, password)
        } else if (props.actionText === "Sign in") {
            props.action(email, password)
        }
    }
    

    return (
        <View style={styles.container}>
            <Text style={styles.title}>{props.title}</Text>
            <Text>Email</Text>
            <TextInput 
                style={styles.input} 
                value={email} 
                onChangeText={(text) => setEmail(text)}
            />
            {props.actionText === "Sign up" &&
            <>
                <Text>Username</Text>
                <TextInput 
                    style={styles.input}  
                    value={username} 
                    onChangeText={(text) => setUsername(text)}
                />
            </>
            }
            <Text>Password</Text>
            <TextInput 
                style={styles.input}  
                secureTextEntry={true} 
                value={password} 
                onChangeText={(text) => setPassword(text)}
            />
            <Pressable 
                onPress={handlePress}
                style={handleCheckValid() ? styles.button : styles.buttonDisabled}
                disabled={handleCheckValid() ? false : true}
            >
                <Text style={styles.buttonText}>
                    {props.actionText}
                </Text>
            </Pressable>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        marginHorizontal: 20,
        marginTop: 100,
        padding: 20,
        backgroundColor: "#bbbbbb",
        borderRadius: 10,
    },
    title: {
        fontSize: 18,
        textAlign: "center"
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