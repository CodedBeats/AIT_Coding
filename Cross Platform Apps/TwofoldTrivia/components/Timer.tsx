import React, { useState, useEffect, useRef } from "react";
import { View, Text, StyleSheet } from "react-native";

interface TimerProps {
    start: boolean;
    onTimerFinish: () => void;
}

const Timer: React.FC<TimerProps> = ({ start, onTimerFinish }) => {
    const [timeLeft, setTimeLeft] = useState<number>(60)
    // ref to srore timer
    const timerRef = useRef<NodeJS.Timeout | null>(null)

    // handle timer start and interval setup
    useEffect(() => {
        // if  timer is not started exit early
        if (!start) return

        const tick = () => {
            setTimeLeft((prevTime) => {
                if (prevTime === 0) {
                    // callback
                    onTimerFinish()
                    // stop countdown
                    return prevTime
                }
                return prevTime - 1
            });
        };

        // interval to run tick every second
        if (start) {
            timerRef.current = setTimeout(tick, 1000)
        }

        return () => {
            if (timerRef.current) {
                clearTimeout(timerRef.current)
            }
        }
    }, [start, timeLeft, onTimerFinish])

    // handle countdown and reset logic
    useEffect(() => {
        if (timeLeft > 0 && start) {
            // timeLeft -=1 after 1s
            timerRef.current = setTimeout(() => setTimeLeft(timeLeft - 1), 1000)
        } else if (timeLeft === 0) {
            // callback
            onTimerFinish()
        }

        // clear timeout
        return () => {
            if (timerRef.current) {
                clearTimeout(timerRef.current);
            }
        }
    }, [timeLeft, start]);

    // format time in MM:SS
    const formatTime = (seconds: number): string => {
        // calc min
        const mins = Math.floor(seconds / 60)
        // calc sec
        const secs = seconds % 60
        return `${mins}:${secs < 10 ? "0" : ""}${secs}`;
    };

    return (
        <View style={styles.timerContainer}>
            <Text style={styles.timerText}>{formatTime(timeLeft)}</Text>
        </View>
    );
};

const styles = StyleSheet.create({
    timerContainer: {
        justifyContent: "center",
        alignItems: "center",
        padding: 20,
        backgroundColor: "#f0f0f0",
        borderRadius: 10,
    },
    timerText: {
        fontSize: 75,
        fontWeight: "bold",
    },
});

export {Timer};
