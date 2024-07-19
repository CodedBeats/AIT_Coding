import { View, Text, StyleSheet, Pressable, FlatList } from "react-native"
import { useRouter } from "expo-router"
import { useState } from "react"

// components
import { Timer } from "../../components/Timer"

export default function NewScreen(props: any) {
    const [score, setScore] = useState(0)
    const [timerStarted, setTimerStarted] = useState(false)
    const [timerFinished, setTimerFinished] = useState(false)
    const [canPlayGame, setCanPlayGame] = useState(false)

    const router = useRouter()

    // start game loop
    const startTimer = () => {
        // reset score
        setScore(0)

        // allow user to click
        setCanPlayGame(prevState => !prevState)

        // start timer
        setTimerStarted(true)
        setTimerFinished(false)
    }

    // finish game loop
    const handleTimerFinish = () => {
        setTimerFinished(true)
        // stop user being able to click
        setCanPlayGame(prevState => !prevState)
    }


    return (
        <View style={styles.container}>
            <Text>Game</Text>
            <Pressable onPress={() => router.replace("/")}>
                <Text>Home</Text>
            </Pressable>

            {/* === timer and play btn === */}
            <View>
            {!timerFinished && <Timer start={timerStarted} onTimerFinish={handleTimerFinish} />}
            {!timerStarted && (
                <Pressable onPress={startTimer}><Text style={styles.playBtn}>PLAY</Text></Pressable>
            )}
            {timerFinished && 
                <View>
                    <Text style={styles.timeIsUp}>Time is up!</Text>
                    <Pressable onPress={startTimer}><Text style={styles.playBtn}>PLAY</Text></Pressable>
                </View>
            }
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        padding: 20,
    },
    score: {
      fontSize: 20,
      marginTop: 10,
    },
    timeIsUp: {
      fontSize: 20,
      fontWeight: "bold",
      padding: 10,
      borderRadius: 10,
      color: "black",
      backgroundColor: "#bbb",
      margin: 10,
    },
    playBtn: {
      fontSize: 30,
      fontWeight: "bold",
      padding: 20,
      borderRadius: 10,
      color: "white",
      backgroundColor: "#222",
      textAlign: "center",
    },
});