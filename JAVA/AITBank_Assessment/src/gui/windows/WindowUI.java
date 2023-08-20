package gui.windows;

// import libraries
import javax.swing.JFrame;
import java.awt.*;

public abstract class WindowUI {
    protected JFrame frame;

    public WindowUI(String title, int width, int height) {
        // Create the JFrame
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);

        // Get the size of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            
        // Calculate the center position for the frame
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        
        // Set the frame's location to the calculated position
        frame.setLocation(x, y);
    }

    // Set frame visibility
    public void setFrameVisibility() {
        // Set frame visible if it's hidden
        if (!frame.isShowing()) {
            frame.setVisible(true);
        }
        // Hide frame
        else {
            frame.setVisible(false);
        }
    }

    // Abstract method for initializing UI components
    protected abstract void initComponents();
    // Abstract method for styling components
    protected abstract void setComponentStyle();
}

