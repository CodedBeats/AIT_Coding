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
    JButton btn3;
    JButton btn4;
    
    // create GUI method
    public void createGUI() {
        w1 = new JFrame("GUI");
        // set window bounds (w y, w, h)
        w1.setBounds(100, 100, 500, 300);
        w1.getContentPane().setBackground(Color.BLACK);
        
        // set layout
        GridLayout grid = new GridLayout(4, 2); // 4 rows, 2 columns
        w1.setLayout(grid);
        
        // create new jframe elements from references
        // labels
        l1 = new JLabel("Label 1", SwingConstants.CENTER);
        l2 = new JLabel("Label 2", SwingConstants.CENTER);
        // text fields
        field1 = new JTextField();
        field2 = new JTextField();
        // buttons
        btn1 = new JButton("rand");
        btn2 = new JButton("updateText");
        btn3 = new JButton("clear");
        btn4 = new JButton("Exit");
        
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
        w1.add(btn3);           w1.add(btn4);
        
        // add action listeners to buttons
        // set random number to l1 and field1
        btn1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                int randomNum = (int) (Math.random() * 100); // Generate a random number between 0 and 99
                field1.setText(Integer.toString(randomNum));
                l1.setText("Random Number: " + randomNum);
            } 
        });
        // update text of l2 and field2
        btn2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                String newText = "Updated Text";
                field2.setText(newText);
                l2.setText(newText);
            } 
        });
        btn3.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                field1.setText(null);
                field2.setText(null);
            } 
        });
        btn4.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                System.exit(0);
            } 
        });

        // Create key listeners instance
        new ButtonKeyListeners(btn1, btn2, btn3, btn4);
        
        // show frame
        w1.setVisible(true);
    }
}
