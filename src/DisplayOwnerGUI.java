import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DisplayOwnerGUI extends JFrame {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;

	private JLabel nameL, addressLine1L, countyL, landLPhoneL, ownerPPSL, ownerStatusL, ownerIDL, blankL, blank2L;
	private JTextField nameTF, addressLine1TF, addressLine2TF, addressLine3TF, countyTF, landLPhoneTF, ownerICTF,
			ownerStatusTF, ownerIDTF;
	private String[] counties = { "Antrim", "Armagh", "Carlow", "Cavan", "Clare", "Cork", "Derry", "Donegal", "Down",
			"Dublin", "Fermanagh", "Galway", "Kerry", "Kildare", "Kilkenny", "Laois", "Leitrim", "Limerick", "Longford",
			"Louth", "Mayo", "Meath", "Monaghan", "Offaly", "Roscommon", "Sligo", "Tipperary", "Tyrone", "Waterford",
			"Westmeath", "Wexford", "Wicklow" };
	private JComboBox countyComboBox;
	private JButton addB, cancelB;

	public static Owner owner_;

	public DisplayOwnerGUI(Owner owner) {

		owner_ = owner;

		// Setting Font Properties
		Font myFont = new Font("Times New Roman", Font.BOLD, 20);

		// Instantiate the labels
		nameL = new JLabel("Owner Name: ", SwingConstants.RIGHT);
		addressLine1L = new JLabel("Address Line 1: ", SwingConstants.RIGHT);
		countyL = new JLabel("County: ", SwingConstants.RIGHT);
		landLPhoneL = new JLabel("Contact No: ", SwingConstants.RIGHT);
		ownerPPSL = new JLabel("Owner's PPS Number: ", SwingConstants.RIGHT);
		ownerStatusL = new JLabel("Owner Status: ", SwingConstants.RIGHT);
		ownerIDL = new JLabel("Owner's ID Number: ", SwingConstants.RIGHT);
		blankL = new JLabel("", SwingConstants.RIGHT);
		blank2L = new JLabel("", SwingConstants.RIGHT);

		// Text Fields:
		nameTF = new JTextField(10);
		addressLine1TF = new JTextField(10);
		landLPhoneTF = new JTextField(10);
		ownerICTF = new JTextField(10);
		ownerStatusTF = new JTextField(10);
		ownerIDTF = new JTextField(10);
		ownerIDTF.setEditable(false);

		// County Drop Down Menu
		countyComboBox = new JComboBox(counties);

		nameTF.setText(owner_.getName());
		addressLine1TF.setText(owner_.getAddress());
		landLPhoneTF.setText(owner_.getPhoneNumber());
		ownerICTF.setText(owner_.getIC());
		ownerStatusTF.setText(owner_.getOwnerStatus());
		ownerIDTF.setText("" + owner_.getOwnerID());

		// Buttons:
		// Add Button
		addB = new JButton("Commit Changes");
		addB.setFont(myFont);
		addB.setToolTipText("Click to submit details to the system.\n NOTE: Make sure details are correct with owner");
		addB.addActionListener(ae -> {
			owner_.setName(nameTF.getText());
			owner_.setAddress(addressLine1TF.getText());
			owner_.setPhoneNumber(landLPhoneTF.getText());
			owner_.setIC(ownerICTF.getText());
			owner_.setOwnerStatus(ownerStatusTF.getText());

			ownerIDTF.setText("" + owner_.getOwnerID());
			JOptionPane.showMessageDialog(null, "Owner info updated!");
		});

		// Cancel Button
		cancelB = new JButton("Cancel");
		cancelB.setFont(myFont);
		cancelB.addActionListener(ae -> {
			setVisible(false);
			dispose();
		});

		setLayout(new GridLayout(11, 2));

		// Add components to the JFrame
		add(nameL);
		add(nameTF);
		add(addressLine1L);
		add(addressLine1TF);
		add(countyL);
		add(countyComboBox);
		add(landLPhoneL);
		add(landLPhoneTF);
		add(ownerPPSL);
		add(ownerICTF);
		add(ownerStatusL);
		add(ownerStatusTF);
		add(ownerIDL);
		add(ownerIDTF);
		add(blankL);
		add(blank2L);
		add(addB);
		add(cancelB);

		setTitle("Amend Owner Details");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null); // Position application in center of screen
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		toFront();
	}
}
