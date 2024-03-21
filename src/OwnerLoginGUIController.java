import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnerLoginGUIController {
	private OwnerLoginGUI ownerLoginGUI;

	public OwnerLoginGUIController(OwnerLoginGUI ownerLoginGUI) {
		this.ownerLoginGUI = ownerLoginGUI;
		this.ownerLoginGUI.backButtonActionListener(new backButtonListener());
	}

	class backButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ownerLoginGUI.setVisible(false);
			MainWindow mwGUI = new MainWindow();
			MainWindowController mainWController = new MainWindowController(mwGUI);
			mwGUI.setVisible(true);
		}

	}

}
