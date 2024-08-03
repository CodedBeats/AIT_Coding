// dependencies
import { Stack } from "expo-router"
import { SafeAreaView, StyleSheet, StatusBar } from "react-native"
import { firebaseConfig } from "@/config/Config"
import { initializeApp } from "@firebase/app"
import { getAuth } from "@firebase/auth"
import { AuthContext } from "@/contexts/AuthContext"
import { DBContext } from "@/contexts/DBContext"
import { getFirestore } from "@firebase/firestore"
import { useAuthState } from "react-firebase-hooks/auth"

export default function RootLayout() {
    // init firebase
    const app = initializeApp(firebaseConfig)
    // init auth
    const auth = getAuth(app)
    // init firestore
    const db = getFirestore(app)

    const [user, loading] = useAuthState(auth)

    return (
        <AuthContext.Provider value={auth}>
            <DBContext.Provider value={db}>
                <SafeAreaView style={styles.container}>
                    <Stack screenOptions={{headerShown: false}} > 
                    {loading ? (
                        // show loading screen
                        <Stack.Screen name="loading" />
                    ) : user ? (
                        // user authenticated -> show tabs
                        <Stack.Screen name="(tabs)" />
                    ) : (
                        // user not authenticated -> show auth screens
                        <>
                            <Stack.Screen name="auth/login" />
                            <Stack.Screen name="auth/register" />
                        </>
                    )}
                    </Stack>
                </SafeAreaView>
            </DBContext.Provider>
        </AuthContext.Provider>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        paddingTop: StatusBar.currentHeight,
    },
});
