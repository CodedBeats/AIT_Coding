package gui.windows;

// import libraries
import javax.swing.JFrame;

public abstract class WindowUI {
    protected JFrame frame;

    public WindowUI(String title, int width, int height) {
        // Create the JFrame
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
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
}

