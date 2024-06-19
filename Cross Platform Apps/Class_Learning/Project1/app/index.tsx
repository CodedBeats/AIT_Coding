import { Link } from "expo-router";
import { Text, View, StyleSheet } from "react-native";

export default function Index() {
    return (
        <View style={styles.container}>
            <Text>This is the home screen</Text>
            <Link href="/details">Link to details</Link>
            <Link href="/login">Link to Login</Link>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
    },
});
