/*
    ===== ASSUMPTION =====
    User knows the commands are:
        Change color - "r" (red), "b" (blue), "g" (green), "y" (yellow)
        Change brush size - "+" to increase brush size (without shift so it's technically "="), "-" to decrease brush size
        Erase - "Backspace" (can change brush size while erasing)
*/

// package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawSomething extends JApplet implements KeyListener {
    //
    private int xValue = 200;
    private int yValue = 200;
    private int size = 10;
    private String uiInfo = "Current Color and Brush Size";
    private Color backgroundColor = new Color(0, 0, 0);
    private Color myColor = new Color(255, 0, 0); // red default brush color
    private boolean changingSize = false;
    private boolean erasing = false;
    private boolean colorChanging = false;
    private int state = 1; // 1 for drawing, 0 for erasing

    @Override
    public void init() {
        // create and handle mouse movement
        mouseMotionHandler myMove = new mouseMotionHandler();
        addMouseMotionListener(myMove);
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_EQUALS:
                System.out.println("+");
                // stop brush size getting too big
                if (size >= 50) return ;
                // increase brush size
                changingSize = true;
                size += 5;
                break;
            case KeyEvent.VK_MINUS:
                System.out.println("-");
                // stop brush size getting too small
                if (size <= 10) return ;
                // reduce brush size
                changingSize = true;
                size -= 5;
                break;
            case KeyEvent.VK_R:
                System.out.println("red");
                myColor = Color.RED;
                changingSize = false;
                colorChanging = true;
                state = 1;
                break;
            case KeyEvent.VK_G:
                System.out.println("green");
                myColor = Color.GREEN;
                changingSize = false;
                colorChanging = true;
                state = 1;
                break;
            case KeyEvent.VK_B:
                System.out.println("blue");
                myColor = Color.BLUE;
                changingSize = false;
                colorChanging = true;
                state = 1;
                break;
            case KeyEvent.VK_Y:
                System.out.println("yellow");
                myColor = Color.YELLOW;
                changingSize = false;
                colorChanging = true;
                state = 1;
                break;
            case KeyEvent.VK_BACK_SPACE:
                System.out.println("eraser");
                // change color to black and increase draw size
                myColor = Color.BLACK;
                changingSize = false;
                erasing = true;
                state = 0;
                size = 50;
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        return;
    }
    
    // mouse movement input class
    private class mouseMotionHandler extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e) {
            changingSize = false;
            erasing = false;
            colorChanging = false;
            xValue = e.getX();
            yValue = e.getY();
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        // set fram res
        setSize(500, 500);
        // set background color
        setBackground(backgroundColor);
        
        // reset brush size and color indicator when changing size
        if (state == 1) {
            if (changingSize || colorChanging) {
                resetUiInfo(g);  
            }
            // set string color
            g.setColor(myColor);
            g.drawString(uiInfo, 10, 20);
        }
        
        // display UI info in top left
        // change UI info if erasing to show black color
        if (state == 0) {
            if (erasing || changingSize) {
                resetUiInfo(g); 
            }
            handleEraser(g);
        }
        g.setColor(myColor);
        g.fillOval(30, 30, size, size);
        g.fillOval(xValue, yValue, size, size);
    }
    
    public void resetUiInfo(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 180, 100);
    }
    
    public void handleEraser(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Now Erasing", 10, 20);
        g.fillOval(28, 28, size + 4, size + 4);
    }
}
