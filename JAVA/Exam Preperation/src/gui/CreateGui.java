package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateGui {
    // define attributes for GUI
    // window
    JFrame w1;
    // label
    JLabel l1;
    JLabel l2;
    // text field
    JTextField field1;
    JTextField field2;
    // button 
    JButton btn1;
    JButton btn2;
    
    // create GUI method
    public void createGUI() {
        w1 = new JFrame("gui test");
        // set window bounds
        w1.setBounds(100, 100, 500, 300);
        w1.getContentPane().setBackground(Color.BLACK);
        
        // set layout
        GridLayout grid = new GridLayout(3, 2); // 3 rows, 2 columns
        w1.setLayout(grid);
        
        // create new jframe elements from references
        // labels
        l1 = new JLabel("Label 1", SwingConstants.CENTER);
        l2 = new JLabel("Label 2", SwingConstants.CENTER);
        // text fields
        field1 = new JTextField();
        field2 = new JTextField();
        // buttons
        btn1 = new JButton("clear");
        btn2 = new JButton("Exit");
        
        // set element styles
        // labels
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        // buttons
        btn1.setBackground(Color.GRAY);
        btn1.setForeground(Color.WHITE);
        btn2.setBackground(Color.GRAY);
        btn2.setForeground(Color.WHITE);
        
        // add elements to window in layout format
        w1.add(l1);             w1.add(l2);
        w1.add(field1);         w1.add(field2);
        w1.add(btn1);           w1.add(btn2);
        
        // add action listeners to buttons
        btn1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                field1.setText(null);
                field2.setText(null);
            } 
        });
        btn2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                System.exit(0);
            } 
        });
        
        // show frame
        w1.setVisible(true);
    }
}
