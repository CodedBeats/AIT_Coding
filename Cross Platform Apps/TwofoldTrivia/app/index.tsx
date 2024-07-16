import { View, Text, StyleSheet } from 'react-native'
import { Link } from 'expo-router'

export default function Signup(props: any) {

    return (
        <View>
            <View style={styles.container}>
                <Text>Already have an account?</Text>
                <Link href='/login'>
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
