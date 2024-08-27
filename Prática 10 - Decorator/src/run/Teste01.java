package run;

import mainGUI.framework.MainGUIFramework;
import mainGUI.impl.MainGUI;

public class Teste01 {
	
	public static void main(String[] args) {
		
//		MainGUI vaiDarErrado = new MainGUI();
		
		MainGUIFramework app = MainGUIFramework.getInstance();
        app.setSize (400, 400);
        app.setVisible(true);
	}

}
