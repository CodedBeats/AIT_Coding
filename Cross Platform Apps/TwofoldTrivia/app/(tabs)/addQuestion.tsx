import React, { useState, useContext } from "react";
import { View, Text, TextInput, Button, StyleSheet, Alert, SafeAreaView } from "react-native";
import { collection, addDoc } from "firebase/firestore";
import { DBContext } from "@/contexts/DBContext";

export default function AddQuestionScreen() {
    const [word, setWord] = useState("");
    const [option1, setOption1] = useState("");
    const [option2, setOption2] = useState("");
    const [correctAnswer, setCorrectAnswer] = useState<number | null>(null);

    const db = useContext(DBContext);

    const handleAddQuestion = async () => {
        if (!word || !option1 || !option2 || correctAnswer === null) {
            Alert.alert("Error", "Please fill in all fields.");
            return;
        }

        try {
            await addDoc(collection(db, "questions"), {
                word,
                option1,
                option2,
                correctAnswer,
            });
            Alert.alert("Success", "Question added successfully.");
            setWord("");
            setOption1("");
            setOption2("");
            setCorrectAnswer(null);
        } catch (error) {
            console.error("Error adding question: ", error);
            Alert.alert("Error", "Failed to add question.");
        }
    };

    return (
        <SafeAreaView style={styles.container}>
            <Text style={styles.title}>Add New Question</Text>
            <TextInput
                style={styles.input}
                placeholder="Word"
                value={word}
                onChangeText={setWord}
            />
            <TextInput
                style={styles.input}
                placeholder="Option 1"
                value={option1}
                onChangeText={setOption1}
            />
            <TextInput
                style={styles.input}
                placeholder="Option 2"
                value={option2}
                onChangeText={setOption2}
            />
            <TextInput
                style={styles.input}
                placeholder="Correct Answer (1 or 2)"
                value={correctAnswer !== null ? correctAnswer.toString() : ""}
                keyboardType="numeric"
                onChangeText={(text) => setCorrectAnswer(parseInt(text, 10))}
            />
            <Button title="Add Question" onPress={handleAddQuestion} />
        </SafeAreaView>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        padding: 20,
    },
    title: {
        fontSize: 24,
        marginBottom: 20,
    },
    input: {
        width: "80%",
        padding: 10,
        marginVertical: 10,
        borderWidth: 1,
        borderColor: "#ccc",
        borderRadius: 5,
    },
});
