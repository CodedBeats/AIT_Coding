package gui.reusable_components;

// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeypadPanel extends JPanel {
    // init JFrame elements
    JPanel buttonPanel;
    private JTextField textField;

    // class attributes
    private boolean hasDecimalPoint = false;

    public KeypadPanel(boolean isMoney, boolean isLogin) {

        // set layout
        setLayout(new BorderLayout());

        // Create the text field at the top
        textField = new JTextField();
        textField.setEditable(false); // Make the text field non-editable
        add(textField, BorderLayout.NORTH);
        // add "$" at the start if this is a money field
        if (isMoney) {
            textField.setText("$");
        }

        // create panel
        buttonPanel = new JPanel(new GridLayout(4, 3)); // 4 rows, 3 columns

        String[] keypadBtns = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            ".", "0", "Del"
        };

        for (String label : keypadBtns) {
            JButton button = new JButton(label);

            // Add event on button click
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String btnTxt = e.getActionCommand();
                    // System.out.println(btnTxt);
                    
                    // delete single value
                    if (btnTxt.equals("Del")) {
                        String currentText = textField.getText();

                        // don't delete "$" text
                        if (currentText.equals("$")) {
                            return;
                        }
                        // make sure text field isn't empty
                        else if (!currentText.isEmpty()) {
                            // Remove the last character from the text field
                            textField.setText(currentText.substring(0, currentText.length() - 1));

                            // remove hasDecimalPoint if it gets deleted
                            if (currentText.substring((currentText.length() - 1)).equals(".")) {
                                hasDecimalPoint = false;
                            }
                        }
                    }
                    // only allow 1 decimal point
                    else if (btnTxt.equals(".") && hasDecimalPoint) {
                        return;
                    }  
                    else {
                        // get length of text field
                        String currentText = textField.getText();

                        // set hasDecimalPoint to true if btn was "." and !login mode
                        if (btnTxt.equals(".") && !isLogin) {
                            hasDecimalPoint = true;
                        }
                        // don't allow "." in login mode
                        else if (btnTxt.equals(".") && isLogin) {
                            return;
                        }
                        // don't allow more than 4 digits in login mode
                        else if (isLogin && currentText.length() == 4) {
                            return;
                        }

                        // Append the btn text to the text field
                        textField.setText(textField.getText() + btnTxt);
                    }
                }
            });

            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    public double getMoneyValue() {
        double txtFieldVal = Double.parseDouble(textField.getText().substring(1));
        return txtFieldVal;
    }

    public int getPINValue() {
        int txtFieldVal = Integer.parseInt(textField.getText());
        return txtFieldVal;
    }
}

