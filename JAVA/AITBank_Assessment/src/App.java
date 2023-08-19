/*
*   ===== Project Notes =====
*   1. The project was coded on the VS Code IDE, 
        I don't beleive there are any changes needed when converting to Netbeans, but please be open to potential difference they have that could cause errors
*
*    
*   ===== Account Details =====
*   1. account balance, daily withdraw limit and names are generated randomly
*   2. Enter different card type from home screen to test different account types
*   3. Account PINs are as follows:
    *       Cheque Accout - 7777
    *       Fixed Accout - 5555
    *       Net-Saver Accout - 2020
    *       Savings Accout - 1234
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
