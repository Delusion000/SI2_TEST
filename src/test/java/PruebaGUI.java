import org.mockito.Mockito;

import businesslogic.BLFacade;
import gui.MainGUI;

public class PruebaGUI {
	static BLFacade appFacadeInterface = Mockito.mock(BLFacade.class);
	public static void main(String args[]) {
		Mockito.doReturn("Driver").when(appFacadeInterface).getMotaByUsername
		(Mockito.anyString());
		Mockito.doReturn(true).when(appFacadeInterface).isRegistered("a","a");
	MainGUI a = new MainGUI();
	MainGUI.setBussinessLogic(appFacadeInterface);
	a.setVisible(true);
	}
}
