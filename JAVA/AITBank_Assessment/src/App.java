/*
*   ===== Project Notes =====
*   1. The project was coded on the VS Code IDE, 
        I don't beleive there are any changes needed when converting to Netbeans, but please be open to potential difference they have that could cause errors
*   2. Interest hasn't changed since assessment 1, all tests of it passed then so it wont be checked here. Since this is just UI it won't be called anywhere
        If you still want to check, just call the function on the necessary account type in GUIHandler.java
*   3. Project style isn't supposed to be ideal in UX, it's more just a demonstraction of different colors
*
*    
*   ===== Account Details =====
*   1. account balance, daily withdraw limit and names are generated randomly
*   2. Enter different card type from home screen to test different account types
*   3. Account PINs are as follows:
    *       Cheque Accout - 7777
    *       Fixed Accout - 5555
    *       Net-Saver Accout - 1397
    *       Savings Accout - 1234
*/


// import gui handler
import gui.GUIHandler;

public class App {
    public static void main(String[] args) throws Exception {
        // create gui handler
        GUIHandler guiHandler = new GUIHandler();
        // handle each ui window (not handled themselves within the handler)
        guiHandler.handleHomeUI();
        guiHandler.handleLoginUI();
        guiHandler.handleDashbaordUI();
        guiHandler.handleWithdrawUI();
        guiHandler.handleDepositUI();
    }
}
