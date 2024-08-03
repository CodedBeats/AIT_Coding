import React from "react";
import { Modal, View, Text, Button, StyleSheet } from "react-native";

// Define the props for the component
interface ConfirmationDialogProps {
    visible: boolean;
    message: string;
    onConfirm: () => void;
    onCancel: () => void;
}

const ConfirmationModal: React.FC<ConfirmationDialogProps> = ({
    visible,
    message,
    onConfirm,
    onCancel,
}) => {
    return (
        <Modal
            transparent={true}
            animationType="slide"
            visible={visible}
            onRequestClose={onCancel}
        >
            <View style={styles.modalBackground}>
                <View style={styles.container}>
                    <Text style={styles.messageText}>{message}</Text>
                    <View style={styles.buttonContainer}>
                        <Button title="Yes" onPress={onConfirm} />
                        <Button title="No" onPress={onCancel} />
                    </View>
                </View>
            </View>
        </Modal>
    );
};

const styles = StyleSheet.create({
    modalBackground: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: "rgba(0, 0, 0, 0.5)",
    },
    container: {
        width: 300,
        padding: 20,
        backgroundColor: "#fff",
        borderRadius: 10,
        alignItems: "center",
    },
    messageText: {
        fontSize: 16,
        marginBottom: 20,
        textAlign: "center",
    },
    buttonContainer: {
        flexDirection: "row",
        justifyContent: "space-between",
        width: "100%",
    },
});

export default ConfirmationModal;
