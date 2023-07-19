// package pkg12030_luca_tut7_task1; not needed in VSCode

import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;

public class GUISetup implements ActionListener {
    // init calculator variabls
    String operator;
    double num1, num2;

    // init buttons and text field
    JButton btnAdd, btnSubtract, btnMultiply, btnDivide, btnEquals, btnClear, btnExit;
    JTextField inputField, ansField;
    // init calc info
    JLabel operatorVal;
    
    public void createGUI() {
        JFrame jframe = new JFrame(); 
        // set layout style
        FlowLayout flow = new FlowLayout();
        jframe.setLayout(flow);
        jframe.setSize(300, 250);
        
        inputField = new JTextField(15); 
        ansField = new JTextField(7); 
        ansField.setEditable(false);
        
        btnAdd = new JButton("+");
        btnSubtract = new JButton("-");
        btnMultiply = new JButton("x");
        btnDivide = new JButton("/");
        btnEquals = new JButton("=");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

        operatorVal = new JLabel("Operator: ");
        
        jframe.add(inputField);
        jframe.add(ansField);
        
        jframe.add(btnAdd);    
        jframe.add(btnSubtract);
        jframe.add(btnMultiply);    
        jframe.add(btnDivide);
        jframe.add(btnEquals);    
        jframe.add(btnClear);
        jframe.add(btnExit);  

        jframe.add(operatorVal);
        
        // add event listeners to each button
        btnAdd.addActionListener(this);
        btnSubtract.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDivide.addActionListener(this);
        btnEquals.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
        // add even listeners to input field
        inputField.addActionListener(this);
        ansField.addActionListener(this);
        
        jframe.setVisible(true);
    }  
    
    // handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) { 
        // xx
        if (e.getSource() == btnAdd) {
            handleNumInput();
            operator = "+";
            operatorVal.setText("Operator: +");
        }
        else if (e.getSource() == btnSubtract) {
            handleNumInput();
            operator = "-";
            operatorVal.setText("Operator: -");
        }
        else if (e.getSource() == btnMultiply) {
            handleNumInput();
            operator = "*";
            operatorVal.setText("Operator: x");
        }
        else if (e.getSource() == btnDivide) {
            handleNumInput();
            operator = "/";
            operatorVal.setText("Operator: /");
        }
        else if (e.getSource() == btnEquals) {
            handleNumInput();
            double ans = handleOperations(operator);
            ansField.setText(String.format("%f", ans));
            
        }
        else if (e.getSource() == btnClear) {
            // clear field and reset variables
            inputField.setText("");
            ansField.setText("");
            operatorVal.setText("Operator: ");
            num1 = 0;
            num2 = 0;
            operator = "";
        }
        else if (e.getSource() == btnExit) {
            // System.out.println("exit");
            System.exit(0);
        }

        System.out.println(inputField.getText());
    }
    
    
    // handle operations
    public double handleOperations(String operator) {
        double ans = 0;
        if (operator.equals("+")) {
            ans = num1 + num2;
        }
        else if (operator.equals("-")) {
            ans = num1 - num2;
        }
        else if (operator.equals("*")) {
            ans = num1 * num2;
        } 
        else if (operator.equals("/")) {
            ans = num1 / num2;
        } 
        return ans;
    }


    // handle num input
    public void handleNumInput() {
        if (num1 == 0) {
            num1 = Double.parseDouble(inputField.getText());
            System.out.println("Num1: "+ num1);
            inputField.setText("");
        }
        else if (num2 == 0) {
            num2 = Double.parseDouble(inputField.getText());
            System.out.println("Num2: "+ num2);
            inputField.setText("");
        }
    }
}
