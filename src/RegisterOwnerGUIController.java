import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterOwnerGUIController {
	private RegisterOwnerGUI roGUI;

	public RegisterOwnerGUIController(RegisterOwnerGUI roGUI) {
		this.roGUI = roGUI;
		this.roGUI.cancelButtonActionListener(new cancelButtonListener());
//		this.roGUI.loginOwnerButtonActionListener(new loginOButtonListener());
	}

	class cancelButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			roGUI.setVisible(false);
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
			roGUI.setVisible(false);
		}

	}

}
