import { Stack } from "expo-router";
import { SafeAreaView, StyleSheet, StatusBar } from "react-native";
import { firebaseConfig } from "@/config/Config";
import { initializeApp } from "@firebase/app";
import { getAuth } from "@firebase/auth";
import { AuthContext } from "@/contexts/AuthContext";
import { getFirestore } from "@firebase/firestore";

export default function RootLayout() {
    // init firebase
    const app = initializeApp(firebaseConfig);
    // init auth
    const auth = getAuth(app);
    // init firestore
    const db = getFirestore(app);

    return (
        <AuthContext.Provider value={auth}>
            <SafeAreaView style={styles.container}>
                <Stack screenOptions={{headerShown: false}} />
            </SafeAreaView>
        </AuthContext.Provider>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        paddingTop: StatusBar.currentHeight,
    },
});
