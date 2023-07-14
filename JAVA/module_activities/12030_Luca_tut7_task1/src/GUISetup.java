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
    JTextField inputField;
    
    public void createGUI() {
        JFrame jframe = new JFrame(); 
        // set layout style
        FlowLayout flow = new FlowLayout();
        jframe.setLayout(flow);
        jframe.setSize(300, 250);
        
        inputField = new JTextField(25); 
        
        btnAdd = new JButton("+");
        btnSubtract = new JButton("-");
        btnMultiply = new JButton("x");
        btnDivide = new JButton("/");
        btnEquals = new JButton("=");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");
        
        jframe.add(inputField);
        
        jframe.add(btnAdd);    
        jframe.add(btnSubtract);
        jframe.add(btnMultiply);    
        jframe.add(btnDivide);
        jframe.add(btnEquals);    
        jframe.add(btnClear);
        jframe.add(btnExit);  
        
        // add event listeners to each button
        btnAdd.addActionListener(this);
        btnSubtract.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDivide.addActionListener(this);
        btnEquals.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
        // add even listeners to input field
        
        jframe.setVisible(true);
    }  
    
    // handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) { 
        // xx
        if (e.getSource() == btnAdd) {
            // System.out.println("+");
            operator = "+";
        }
        else if (e.getSource() == btnSubtract) {
            // System.out.println("-");
            operator = "-";
        }
        else if (e.getSource() == btnMultiply) {
            // System.out.println("*");
            operator = "*";
        }
        else if (e.getSource() == btnDivide) {
            // System.out.println("/");
            operator = "/";
        }
        else if (e.getSource() == btnEquals) {
            // System.out.println("=");
            double ans = handleOperations(2, 2, "+");
            System.out.println(ans);
        }
        else if (e.getSource() == btnClear) {
            // System.out.println("clear");
            // clear field and reset variables
            inputField.setText("");
            num1 = 0;
            num2 = 0;
            operator = "";
        }
        else if (e.getSource() == btnExit) {
            // System.out.println("exit");
            System.exit(0);
        }
    }
    
    
    // handle operations
    public double handleOperations(double num1, double num2, String operator) {
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
}
