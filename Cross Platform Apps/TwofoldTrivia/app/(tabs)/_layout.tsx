import FontAwesome from "@expo/vector-icons/FontAwesome";
import { Tabs } from "expo-router";

export default function TabLayout() {
    console.log("TabLayout: Rendering TabLayout");
    return (
        <Tabs 
            screenOptions={{ tabBarActiveTintColor: "blue",
            headerShown: false,
        }}>
            {/* Auth */}
            <Tabs.Screen
                name="index"
                options={{
                    href: null,
                }}
            />
            <Tabs.Screen
                name="register"
                options={{
                    href: null,
                }}
            />

            {/* Authenticated */}
            <Tabs.Screen
                name="profile"
                options={{
                    title: "Profile",
                    tabBarIcon: ({ color }) => (
                        <FontAwesome size={28} name="user" color={color} />
                    ),
                }}
            />
            <Tabs.Screen
                name="home"
                options={{
                    title: "Home",
                    tabBarIcon: ({ color }) => (
                        <FontAwesome size={28} name="home" color={color} />
                    ),
                }}
            />
            <Tabs.Screen
                name="leaderboard"
                options={{
                    title: "Leaderboard",
                    tabBarIcon: ({ color }) => (
                        <FontAwesome size={28} name="first-order" color={color} />
                    ),
                }}
            />
            <Tabs.Screen
                name="game"
                options={{
                    href: null,
                }}
            />
            <Tabs.Screen
                name="addQuestion"
                options={{
                    href: null,
                }}
            />
        </Tabs>
    );
}
