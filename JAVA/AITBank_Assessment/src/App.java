/*
*    ===== Project Notes =====
*    1. The project was coded on the VS Code IDE, I don't beleive there are any changes needed when converting to Netbeans, but please be open to potential difference they have that could cause errors
*
*    
*    ===== ASSUMPTION NOTES =====
*    1. 
*/


// import gui
import gui.GUIHandler;

public class App {
    public static void main(String[] args) throws Exception {
        // create gui handler
        GUIHandler guiHandler = new GUIHandler();
        // handle each ui window
        guiHandler.handleHomeUI();
        guiHandler.handleLoginUI();
        guiHandler.handleDashbaordUI();
        guiHandler.handleWithdrawUI();
        guiHandler.handleDepositUI();
    }
}
