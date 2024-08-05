import React from "react";
import { Modal, View, Text, StyleSheet, Pressable } from "react-native";

// Define the props for the component
interface ErrorMessageProps {
    visible: boolean
    title: string
    message: string
    onDismiss: () => void
}

const ErrorMessage: React.FC<ErrorMessageProps> = ({
    visible,
    title,
    message,
    onDismiss,
}) => {
    return (
        <Modal
            transparent={true}
            animationType="slide"
            visible={visible}
            onRequestClose={onDismiss}
        >
            <View style={styles.modalBackground}>
                <View style={styles.container}>
                    <Text style={styles.titleText}>{title}</Text>
                    <Text style={styles.messageText}>{message}</Text>
                    <Pressable onPress={onDismiss} style={styles.dismissButton}>
                        <Text style={styles.dismissButtonText}>Dismiss</Text>
                    </Pressable>
                </View>
            </View>
        </Modal>
    )
}

const styles = StyleSheet.create({
    modalBackground: {
        flex: 1,
        justifyContent: "flex-end",
        alignItems: "center",
    },
    container: {
        width: "100%",
        padding: 20,
        backgroundColor: "rgba(0, 0, 0, 0.9)",
        borderTopLeftRadius: 10,
        borderTopRightRadius: 10,
        alignItems: "center",
    },
    titleText: {
        fontSize: 18,
        fontWeight: "bold",
        marginBottom: 10,
        color: "#fff",
        fontFamily: "Roboto-Regular",
    },
    messageText: {
        fontSize: 16,
        color: "#fff",
        textAlign: "center",
        fontFamily: "NunitoSans-Regular",
        marginBottom: 20,
    },
    dismissButton: {
        padding: 10,
        backgroundColor: "#d62828",
        borderRadius: 5,
    },
    dismissButtonText: {
        color: "#fff",
        fontWeight: "bold",
        fontFamily: "NunitoSans-Regular",
    },
});

export default ErrorMessage
