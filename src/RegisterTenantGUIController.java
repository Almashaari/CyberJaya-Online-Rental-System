import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterTenantGUIController {
	private RegisterTenantGUI rtGUI;

	public RegisterTenantGUIController(RegisterTenantGUI rTGUI) {
		this.rtGUI = rTGUI;
		this.rtGUI.cancelButtonActionListener(new cancelButtonListener());
//		this.rtGUI.loginOwnerButtonActionListener(new loginOButtonListener());
	}

	class cancelButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			rtGUI.setVisible(false);
//			dispose();

			MainWindow mwGUI = new MainWindow();
			MainWindowController mainWController = new MainWindowController(mwGUI);
			mwGUI.setVisible(true);
		}

	}

	class loginOButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			OwnerLoginGUI ownerLoginGUI = new OwnerLoginGUI();
			ownerLoginGUI.setVisible(true);
			ownerLoginGUI.str = "";
			rtGUI.setVisible(false);
		}

	}

}
