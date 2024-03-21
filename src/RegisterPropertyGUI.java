
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegisterPropertyGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5795811076103333077L;
	private static final int WIDTH = 900;
	private static final int HEIGHT = 600;

	private JLabel addressLine1L, propertyTypeL, bedsL, rentAmountL, propertyStatusL, ownerL, propertyIDL, blankL,
			blank2L;
	private JTextField addressLine1TF, propertyTypeTF, bedsTF, rentAmountTF, propertyStatusTF, ownerTF, propertyIDTF;
	private String[] propertyType = { "Bunglow", "Condo", "Double Storey", "Town House", "Studio Room" };
	private JComboBox propertyComboBox;
	private JButton addB, cancelB;

	public RegisterPropertyGUI() {

		// Setting Font Properties
		Font myFont = new Font("Times New Roman", Font.BOLD, 20);

		// Instantiate the labels
		addressLine1L = new JLabel("Address: ", SwingConstants.CENTER);
		propertyTypeL = new JLabel("County: ", SwingConstants.CENTER);
		bedsL = new JLabel("Number of Beds: ", SwingConstants.CENTER);
		propertyTypeL = new JLabel("Property Type: ", SwingConstants.CENTER);
		rentAmountL = new JLabel("Rent Amount: ", SwingConstants.CENTER);
		propertyStatusL = new JLabel("Property Status: ", SwingConstants.CENTER);
		// ownerL = new JLabel("Owner: ", SwingConstants.CENTER);
		propertyIDL = new JLabel("Property ID: ", SwingConstants.CENTER);
		blankL = new JLabel("", SwingConstants.CENTER);
		blank2L = new JLabel("", SwingConstants.CENTER);

		// Text Fields:
		addressLine1TF = new JTextField(10);
		propertyTypeTF = new JTextField(10);
		bedsTF = new JTextField(10);
		rentAmountTF = new JTextField(10);
		propertyStatusTF = new JTextField(10);
		// ownerTF = new JTextField(10);
		propertyIDTF = new JTextField(10);
		propertyIDTF.setEditable(false);

		// County Drop Down Menu
		propertyComboBox = new JComboBox(propertyType);

		// Buttons:
		// Add Button
		addB = new JButton("Add Property");
		addB.setFont(myFont);
		addB.setToolTipText("Click to submit details to the system.\n NOTE: Make sure details are correct");
		addB.addActionListener(ae -> {
			Property p1 = new Property();
			p1.setAddress__(addressLine1TF.getText() + "\n" + propertyComboBox.getSelectedItem());
			p1.setBeds__(bedsTF.getText());
			p1.setPropertyType__(propertyTypeTF.getText());
			p1.setRentAmount__(rentAmountTF.getText());
			p1.setPropertyStatus__(propertyStatusTF.getText());
			CORS.propertyList.add(p1); // Add to the propertyList arrayList declared in the Home Screen
			CORS.propertyAvailable.add(p1); // Add to the propertyAvailable arrayList declared in the Home
											// Screen
			propertyIDTF.setText("" + p1.getPropertyID__());
			JOptionPane.showMessageDialog(null, "Property added to the property list!");
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
		add(addressLine1L);
		add(addressLine1TF);
		add(propertyTypeL);
		add(propertyComboBox);
		add(bedsL);
		add(bedsTF);
		add(rentAmountL);
		add(rentAmountTF);
		add(propertyStatusL);
		add(propertyStatusTF);
		add(propertyIDL);
		add(propertyIDTF);
		add(blankL);
		add(blank2L);
		add(addB);
		add(cancelB);

		setTitle("Register new Property Screen");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null); // Position application in center of screen
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		toFront();
	}
}
