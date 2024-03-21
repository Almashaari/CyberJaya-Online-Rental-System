import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegisterTenantGUI extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = 2341234L;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 600;

	private JLabel nameL, addressL, phoneL, tenantICL, tenantStatusL, tenantUsernameL, tenantPasswordL, blankL, blank2L;
	private JTextField nameTF, addressTF, phoneTF, tenantICTF, tenantStatusTF, tenantUsernameTF, tenantPasswordTF;

	private JButton addB, cancelB;

	public RegisterTenantGUI() {

		// Setting Font Properties
		Font myFont = new Font("Times New Roman", Font.BOLD, 20);

		// Instantiate the labels
		nameL = new JLabel("Tenant Name: ", SwingConstants.CENTER);
		addressL = new JLabel("Address: ", SwingConstants.CENTER);

		phoneL = new JLabel("Contact No: ", SwingConstants.CENTER);
		tenantICL = new JLabel("Tenant's IC Number: ", SwingConstants.CENTER);
		tenantStatusL = new JLabel("Tenant Status: ", SwingConstants.CENTER);
		tenantUsernameL = new JLabel("Tenant's username: ", SwingConstants.CENTER);
		tenantPasswordL = new JLabel("Tenant's password: ", SwingConstants.CENTER);
		blankL = new JLabel("", SwingConstants.CENTER);
		blank2L = new JLabel("", SwingConstants.CENTER);

		// Text Fields:
		nameTF = new JTextField(10);
		addressTF = new JTextField(10);
		phoneTF = new JTextField(10);
		tenantICTF = new JTextField(10);
		tenantStatusTF = new JTextField(10);
		tenantUsernameTF = new JTextField(10);
		tenantPasswordTF = new JTextField(10);
		// Buttons:
		// Add Button
		addB = new JButton("Add Tenant");
		addB.setFont(myFont);
		addB.setToolTipText("Click to submit details to the system.\n NOTE: Make sure details are correct with tenant");
		addB.addActionListener(ae -> {
			Tenant o1 = new Tenant();
			o1.setName(nameTF.getText());
			o1.setAddress(addressTF.getText());
			o1.setPhoneNumber(phoneTF.getText());
			o1.setIC(tenantICTF.getText());
			o1.setUsername(tenantUsernameTF.getText());
			o1.setPassword(tenantPasswordTF.getText());
			o1.setTenantStatus(tenantStatusTF.getText());
			CORS.tenantList.add(o1); // Add to the tenant arrayList declared in the Home Screen
			saveTenantsListFile();
			tenantUsernameTF.setText("" + o1.getTenantID());
			JOptionPane.showMessageDialog(null, "Tenant added to tenant list!");
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
		add(tenantICL);
		add(tenantICTF);
		add(tenantStatusL);
		add(tenantStatusTF);
		add(tenantUsernameL);
		add(tenantUsernameTF);
		add(tenantPasswordL);
		add(tenantPasswordTF);
		add(blankL);
		add(blank2L);
		add(addB);
		add(cancelB);

		setTitle("Register new Tenant Screen");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null); // Position application in center of screen
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		toFront();
	}

	private void saveTenantsListFile() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("files/TenantsList.txt"));
			os.writeObject(CORS.tenantList);
			os.close();
		} catch (Exception e) {
			System.out.println("Error occurred when trying to save TenantsList.txt file");
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Tenant(s) successfully written to file\n");
	}

	void cancelButtonActionListener(java.awt.event.ActionListener listenCancelB) {
		cancelB.addActionListener(listenCancelB);

	}
}
