package gui.reusable_components;

// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeypadPanel extends JPanel {
    private JTextField textField;
    private boolean hasDecimalPoint = false;
    private boolean isMoney = false;

    public KeypadPanel() {
        setLayout(new BorderLayout());

        // Create the text field at the top
        textField = new JTextField();
        textField.setEditable(false); // Make the text field non-editable
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 3)); // 4 rows, 3 columns

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
                    System.out.println(btnTxt);
                    
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
                        getTextField();
                        return;
                    }  
                    else {
                        // set hasDecimalPoint to true if btn was "."
                        if (btnTxt.equals(".")) {
                            hasDecimalPoint = true;
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

    public double getTextField() {
        double txtFieldVal;
        
        // remove "$" from start of text field
        if (isMoney) {
            // convert text field data to double
            txtFieldVal = Double.parseDouble(textField.getText().substring(1));
        }
        else {
            // convert text field data to double
            txtFieldVal = Double.parseDouble(textField.getText());
        }
        System.out.println(txtFieldVal);
        return txtFieldVal;
    }

    public void setTxtFieldType() {
        isMoney = true;

        String currentTxt = textField.getText();
        String newText = "$" + currentTxt;
        textField.setText(newText);
    }
}

