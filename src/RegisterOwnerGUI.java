
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegisterOwnerGUI extends JFrame {

	private static final long serialVersionUID = 2L;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 600;

	private JLabel nameL, addressL, phoneL, ownerICL, ownerStatusL, ownerUsernameL, ownerPasswordL, blankL, blank2L;
	private JTextField nameTF, addressTF, phoneTF, ownerICTF, ownerStatusTF, ownerUsernameTF, ownerPasswordTF;

	private JButton addB, cancelB;

	public RegisterOwnerGUI() {

		// Setting Font Properties
		Font myFont = new Font("Times New Roman", Font.BOLD, 20);

		// Instantiate the labels
		nameL = new JLabel("Owner Name: ", SwingConstants.CENTER);
		addressL = new JLabel("Address: ", SwingConstants.CENTER);

		phoneL = new JLabel("Contact No: ", SwingConstants.CENTER);
		ownerICL = new JLabel("Owner's IC Number: ", SwingConstants.CENTER);
		ownerStatusL = new JLabel("Owner Status: ", SwingConstants.CENTER);
		ownerUsernameL = new JLabel("Owner's username: ", SwingConstants.CENTER);
		ownerPasswordL = new JLabel("Owner's password: ", SwingConstants.CENTER);
		blankL = new JLabel("", SwingConstants.CENTER);
		blank2L = new JLabel("", SwingConstants.CENTER);

		// Text Fields:
		nameTF = new JTextField(10);
		addressTF = new JTextField(10);
		phoneTF = new JTextField(10);
		ownerICTF = new JTextField(10);
		ownerStatusTF = new JTextField(10);
		ownerUsernameTF = new JTextField(10);
		ownerPasswordTF = new JTextField(10);
		// Buttons:
		// Add Button
		addB = new JButton("Add Owner");
		addB.setFont(myFont);
		addB.setToolTipText("Click to submit details to the system.\n NOTE: Make sure details are correct with owner");
		addB.addActionListener(ae -> {
			Owner o1 = new Owner();
			o1.setName(nameTF.getText());
			o1.setAddress(addressTF.getText());
			o1.setPhoneNumber(phoneTF.getText());
			o1.setIC(ownerICTF.getText());
			o1.setUsername(ownerUsernameTF.getText());
			o1.setPassword(ownerPasswordTF.getText());
			o1.setOwnerStatus(ownerStatusTF.getText());
			CORS.ownerList.add(o1); // Add to the owner arrayList declared in the Home Screen
			ownerUsernameTF.setText("" + o1.getOwnerID());
			JOptionPane.showMessageDialog(null, "Owner added to owner list!");
		});

		// Cancel Button
		cancelB = new JButton("Cancel");
		cancelB.setFont(myFont);

		setLayout(new GridLayout(11, 2));

		// Add components to the JFrame
		add(nameL);
		add(nameTF);
		add(addressL);
		add(addressTF);
		add(phoneL);
		add(phoneTF);
		add(ownerICL);
		add(ownerICTF);
		add(ownerStatusL);
		add(ownerStatusTF);
		add(ownerUsernameL);
		add(ownerUsernameTF);
		add(ownerPasswordL);
		add(ownerPasswordTF);
		add(blankL);
		add(blank2L);
		add(addB);
		add(cancelB);

		setTitle("Register new Owner Screen");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null); // Position application in center of screen
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		toFront();
	}

	void cancelButtonActionListener(java.awt.event.ActionListener listenCancelB) {
		cancelB.addActionListener(listenCancelB);

	}
}
