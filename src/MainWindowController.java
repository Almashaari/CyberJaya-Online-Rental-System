import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindowController {
	private MainWindow mainWindow;

	public MainWindowController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.mainWindow.registerOwnerButtonActionListener(new regOButtonListener());
		this.mainWindow.loginOwnerButtonActionListener(new loginOButtonListener());
		this.mainWindow.registerTenantButtonActionListener(new registerTButtonListner());
		this.mainWindow.loginTenantButtonActionListener(new loginTButtonListner());
		this.mainWindow.loginAdminButtonActionListener(new loginAButtonListener());
	}

	class loginAButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AdminLoginGUI aLGUI = new AdminLoginGUI();
			AdminLoginGUIController aLGUIc = new AdminLoginGUIController(aLGUI);
			aLGUI.setVisible(true);
			mainWindow.setVisible(false);
		}

	}

	class regOButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			RegisterOwnerGUI rOGUI = new RegisterOwnerGUI();
			RegisterOwnerGUIController roGUIc = new RegisterOwnerGUIController(rOGUI);

			rOGUI.setVisible(true);
			mainWindow.setVisible(false);
		}

	}

	class loginOButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			OwnerLoginGUI ownerLoginGUI = new OwnerLoginGUI();
			OwnerLoginGUIController ownerLoginGUIController = new OwnerLoginGUIController(ownerLoginGUI);
			ownerLoginGUI.setVisible(true);
			ownerLoginGUI.str = "";
			mainWindow.setVisible(false);
		}

	}

	class registerTButtonListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			RegisterTenantGUI rTGUI = new RegisterTenantGUI();
			RegisterTenantGUIController rtgGUIController = new RegisterTenantGUIController(rTGUI);
			rTGUI.setVisible(true);
			mainWindow.setVisible(false);
		}
	}

	class loginTButtonListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TenantLoginGUI rTGUI = new TenantLoginGUI();
			rTGUI.setVisible(true);
			mainWindow.setVisible(false);
		}
	}
}
