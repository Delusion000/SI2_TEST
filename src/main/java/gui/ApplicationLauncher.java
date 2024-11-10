package gui;

import java.util.Locale;
import javax.swing.UIManager;
import businesslogic.BLFacade;
import businesslogic.BLFacadeFactory;
import configuration.ConfigXML;

public class ApplicationLauncher {
    public static void main(String[] args) {
        ConfigXML c = ConfigXML.getInstance();
        Locale.setDefault(new Locale(c.getLocale()));

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            
            BLFacade appFacadeInterface = BLFacadeFactory.createBusinessLogicFactory(c.isBusinessLogicLocal());
            
            MainGUI.setBussinessLogic(appFacadeInterface);
            MainGUI a = new MainGUI();
            a.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error in ApplicationLauncher: " + e.toString());
        }
    }
}
