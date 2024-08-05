import React from "react";
import { Modal, View, Text, Pressable, StyleSheet } from "react-native";

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
                        <Pressable onPress={onConfirm} style={styles.btn}>
                            <Text style={styles.btnText}>Yes</Text>
                        </Pressable>
                        <Pressable onPress={onCancel} style={styles.btn}>
                            <Text style={styles.btnText}>No</Text>
                        </Pressable>
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
        backgroundColor: "rgba(0, 0, 0, 0.8)",
    },
    container: {
        width: 300,
        padding: 20,
        backgroundColor: "#af3dbe",
        borderRadius: 10,
        alignItems: "center",
    },
    messageText: {
        fontSize: 20,
        marginBottom: 20,
        textAlign: "center",
        fontFamily: "NunitoSans-Regular",
    },
    buttonContainer: {
        flex: 1,
        gap: 10,
        width: "100%",
    },
    btn: {
        padding: 10,
        backgroundColor: "#d55de0",
        borderWidth: 2,
        borderColor: "#000",
        borderRadius: 10,
        shadowColor: "#000",
        shadowOffset: { width: 4, height: 4 },
        shadowOpacity: 0.8,
    },
    btnText: {
        textAlign: "center",
        fontSize: 25,
        fontWeight: "bold",
        fontFamily: "NunitoSans-Regular",
    }
});

export default ConfirmationModal;
