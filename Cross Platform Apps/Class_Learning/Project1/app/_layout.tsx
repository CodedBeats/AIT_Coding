import { Stack } from "expo-router"
// friebase
import { firebaseConfig } from "@/config/Config"
import { initializeApp } from "firebase/app"
import { getAuth } from "firebase/auth"
// contexts
import { AuthContext } from "@/contexts/AuthContext"

export default function RootLayout() {
    // init firebase
    const FBApp = initializeApp(firebaseConfig);
    // init firebase auth, get reference to service
    const FBAuth = getAuth(FBApp);

    return (
        <AuthContext.Provider value={FBAuth}>
        <Stack>
            <Stack.Screen name="index" />
            <Stack.Screen name="details" />
            <Stack.Screen name="login" />
        </Stack>
        </AuthContext.Provider>
    );
}
