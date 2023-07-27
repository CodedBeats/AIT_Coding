import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class MultithreadingGUI {
    // init JFrame components
    private JFrame frame;
    private JButton threadButton;
    private JButton sleepButton;
    private JButton setText1;
    private JButton setText2;
    private JLabel outputText;

    public MultithreadingGUI() {
        // setup JFrame
        frame = new JFrame("Multithreading GUI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // create buttons
        threadButton = new JButton("Sleep (Thread)");
        sleepButton = new JButton("Sleep (No Thread)");
        setText1 = new JButton("Set Text1");
        setText2 = new JButton("Set Text2");

        // create text field
        outputText = new JLabel("(text will go here)");


        // === add functionality to buttons === //
        // add sleeping thread function
        threadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                threadFunc(true);
            }
        });

        // add sleeping program function
        sleepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonThreadFunc(true);
            }
        });

        // add set text1 function
        setText1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                threadFunc(false);
            }
        });

        // add set text2 function
        setText2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonThreadFunc(false);
            }
        });


        // === add buttons with their functionality to frame === //
        frame.add(threadButton);
        frame.add(sleepButton);
        frame.add(setText1);
        frame.add(setText2);
        frame.add(outputText);
        frame.pack();
        frame.setSize(1000,100);
        frame.setVisible(true);
    }


    // === define button functionality === //
    // (refactor these functions to seperate setText functionality)
    // function to sleep thread and setText1
    private void threadFunc(boolean withSleep) {
        // create new thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // sleep thread 5s
                if (withSleep) {
                    try {
                        // Thread.sleep(5000); // Sleep for 5 seconds (5000 milliseconds)
                        System.out.println("Thread going to sleep");
                        TimeUnit.SECONDS.sleep(5); // Sleep for 5 seconds
                        System.out.println("Thread woke up");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // setText1
                else {
                // set output text
                outputText.setText("Hi, I hate File IO");
                }
            }
        });

        // Start the calculation thread
        thread.start();
    }

    // function to sleep program and setText2
    private void nonThreadFunc(boolean withSleep) {
        if (withSleep) {
            try {
                System.out.println("Program going to sleep");
                TimeUnit.SECONDS.sleep(5); // Sleep for 5 seconds
                System.out.println("Program woke up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // setText2
        else {
            // set output text
            outputText.setText("Hi, I love lambda functions");
        }
    }


    // === run program === //
    public static void main(String[] args) {
        new MultithreadingGUI();
    }
}
