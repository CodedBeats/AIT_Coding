package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

public class ButtonKeyListeners implements KeyListener {
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;

    public ButtonKeyListeners(JButton btn1, JButton btn2, JButton btn3, JButton btn4) {
        this.btn1 = btn1;
        this.btn2 = btn2;
        this.btn3 = btn3;
        this.btn4 = btn4;

        btn1.addKeyListener(this);
        btn2.addKeyListener(this);
        btn3.addKeyListener(this);
        btn4.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_1) {
            btn1.doClick();
        } 
        else if (key == KeyEvent.VK_2) {
            btn2.doClick();
        } 
        else if (key == KeyEvent.VK_3) {
            btn3.doClick();
        } 
        else if (key == KeyEvent.VK_4) {
            btn4.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
