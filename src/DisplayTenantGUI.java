
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DisplayTenantGUI extends JFrame {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;

	private JLabel nameL, addressLine1L, addressLine2L, addressLine3L, countyL, tenantPhoneL, tenantICL, tenantStatusL,
			tenantIDL, blankL, blank2L;
	private JTextField nameTF, addressLine1TF, addressLine2TF, addressLine3TF, countyTF, tenantPhoneTF, tenantICTF,
			tenantStatusTF, tenantIDTF;
	private JComboBox countyComboBox;
	private JButton addB, cancelB;

	public static Tenant tenant_;

	public DisplayTenantGUI(Tenant tenant) {

		tenant_ = tenant;

		// Setting Font Properties
		Font myFont = new Font("Times New Roman", Font.BOLD, 20);

		// Instantiate the labels
		nameL = new JLabel("Tenant Name: ", SwingConstants.RIGHT);
		addressLine1L = new JLabel("Address Line 1: ", SwingConstants.RIGHT);
		addressLine2L = new JLabel("Address Line 2: ", SwingConstants.RIGHT);
		addressLine3L = new JLabel("Address Line 3: ", SwingConstants.RIGHT);
		countyL = new JLabel("County: ", SwingConstants.RIGHT);
		tenantPhoneL = new JLabel("Contact No: ", SwingConstants.RIGHT);
		tenantICL = new JLabel("Tenant's PPS Number: ", SwingConstants.RIGHT);
		tenantStatusL = new JLabel("Tenant Status: ", SwingConstants.RIGHT);
		tenantIDL = new JLabel("Tenant's ID Number: ", SwingConstants.RIGHT);
		blankL = new JLabel("", SwingConstants.RIGHT);
		blank2L = new JLabel("", SwingConstants.RIGHT);

		// Text Fields:
		nameTF = new JTextField(10);
		addressLine1TF = new JTextField(10);
		addressLine2TF = new JTextField(10);
		addressLine3TF = new JTextField(10);
		countyTF = new JTextField(10);
		tenantPhoneTF = new JTextField(10);
		tenantICTF = new JTextField(10);
		tenantStatusTF = new JTextField(10);
		tenantIDTF = new JTextField(10);
		tenantIDTF.setEditable(false);

		// County Drop Down Menu

		nameTF.setText(tenant.getName());
		addressLine1TF.setText(tenant.getAddress());
		tenantPhoneTF.setText(tenant.getPhoneNumber());
		tenantICTF.setText(tenant.getIC());
		tenantStatusTF.setText(tenant.getTenantStatus());
		tenantIDTF.setText("" + tenant.getTenantID());

		// Buttons:
		// Add Button
		addB = new JButton("Commit Changes");
		addB.setFont(myFont);
		addB.setToolTipText(
				"Click to submit details to the system.\n NOTE: Make sure details are correct with landlord");
		addB.addActionListener(ae -> {
			tenant.setName(nameTF.getText());
			tenant.setAddress(addressLine1TF.getText());
			tenant.setPhoneNumber(tenantPhoneTF.getText());
			tenant.setIC(tenantICTF.getText());
			tenant.setTenantStatus(tenantStatusTF.getText());

			tenantIDTF.setText("" + tenant.getTenantID());
			JOptionPane.showMessageDialog(null, "Tenant info updated!");
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
		add(tenantPhoneL);
		add(tenantPhoneTF);
		add(tenantICL);
		add(tenantICTF);
		add(tenantStatusL);
		add(tenantStatusTF);
		add(tenantICL);
		add(tenantICTF);
		add(blankL);
		add(blank2L);
		add(addB);
		add(cancelB);

		setTitle("Update Tenant Details");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null); // Position application in center of screen
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		toFront();
	}
}
