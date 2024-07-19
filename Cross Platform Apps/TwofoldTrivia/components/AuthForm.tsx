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

    useEffect(() => {
        // validate email against regex 
        if (emailRegex.test(email)) {
            // valid email
            setValidEmail(true)
            // console.log(`email is valid?: ${emailRegex.test(email)}`)
        }
        else {
            // invalid email
            setValidEmail(false)
            // console.log(`email is valid?: ${emailRegex.test(email)}`)
        }
    }, [email])

    useEffect(() => {
        if (username.length > 0) {
            // valid username
            setValidUsername(true)
            // console.log(`username is valid?: ${validUsername}`)
        }
        else {
            setValidUsername(false)
            // console.log(`username is valid?: ${validUsername}`)
        }
    }, [username])

    useEffect(() => {
        if (password.length >= 6) {
            // valid password
            setValidPassword(true)
            // console.log(`password is valid?: ${validPassword}`)
        }
        else {
            setValidPassword(false)
            // console.log(`password is valid?: ${validPassword}`)
        }
    }, [password])

    return (
        <View style={styles.container}>
            <Text style={styles.title}>{props.title}</Text>
            <Text>Email</Text>
            <TextInput 
                style={styles.input} 
                value={email} 
                onChangeText={(text) => setEmail(text)}
            />
            <Text>Username</Text>
            <TextInput 
                style={styles.input}  
                secureTextEntry={true} 
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
                onPress={() => props.action(email, username, password)} 
                style={(validEmail && validPassword && validUsername) ? styles.button : styles.buttonDisabled}
                disabled={(validEmail && validPassword && validUsername) ? false : true}
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