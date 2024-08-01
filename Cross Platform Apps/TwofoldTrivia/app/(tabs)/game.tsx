// dependencies
import { View, Text, StyleSheet, Pressable, SafeAreaView } from "react-native"
import { useState, useEffect, useContext } from "react"
import { collection, getDocs, doc, getDoc, updateDoc} from "firebase/firestore"

// context
import { DBContext } from "@/contexts/DBContext"
import { AuthContext } from "@/contexts/AuthContext"

// components
import { Timer } from "../../components/Timer"


// type for document structure
interface WordDocument {
    word: string;
    option1: string;
    option2: string;
    correctAnswer: number;
}


export default function GameScreen(props: any) {
    const [score, setScore] = useState(0)
    const [timerStarted, setTimerStarted] = useState(false)
    const [timerFinished, setTimerFinished] = useState(false)
    const [documents, setDocuments] = useState([]);
    const [currentQuestion, setCurrentQuestion] = useState<WordDocument | null>(null)
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    
    const db = useContext(DBContext)
    const auth = useContext(AuthContext)

    // fetch data
    useEffect(() => {
        const fetchData = async () => {
            setLoading(true)
            try {
                const querySnapshot = await getDocs(collection(db, "questions"))
                const docsArray: any = querySnapshot.docs.map(doc => doc.data())
                console.log(docsArray)
                setDocuments(docsArray)
            } catch (err: any) {
                setError(err)
            } finally {
                setLoading(false)
            }
        };
        fetchData()
    }, [timerFinished])

    // get random question
    const getRandomDocument = () => {
        if (documents.length <= 1) {
            // no docs left -> end timer
            handleTimerFinish()
            console.log("all questions answered")

            return null
        }
        const randomIndex = Math.floor(Math.random() * documents.length)
        const selectedDocument = documents[randomIndex]
        setDocuments(prevDocuments => [
            ...prevDocuments.slice(0, randomIndex),
            ...prevDocuments.slice(randomIndex + 1)
        ])
        return selectedDocument
    }

    // start game loop
    const startTimer = () => {
        // get random from all questions
        const randomQuestion = getRandomDocument()
        setCurrentQuestion(randomQuestion)
        console.log(randomQuestion)

        // reset score
        setScore(0)

        // start timer
        setTimerStarted(true)
        setTimerFinished(false)
    }

    // handle option choice
    const handleOptionClick = (optionIndex: number) => {
        // check if answer is correct
        if (optionIndex == currentQuestion?.correctAnswer) {
            setScore(prevScore => prevScore + 1)
        }

        // console.log(documents)
        // get new random question
        const newQuestion = getRandomDocument()
        setCurrentQuestion(newQuestion)
    }

    // handle updating the user's high score
    const handleUpdateHighScore = async () => {
        // get auth user
        const user = auth.currentUser

        if (user) {
            // get db user
            const userDocRef = doc(db, "users", user.uid)
            const userDoc = await getDoc(userDocRef)

            if (userDoc.exists()) {
                // get user data
                const userData = userDoc.data()
                console.log(userData.highscore)

                // update high score if necessary
                const newHighScore = score > userData.highscore ? score : userData.highscore
                await updateDoc(userDocRef, {
                    highscore: newHighScore
                })
            } else {
                console.log("no user doc")
            }
        } else {
            console.log("no user signed in")
        }
    }

    // finish game loop
    const handleTimerFinish = () => {
        setTimerFinished(true)
        handleUpdateHighScore()
    }


    return (
        <SafeAreaView style={styles.container}>
            <View>
                <Text style={styles.title}>Twofold Trivia</Text>
            </View>

            {/* question prompt */}
            <View>
                {currentQuestion ? (
                    <Text style={styles.word}>{currentQuestion.word}</Text>
                ) : (
                    <Text></Text>
                )}
            </View>

            {/* options */}
            {currentQuestion ? (
                <View style={styles.optionsContainer}>
                <Pressable 
                    onPress={() => handleOptionClick(1)}
                    style={[styles.optionBtn, styles.optionBtn1]}
                >
                    <Text style={styles.optionText}>{currentQuestion.option1}</Text>
                </Pressable>
                <Pressable 
                    onPress={() => handleOptionClick(2)}
                    style={[styles.optionBtn, styles.optionBtn2]}
                >
                    <Text style={styles.optionText}>{currentQuestion.option2}</Text>
                </Pressable>
                </View>
            ) : (
                <View style={styles.optionsContainer}>
                    <Pressable style={[styles.optionBtn, styles.optionBtn1]}></Pressable>
                    <Pressable style={[styles.optionBtn, styles.optionBtn2]}></Pressable>
                </View>
            )}

            

            <View style={styles.stats}>
                {/* dynamic score */}
                <View>
                    <Text style={styles.score}>Score: {score}</Text>
                </View>

                {/* === timer and play btn === */}
                {!timerFinished && <Timer start={timerStarted} onTimerFinish={handleTimerFinish} />}
                {!timerStarted && (
                    <Pressable onPress={startTimer}><Text style={styles.playBtn}>PLAY</Text></Pressable>
                )}
                {timerFinished && 
                    <View>
                        <Text style={styles.timeIsUp}>Time is up!</Text>
                        <Text style={styles.timeIsUp}>Final Score: {score}</Text>
                        <Pressable onPress={startTimer}><Text style={styles.playBtn}>PLAY</Text></Pressable>
                    </View>
                }
            </View>
        </SafeAreaView>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 20,
    },
    title: {
        fontSize: 35,
        fontWeight: "bold",
        textAlign: "center",
        margin: 15,
    },
    word: {
        fontSize:50,
        fontWeight: "bold",
        margin: 30,
        textAlign: "center",
    },
    optionsContainer: {
        flexDirection: "row",
        justifyContent: "space-around",
        marginBottom: 20,
    },
    optionBtn: {
        width: "45%",
        fontSize: 20,
        padding: 10,
        paddingTop: 30,
        paddingBottom: 30,
        borderRadius: 10,
        backgroundColor: "#FFFF00",
        margin: 10,
        borderWidth: 1,
        borderColor: "#ccc",
        marginBottom: 5,
        textAlign: "center",
    },
    optionBtn1: {
        backgroundColor: "#630000",
    },
    optionBtn2: {
        backgroundColor: "#00016C",
    },
    optionText: {
        color: "white",
        fontWeight: "bold",
        fontSize: 20,
        textAlign: "center",
    },
    stats: {

    },
    score: {
        fontSize: 20,
        marginTop: 10,
        alignSelf: "center",
        textAlign: "center",
    },
    timeIsUp: {
        fontSize: 20,
        fontWeight: "bold",
        padding: 10,
        borderRadius: 10,
        color: "black",
        backgroundColor: "#bbb",
        margin: 10,
        textAlign: "center",
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