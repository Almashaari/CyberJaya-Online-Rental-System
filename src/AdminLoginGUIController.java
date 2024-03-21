import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginGUIController {
	private AdminLoginGUI adminLoginGUI;

	public AdminLoginGUIController(AdminLoginGUI adminLoginGUI) {
		this.adminLoginGUI = adminLoginGUI;
		this.adminLoginGUI.backButtonActionListener(new backButtonListener());
	}

	class backButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			adminLoginGUI.setVisible(false);
			MainWindow mwGUI = new MainWindow();
			MainWindowController mainWController = new MainWindowController(mwGUI);
			mwGUI.setVisible(true);
		}

	}

}
