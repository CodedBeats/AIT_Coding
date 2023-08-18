/*
*    ===== Project Notes =====
*    1. The project was coded on the VS Code IDE, I don't beleive there are any changes needed when converting to Netbeans, but please be open to potential difference they have that could cause errors
*
*    
*    ===== ASSUMPTION NOTES =====
*    1. 
*/

import gui.GUIHandler;

public class App {
    public static void main(String[] args) throws Exception {
        GUIHandler guiHandler = new GUIHandler();
        // guiHandler.handleHomeUI();
        guiHandler.handleLogin();
    }
}
