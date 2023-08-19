/*
*    ===== Project Notes =====
*    1. The project was coded on the VS Code IDE, I don't beleive there are any changes needed when converting to Netbeans, but please be open to potential difference they have that could cause errors
*
*    
*    ===== ASSUMPTION NOTES =====
*    1. 
*/

import accounts.SavingsAccount;
import gui.GUIHandler;

public class App {
    public static void main(String[] args) throws Exception {
        // create test account
        SavingsAccount acc = new SavingsAccount(100, 1, "Luca", null, "savings", 1234, 50, 0, true);

        GUIHandler guiHandler = new GUIHandler();
        guiHandler.handleHomeUI();
        guiHandler.handleLogin(acc.getAccPIN());
        guiHandler.handleDashbaord(acc.getAccName());
    }
}
