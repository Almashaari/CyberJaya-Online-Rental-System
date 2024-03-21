import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TenantHomeScreenGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8382341301255519804L;
	/// ArrayList of Different Variables
	public static ArrayList<Owner> ownerList = new ArrayList<>();
	public static ArrayList<Property> propertyList = new ArrayList<>();
	public static ArrayList<Property> propertyLet = new ArrayList<>();
	public static ArrayList<Property> propertyAvailable = new ArrayList<>();
	public static ArrayList<Tenant> tenantsAvailable = new ArrayList<>();
	public static ArrayList<Tenant> tenantList = new ArrayList<>();
	public static ArrayList<Rental> rentalList = new ArrayList<>();
	JTextArea area;

	/// Creating the Combo Boxes
	String[] delPropertyLists = { "Properties Available", "Properties Least Out" };
	JComboBox delPropertyLts = new JComboBox(delPropertyLists);
	JButton b = new JButton("Enter");
	JButton c = new JButton("Cancel");
	JLabel delProText = new JLabel("Select Property List to delete from");

	String[] tenantLists = { "Tenants Available", "Tenants Not Available" };
	JComboBox tenantLts = new JComboBox(tenantLists);
	JButton d = new JButton("Enter");
	JButton f = new JButton("Cancel");
	JLabel tenText = new JLabel("Select Tenant List");

	String[] delTenantLists = { "Tenants Available", "Tenants Not Available" };
	JComboBox delTenantLts = new JComboBox(delTenantLists);
	JButton g = new JButton("Enter");
	JButton h = new JButton("Cancel");
	JLabel delTenText = new JLabel("Select Tenant List to delete from");

	String[] amdTenantLists = { "Tenants Available", "Tenants Not Available" };
	JComboBox amdTenantLts = new JComboBox(amdTenantLists);
	JButton i = new JButton("Enter");
	JButton j = new JButton("Cancel");
	JLabel amdTenText = new JLabel("Select Tenant List to delete from");

	String searchName;
	boolean found = false;

//	public static void main(String args[]) throws IOException {
//		// Run the Main Application GUI
//		HomeScreenGUI ex = new HomeScreenGUI();
//		ex.setVisible(true);
//	}

	public TenantHomeScreenGUI() {

		// Returns an image which gets pixel data from the specified file.
		Image storeImage = Toolkit.getDefaultToolkit().createImage("images/onlinerentalsystem.jpg"); // http://www.apartmentleasingtraining.org/property-management-course

		createMenuBar();

		// Loads up all the databases
		loadDatabases();

		setLayout(new BorderLayout());
		setTitle("Cyberjaya Online Rental Management System");
		JLabel background = new JLabel(new ImageIcon(storeImage));
		add(background);
		background.setLayout(new FlowLayout());
		setSize(1218, 684);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		area = new JTextArea();
	}

	/**
	 * Creates the menu bar on the main GUI
	 */
	private void createMenuBar() {

		JMenuBar menuBar = new JMenuBar();
		// Load in the Icons
		ImageIcon exitIcon = new ImageIcon("images/exit.png");
		ImageIcon addIcon = new ImageIcon("images/add.png");
		ImageIcon deleteIcon = new ImageIcon("images/delete.png");
		ImageIcon editIcon = new ImageIcon("images/edit.png");
		ImageIcon searchIcon = new ImageIcon("images/search.png");
		ImageIcon displayIcon = new ImageIcon("images/display.png");
		ImageIcon listIcon = new ImageIcon("images/list.png");
		ImageIcon saveIcon = new ImageIcon("images/save.png");
		ImageIcon openIcon = new ImageIcon("images/open.png");
		ImageIcon aboutIcon = new ImageIcon("images/about.png");

		// Set up all the JMenus and their Hot keys (Hold ALT + key)
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);

		JMenu properties = new JMenu("Properties");
		properties.setMnemonic(KeyEvent.VK_P);

		JMenu tenants = new JMenu("Tenants");
		tenants.setMnemonic(KeyEvent.VK_T);

		JMenu rentals = new JMenu("Rentals");
		rentals.setMnemonic(KeyEvent.VK_R);

		////////// File Menu
		////////// Items/////////////////////////////////////////////////////////////////
		// Save data option
		JMenuItem save = new JMenuItem("  Save", saveIcon);
		save.setMnemonic(KeyEvent.VK_S);
		save.setToolTipText("Save any new changes made to the system");
		save.addActionListener(ae -> {
			saveDatabases();
			System.out.println("Save clicked");
		});

		// Load data option
		JMenuItem load = new JMenuItem("  Load", openIcon);
		load.setMnemonic(KeyEvent.VK_L);
		load.setToolTipText("Save any new changes made to the system");
		load.addActionListener(ae -> {
			loadDatabases();
			System.out.println("Load clicked");
		});

		// Exit Option
		JMenuItem exit = new JMenuItem("  Exit", exitIcon);
		exit.setMnemonic(KeyEvent.VK_E);
		exit.setToolTipText("Exit application");
		exit.addActionListener(ae -> {
			System.out.println("Exit option clicked");
			String message = " Would you like to save any changes made to the database? ";
			String title = "Quit";
			int confirm = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_CANCEL_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				saveDatabases();
				JOptionPane.showMessageDialog(null, "Database updated. Goodbye");
				System.exit(0);
			} else if (confirm == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Database not updated. Goodbye");
				System.exit(0);
			}
		});
		file.add(save);
		file.add(load);
		file.addSeparator();
		file.add(exit);

//////////Properties MenuItems/////////////////////////////////////////////////////////////////
		// Record New Property
		JMenuItem recordNewProperty = new JMenuItem("  Record New Property", addIcon);
		recordNewProperty.setMnemonic(KeyEvent.VK_R);
		recordNewProperty.setToolTipText("Open Record New Property window");
		recordNewProperty.addActionListener(ae -> {
			RegisterPropertyGUI addNewPropertyScreen = new RegisterPropertyGUI();
		});

		// Delete Property
		JMenuItem deleteProperty = new JMenuItem("  Delete Property", deleteIcon);
		deleteProperty.setMnemonic(KeyEvent.VK_D);
		deleteProperty.setToolTipText("Delete Property from the system");
		deleteProperty.addActionListener(ae -> {
			System.out.println("Delete Property Clicked");
			Property removeProperty = removeProperty();
		});

		// Search For Property
		JMenuItem searchProperties = new JMenuItem("  Search For Property", searchIcon);
		searchProperties.setMnemonic(KeyEvent.VK_A);
		searchProperties.setToolTipText("Search For a Property on the system");
		searchProperties.addActionListener(ae -> {
			System.out.println("Search For Property Clicked");
		});

		// Display all Properties Available
		JMenuItem propertiesAvailable = new JMenuItem("  Display Properties Available", displayIcon);
		propertiesAvailable.setMnemonic(KeyEvent.VK_A);
		propertiesAvailable.setToolTipText("Search Properties on the system");
		propertiesAvailable.addActionListener(ae -> {
			System.out.println("Display Properties Clicked");

			StringBuilder builder = new StringBuilder(propertyAvailable.size());
			for (Property pr : propertyAvailable) {
				builder.append(pr.toString() + "\n");
			}

			// JTextArea for displaying the list (StringBuilder)
			JTextArea textArea = new JTextArea(builder.toString());
			JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(null, scrollPane, "List of Properties Available", JOptionPane.OK_OPTION);

			for (Property pro : propertyAvailable) {
				System.out.println(pro.toString());
			}

		});

		// Display all Properties
		JMenuItem displayProperties = new JMenuItem("  Display Properties", displayIcon);
		displayProperties.setMnemonic(KeyEvent.VK_A);
		displayProperties.setToolTipText("Search Properties on the system");
		displayProperties.addActionListener(ae -> {
			System.out.println("Display Properties Clicked");

			StringBuilder builder = new StringBuilder(propertyList.size());
			for (Property pr : propertyList) {
				builder.append(pr.toString() + "\n");
			}

			// JTextArea for displaying the list (StringBuilder)
			JTextArea textArea = new JTextArea(builder.toString());
			JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(null, scrollPane, "List of Properties", JOptionPane.OK_OPTION);

			for (Property pro : propertyAvailable) {
				System.out.println(pro.toString());
			}

		});

		// List Properties Available/Rent
		JMenuItem listPropertiesAvailable = new JMenuItem("  List Properties Available/Let", listIcon);
		listPropertiesAvailable.setMnemonic(KeyEvent.VK_L);
		listPropertiesAvailable.setToolTipText("List Properties Available/Let on the system");
		listPropertiesAvailable.addActionListener(ae -> {
			System.out.println("List Properties Available/Let Clicked");
			StringBuilder builder = new StringBuilder(propertyList.size());
			for (Property prop : propertyList) {
				builder.append(prop.toString() + "\n");
			}

			// JTextArea for displaying the list (StringBuilder)
			JTextArea textArea = new JTextArea(builder.toString());
			JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(null, scrollPane, "List of Properties not available", JOptionPane.OK_OPTION);

			for (Property p : propertyList) {
				System.out.println(p.toString());
			}
		});

		properties.add(recordNewProperty);
		properties.add(deleteProperty);
		properties.add(searchProperties);
		properties.add(displayProperties);
		properties.add(propertiesAvailable);
		properties.add(listPropertiesAvailable);

//////////Rentals Menu Items/////////////////////////////////////////////////////////////////
		// Process New Rental
		JMenuItem processNewRental = new JMenuItem("  Process New Rental", addIcon);
		processNewRental.setMnemonic(KeyEvent.VK_P);
		processNewRental.setToolTipText("Process New Rental on the system");
		processNewRental.addActionListener(ae -> {
			System.out.println("Process New Rental Clicked");
			StringBuilder builder = new StringBuilder(rentalList.size());
			for (Rental land : rentalList) {
				builder.append(land.toString() + "\n");
			}

			// pick a tenant
			int tenIdx = Integer.parseInt(JOptionPane.showInputDialog(
					"Enter a tenant ID number " + " between 1 and " + TenantHomeScreenGUI.tenantsAvailable.size()));
			// pick a property
			int propIdx = Integer.parseInt(JOptionPane
					.showInputDialog("Enter a property ID number " + " between 1 and " + propertyAvailable.size()));

			// create a new rental object
			Rental propertyRental = new Rental(propertyAvailable.get(tenIdx - 1),
					TenantHomeScreenGUI.tenantsAvailable.get(propIdx - 1));
			propertyAvailable.get(propIdx - 1).takeProperty();
			propertyRental.setTerm("1 year");
			propertyRental.setRate(750.00);
			// add the tenant to the property list
			rentalList.add(propertyRental);
			// add taken tenant to tenantList
			tenantList.add(TenantHomeScreenGUI.tenantsAvailable.get(propIdx - 1));
			// remove taken tenant from tenantAvailable list
			TenantHomeScreenGUI.tenantsAvailable.remove(TenantHomeScreenGUI.tenantsAvailable.get(propIdx - 1));
			// add taken property to propertyLet list
			propertyLet.add(propertyAvailable.get(tenIdx - 1));
			// remove taken property from propertyAvailable list
			propertyAvailable.remove(propertyAvailable.get(tenIdx - 1));
		});

		// Search For Rental
		JMenuItem searchRental = new JMenuItem("  Search For Rental", searchIcon);
		searchRental.setMnemonic(KeyEvent.VK_S);
		searchRental.setToolTipText("Search For a Rental on the system");
		searchRental.addActionListener(ae -> {
			System.out.println("Search For Rental Clicked");
		});

		// Display All Rentals
		JMenuItem displayRentals = new JMenuItem("  Display Rentals", displayIcon);
		displayRentals.setMnemonic(KeyEvent.VK_D);
		displayRentals.setToolTipText("Display Rentals on the system");
		displayRentals.addActionListener(ae -> {
			System.out.println("Display Rentals Clicked");

			// note that this gives a very poor display layout
			// instead of using r.toString(), a better-organised display would be needed
			area.setText("Class List\n");
			// adding scrollbar
			JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			for (Rental r : rentalList) {
				area.append(r.toString());
				if (r.getProperty() instanceof Property) {
					area.append(" for Class Name: " + ((Property) (r.getProperty())).getAddress__() + "\n\n");
				}
			}
			// setting scrollbar dimension
			scroll.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(null, scroll);
		});

		rentals.add(processNewRental);
		rentals.add(searchRental);
		rentals.add(displayRentals);

		// Add top menu bar items
		menuBar.add(file);
		menuBar.add(properties);
		menuBar.add(rentals);

		// Set the Menu bar
		setJMenuBar(menuBar);
	}// End of createMenuBar Method

	// Saving databases/ArrayLists methods
	private void saveDatabases() {
		// Save the Owner's File
		saveOwnersFile();
		// Save the Properties Files
		savePropertiesListFile();
		savePropertiesFile();
		savePropertiesLetFile();
		// Save the Tenants Files
		saveTenantsFile();
		saveTenantsListFile();
		// Save the Rentals File
		saveRentalsFile();
	}

	private void saveOwnersFile() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("files/Owners.txt"));
			os.writeObject(TenantHomeScreenGUI.ownerList);
			os.close();
		} catch (Exception e) {
			System.out.println("Error occurred when trying to save Owners file");
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "owner(s) successfully written to file\n");
	}

	private void savePropertiesFile() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("files/Property.txt"));
			os.writeObject(TenantHomeScreenGUI.propertyAvailable);
			os.close();
		} catch (Exception e) {
			System.out.println("Error occurred when trying to save Property file");
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Property/Properties successfully written to file\n");
	}

	private void savePropertiesListFile() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("files/PropertyList.txt"));
			os.writeObject(TenantHomeScreenGUI.propertyList);
			os.close();
		} catch (Exception e) {
			System.out.println("Error occurred when trying to save propertiesList.txt file");
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Property/Properties successfully written to file\n");
	}

	private void savePropertiesLetFile() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("files/PropertyRent.txt"));
			os.writeObject(TenantHomeScreenGUI.propertyLet);
			os.close();
		} catch (Exception e) {
			System.out.println("Error occurred when trying to save PropertiesLet.txt file");
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Property/Properties successfully written to file\n");
	}

	private void saveTenantsFile() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("files/Tenants.txt"));
			os.writeObject(TenantHomeScreenGUI.tenantsAvailable);
			os.close();
		} catch (Exception e) {
			System.out.println("Error occurred when trying to save Tenants.txt file");
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Tenant(s) successfully written to file\n");
	}

	private void saveTenantsListFile() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("files/TenantsList.txt"));
			os.writeObject(TenantHomeScreenGUI.tenantList);
			os.close();
		} catch (Exception e) {
			System.out.println("Error occurred when trying to save TenantsList.txt file");
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Tenant(s) successfully written to file\n");
	}

	private void saveRentalsFile() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("files/Rentals.txt"));
			os.writeObject(TenantHomeScreenGUI.rentalList);
			os.close();
		} catch (Exception e) {
			System.out.println("Error occurred when trying to save rentals.txt file");
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Rental(s) successfully written to file\n");
	}

	// Loading databases/ArrayLists methods
	private void loadDatabases() {
		// Load the Owners File
		loadOwnersFile();

		// Load the Properties Files
		loadPropertiesListFile();
		loadPropertiesFile();
		loadPropertiesLetFile();

		// Load the Tenants Files
		loadTenantsFile();
		loadTenantsListFile();

		// Load the Rentals File
		loadRentalsFile();
	}

	private void loadOwnersFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/Owners.txt"));
			TenantHomeScreenGUI.ownerList = (ArrayList<Owner>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Owners successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading Owners.dat file");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading the Owners file. System closing\n");
		}
	}

	private void loadPropertiesListFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/PropertyList.txt"));
			TenantHomeScreenGUI.propertyList = (ArrayList<Property>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Properties successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading propertiesList.dat file");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading the Properties file. System closing\n");
		}
	}

	private void loadPropertiesFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/Property.txt"));
			TenantHomeScreenGUI.propertyAvailable = (ArrayList<Property>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Properties successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading properties.dat file");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading the Properties file. System closing\n");
		}
	}

	private void loadPropertiesLetFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/PropertyRent.txt"));
			TenantHomeScreenGUI.propertyLet = (ArrayList<Property>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Properties successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading properties.dat file");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading the Properties file. System closing\n");
		}
	}

	private void loadTenantsFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/Tenants.txt"));
			TenantHomeScreenGUI.tenantsAvailable = (ArrayList<Tenant>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Tenants successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading Tenants.dat file");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading the Tenants file. System closing\n");
		}
	}

	private void loadTenantsListFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/TenantsList.txt"));
			TenantHomeScreenGUI.tenantList = (ArrayList<Tenant>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Tenants successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading Tenants.dat file");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading the Tenants file. System closing\n");
		}
	}

	private void loadRentalsFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/Rentals.txt"));
			TenantHomeScreenGUI.rentalList = (ArrayList<Rental>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Rentals successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading Rentals.txt file");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading the Rentals file. System closing\n");
		}
	}

	private Owner amendOwner() {
		boolean foundMatch = false;
		ArrayList<String> ownerIdList = new ArrayList<String>();
		String ownerIDString = "";
		String selectedOwner = "";
		Object[] ownerIds = {};
		String searchName = JOptionPane.showInputDialog("Enter name of owner: ");
		Owner searchedOwner = new Owner();

		if (searchName.equals("")) {
			JOptionPane.showMessageDialog(null, "No name entered!");
		} else {
			StringBuilder builder = new StringBuilder(ownerList.size());
			while (!foundMatch) {
				for (Owner lan : ownerList) {
					if (lan.getName().equalsIgnoreCase(searchName)) {
						builder.append(lan.toString() + "\n");
						ownerIDString = Integer.toString(lan.getOwnerID());
						ownerIdList.add(ownerIDString);
						ownerIds = ownerIdList.toArray();
						foundMatch = true;
					}
				}
				// JTextArea for displaying the list (StringBuilder)
				JTextArea textArea = new JTextArea(builder.toString());
				JScrollPane scrollPane = new JScrollPane(textArea);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				scrollPane.setPreferredSize(new Dimension(500, 500));

				// Display list if not empty
				if (!(textArea.getText().trim().length() == 0)) {
					JOptionPane.showMessageDialog(null, scrollPane, "List of Owners", JOptionPane.OK_OPTION);
					// In here should go the select patient code
					JFrame frame = new JFrame("Please select owner");
					selectedOwner = (String) JOptionPane.showInputDialog(frame,
							"Which owner do you wish to change details for? ", "Please select Owner's ID number:",
							JOptionPane.QUESTION_MESSAGE, null, ownerIds, ownerIds[0]);
				} else if (textArea.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "No Owner registered by the name: " + searchName);
					foundMatch = true;
					return null;
				}
				// Now I have the selected owner ID I must now open a new window displaying
				// their details and allow to change
				for (Owner land : ownerList) {
					if (selectedOwner.equals("" + land.getOwnerID())) {
						searchedOwner = land;
					}
				}
			}
		}
		return searchedOwner;
	}

	private Owner searchOwner() {
		boolean foundMatch = false;
		ArrayList<String> ownerIdList = new ArrayList<String>();
		String ownerIDString = "";
		String selectedOwner = "";
		Object[] ownerIds = {};
		String searchName = JOptionPane.showInputDialog("Enter name of Owner: ");
		Owner searchedOwner = new Owner();

		if (searchName.equals("")) {
			JOptionPane.showMessageDialog(null, "No name entered!");
		} else {
			StringBuilder builder = new StringBuilder(ownerList.size());
			while (!foundMatch) {
				for (Owner lan : ownerList) {
					if (lan.getName().equalsIgnoreCase(searchName)) {
						builder.append(lan.toString() + "\n");
						ownerIDString = Integer.toString(lan.getOwnerID());
						ownerIdList.add(ownerIDString);
						ownerIds = ownerIdList.toArray();
						foundMatch = true;
					}
				}
				// JTextArea for displaying the list (StringBuilder)
				JTextArea textArea = new JTextArea(builder.toString());
				JScrollPane scrollPane = new JScrollPane(textArea);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				scrollPane.setPreferredSize(new Dimension(500, 500));

				// Display list if not empty
				if (!(textArea.getText().trim().length() == 0)) {
					JOptionPane.showMessageDialog(null, scrollPane, "List of Owners", JOptionPane.OK_OPTION);
				} else if (textArea.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "No Owner registered by the name: " + searchName);
					foundMatch = true;
					return null;
				}
				// Now I have the selected owner ID I must now open a new window displaying
				// their details and allow to change
				for (Owner land : ownerList) {
					if (selectedOwner.equals("" + land.getOwnerID())) {
						searchedOwner = land;
					}
				}
			}
		}
		return searchedOwner;
	}

	private Owner removeOwner() {
		boolean foundMatch = false;
		ArrayList<String> ownerIdList = new ArrayList<String>();
		String ownerIDString = "";
		String selectedOwner = "";
		Object[] ownerIds = {};
		String removeName = JOptionPane.showInputDialog("Please enter the name of the owner you wish to remove: ");
		Owner removedOwner = new Owner();

		if (removeName.equals("")) {
			JOptionPane.showMessageDialog(null, "No name entered!");
		} else {
			StringBuilder builder = new StringBuilder(ownerList.size());
			while (!foundMatch) {
				for (Owner lan : ownerList) {
					if (lan.getName().equalsIgnoreCase(removeName)) {
						builder.append(lan.toString() + "\n");
						ownerIDString = Integer.toString(lan.getOwnerID());
						ownerIdList.add(ownerIDString);
						ownerIds = ownerIdList.toArray();
						foundMatch = true;
					}
				}
				// JTextArea for displaying the list (StringBuilder)
				JTextArea textArea = new JTextArea(builder.toString());
				JScrollPane scrollPane = new JScrollPane(textArea);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				scrollPane.setPreferredSize(new Dimension(500, 500));

				for (int i = 0; i < ownerList.size(); i++) {
					if (removeName.equals(ownerList.get(i).getName())) {
						ownerList.remove(i);
						JOptionPane.showMessageDialog(null, removeName + " has been removed from the Owner's List");
					} else if (!removeName.equals(ownerList.get(i).getName())) {
						JOptionPane.showMessageDialog(null, removeName + " is not on the Owner's List");
					}
				}
				break;
			}
		}
		return removedOwner;
	}

	private Property removeProperty() {

		JFrame removePropertyMenu = new JFrame();
		removePropertyMenu.setVisible(true);
		removePropertyMenu.setSize(200, 200);
		removePropertyMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		removePropertyMenu.setLocationRelativeTo(null);

		JPanel removeProperty = new JPanel();
		removeProperty.add(delProText);
		removeProperty.add(delPropertyLts);
		removeProperty.add(b);
		removeProperty.add(c);

		removePropertyMenu.add(removeProperty);

		Property removedProperty = new Property();

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String s = delPropertyLts.getSelectedItem().toString();
				if (s == "Property Available") {
					boolean foundMatch = false;
					ArrayList<String> propertyIdList = new ArrayList<String>();
					String propertyIDString = "";
					String selectedProperty = "";
					Object[] propertyIds = {};
					String removeProperty = JOptionPane
							.showInputDialog("Please enter the address of the property you wish to remove: ");

					if (removeProperty.equals("")) {
						JOptionPane.showMessageDialog(null, "No address entered!");
					} else {
						StringBuilder builder = new StringBuilder(propertyAvailable.size());
						while (!foundMatch) {
							for (Property prop : propertyAvailable) {
								if (prop.getAddress__().equalsIgnoreCase(removeProperty)) {
									builder.append(prop.toString() + "\n");
									propertyIDString = Integer.toString(prop.getPropertyID__());
									propertyIdList.add(propertyIDString);
									propertyIds = propertyIdList.toArray();
									foundMatch = true;
								}
							}
							// JTextArea for displaying the list (StringBuilder)
							JTextArea textArea = new JTextArea(builder.toString());
							JScrollPane scrollPane = new JScrollPane(textArea);
							textArea.setLineWrap(true);
							textArea.setWrapStyleWord(true);
							scrollPane.setPreferredSize(new Dimension(500, 500));

							for (int i = 0; i < propertyAvailable.size(); i++) {
								if (removeProperty.equals(propertyAvailable.get(i).getAddress__())) {
									propertyAvailable.remove(i);
									JOptionPane.showMessageDialog(null,
											removeProperty + " has been removed from the Properties List");
								} else if (!removeProperty.equals(propertyAvailable.get(i).getAddress__())) {
									JOptionPane.showMessageDialog(null,
											removeProperty + " is not on the Properties List");
								}
							}
							break;
						}
					}
				} else {
					boolean foundMatch = false;
					ArrayList<String> tenantIdList = new ArrayList<String>();
					String tenantIDString = "";
					String selectedTenant = "";
					Object[] tenantIds = {};
					String removeProperty = JOptionPane
							.showInputDialog("Please enter the address of the property you wish to remove: ");

					if (removeProperty.equals("")) {
						JOptionPane.showMessageDialog(null, "No address entered!");
					} else {
						StringBuilder builder = new StringBuilder(propertyList.size());
						while (!foundMatch) {
							for (Property prop : propertyList) {
								if (prop.getAddress__().equalsIgnoreCase(removeProperty)) {
									builder.append(prop.toString() + "\n");
									tenantIDString = Integer.toString(prop.getPropertyID__());
									tenantIdList.add(tenantIDString);
									tenantIds = tenantIdList.toArray();
									foundMatch = true;
								}
							}
							// JTextArea for displaying the list (StringBuilder)
							JTextArea textArea = new JTextArea(builder.toString());
							JScrollPane scrollPane = new JScrollPane(textArea);
							textArea.setLineWrap(true);
							textArea.setWrapStyleWord(true);
							scrollPane.setPreferredSize(new Dimension(500, 500));

							for (int i = 0; i < propertyList.size(); i++) {
								if (removeProperty.equals(propertyList.get(i).getAddress__())) {
									propertyList.remove(i);
									JOptionPane.showMessageDialog(null,
											removeProperty + " has been removed from the Properties List");
								} else if (!removeProperty.equals(propertyList.get(i).getAddress__())) {
									JOptionPane.showMessageDialog(null,
											removeProperty + " is not on the Properties List");
								}
							}
							break;
						}
					}
				}
			}

		});

		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removePropertyMenu.dispose();
			}
		});

		return removedProperty;

	}

	private Tenant removeTenant() {

		JFrame removeTenMenu = new JFrame();
		removeTenMenu.setVisible(true);
		removeTenMenu.setSize(200, 200);
		removeTenMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		removeTenMenu.setLocationRelativeTo(null);

		JPanel removeTenant = new JPanel();
		removeTenant.add(delTenText);
		removeTenant.add(delTenantLts);
		removeTenant.add(g);
		removeTenant.add(h);

		removeTenMenu.add(removeTenant);

		Tenant removedTenant = new Tenant();

		g.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String s = delTenantLts.getSelectedItem().toString();
				if (s == "Tenants Available") {
					boolean foundMatch = false;
					ArrayList<String> tenantIdList = new ArrayList<String>();
					String tenantIDString = "";
					String selectedTenant = "";
					Object[] tenantIds = {};
					String removeName = JOptionPane
							.showInputDialog("Please enter the name of the tenant you wish to remove: ");

					if (removeName.equals("")) {
						JOptionPane.showMessageDialog(null, "No name entered!");
					} else {
						StringBuilder builder = new StringBuilder(tenantsAvailable.size());
						while (!foundMatch) {
							for (Tenant ten : tenantsAvailable) {
								if (ten.getName().equalsIgnoreCase(removeName)) {
									builder.append(ten.toString() + "\n");
									tenantIDString = Integer.toString(ten.getTenantID());
									tenantIdList.add(tenantIDString);
									tenantIds = tenantIdList.toArray();
									foundMatch = true;
								}
							}
							// JTextArea for displaying the list (StringBuilder)
							JTextArea textArea = new JTextArea(builder.toString());
							JScrollPane scrollPane = new JScrollPane(textArea);
							textArea.setLineWrap(true);
							textArea.setWrapStyleWord(true);
							scrollPane.setPreferredSize(new Dimension(500, 500));

							for (int i = 0; i < tenantsAvailable.size(); i++) {
								if (removeName.equals(tenantsAvailable.get(i).getName())) {
									tenantsAvailable.remove(i);
									JOptionPane.showMessageDialog(null,
											removeName + " has been removed from the Tenant's List");
								} else if (!removeName.equals(tenantsAvailable.get(i).getName())) {
									JOptionPane.showMessageDialog(null, removeName + " is not on the Tenant's List");
								}
							}
							break;
						}
					}
				} else {
					boolean foundMatch = false;
					ArrayList<String> tenantIdList = new ArrayList<String>();
					String tenantIDString = "";
					String selectedTenant = "";
					Object[] tenantIds = {};
					String removeName = JOptionPane
							.showInputDialog("Please enter the name of the tenant you wish to remove: ");

					if (removeName.equals("")) {
						JOptionPane.showMessageDialog(null, "No name entered!");
					} else {
						StringBuilder builder = new StringBuilder(tenantList.size());
						while (!foundMatch) {
							for (Tenant ten : tenantList) {
								if (ten.getName().equalsIgnoreCase(removeName)) {
									builder.append(ten.toString() + "\n");
									tenantIDString = Integer.toString(ten.getTenantID());
									tenantIdList.add(tenantIDString);
									tenantIds = tenantIdList.toArray();
									foundMatch = true;
								}
							}
							// JTextArea for displaying the list (StringBuilder)
							JTextArea textArea = new JTextArea(builder.toString());
							JScrollPane scrollPane = new JScrollPane(textArea);
							textArea.setLineWrap(true);
							textArea.setWrapStyleWord(true);
							scrollPane.setPreferredSize(new Dimension(500, 500));

							for (int i = 0; i < tenantList.size(); i++) {
								if (removeName.equals(tenantList.get(i).getName())) {
									tenantList.remove(i);
									JOptionPane.showMessageDialog(null,
											removeName + " has been removed from the Tenant's List");
								} else if (!removeName.equals(tenantList.get(i).getName())) {
									JOptionPane.showMessageDialog(null, removeName + " is not on the Tenant's List");
								}
							}
							break;
						}
					}
				}
			}

		});

		h.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeTenMenu.dispose();
			}
		});

		return removedTenant;

	}

	private Tenant amendTenant() {

		JFrame amendTenMenu = new JFrame();
		amendTenMenu.setVisible(true);
		amendTenMenu.setSize(200, 200);
		amendTenMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		amendTenMenu.setLocationRelativeTo(null);

		JPanel amendTenant = new JPanel();
		amendTenant.add(amdTenText);
		amendTenant.add(amdTenantLts);
		amendTenant.add(i);
		amendTenant.add(j);

		amendTenMenu.add(amendTenant);

		Tenant amdTenant = new Tenant();

		i.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String s = delTenantLts.getSelectedItem().toString();
				if (s == "Tenants Available") {

					boolean foundMatch = false;
					ArrayList<String> tenantIdList = new ArrayList<String>();
					String tenIDString = "";
					String selectedTenant = "";
					Object[] tenantIds = {};
					String searchTenant = JOptionPane.showInputDialog("Enter name of tenant: ");
					Tenant searchedTenant = new Tenant();

					if (searchTenant.equals("")) {
						JOptionPane.showMessageDialog(null, "No name entered!");
					} else {
						StringBuilder builder = new StringBuilder(tenantsAvailable.size());
						while (!foundMatch) {
							for (Tenant ten : tenantsAvailable) {
								if (ten.getName().equalsIgnoreCase(searchTenant)) {
									builder.append(ten.toString() + "\n");
									tenIDString = Integer.toString(ten.getTenantID());
									tenantIdList.add(tenIDString);
									tenantIds = tenantIdList.toArray();
									foundMatch = true;
								}
							}
							// JTextArea for displaying the list (StringBuilder)
							JTextArea textArea = new JTextArea(builder.toString());
							JScrollPane scrollPane = new JScrollPane(textArea);
							textArea.setLineWrap(true);
							textArea.setWrapStyleWord(true);
							scrollPane.setPreferredSize(new Dimension(500, 500));

							// Display list if not empty
							if (!(textArea.getText().trim().length() == 0)) {
								JOptionPane.showMessageDialog(null, scrollPane, "List of Tenants",
										JOptionPane.OK_OPTION);
								// In here should go the select patient code
								JFrame frame = new JFrame("Please select tenant");
								selectedTenant = (String) JOptionPane.showInputDialog(frame,
										"Which tenant do you wish to change details for? ",
										"Please select Tenant's ID number:", JOptionPane.QUESTION_MESSAGE, null,
										tenantIds, tenantIds[0]);
							} else if (textArea.getText().trim().length() == 0) {
								JOptionPane.showMessageDialog(null,
										"No Tenant registered by the name: " + searchTenant);
								foundMatch = true;
								// return null;
							}
							// Now I have the selected tenant ID I must now open a new window displaying
							// their details and allow to change
							for (Tenant tent : tenantsAvailable) {
								if (selectedTenant.equals("" + tent.getTenantID())) {
									searchedTenant = tent;
								}
							}
							break;
						}
					}
					// return searchedTenant;

				} else {

					boolean foundMatch = false;
					ArrayList<String> tenantIdList = new ArrayList<String>();
					String tenIDString = "";
					String selectedTenant = "";
					Object[] tenantIds = {};
					String searchTenant = JOptionPane.showInputDialog("Enter name of tenant: ");
					Tenant searchedTenant = new Tenant();

					if (searchTenant.equals("")) {
						JOptionPane.showMessageDialog(null, "No name entered!");
					} else {
						StringBuilder builder = new StringBuilder(tenantList.size());
						while (!foundMatch) {
							for (Tenant ten : tenantList) {
								if (ten.getName().equalsIgnoreCase(searchTenant)) {
									builder.append(ten.toString() + "\n");
									tenIDString = Integer.toString(ten.getTenantID());
									tenantIdList.add(tenIDString);
									tenantIds = tenantIdList.toArray();
									foundMatch = true;
								}
							}
							// JTextArea for displaying the list (StringBuilder)
							JTextArea textArea = new JTextArea(builder.toString());
							JScrollPane scrollPane = new JScrollPane(textArea);
							textArea.setLineWrap(true);
							textArea.setWrapStyleWord(true);
							scrollPane.setPreferredSize(new Dimension(500, 500));

							// Display list if not empty
							if (!(textArea.getText().trim().length() == 0)) {
								JOptionPane.showMessageDialog(null, scrollPane, "List of Tenants",
										JOptionPane.OK_OPTION);
								// In here should go the select patient code
								JFrame frame = new JFrame("Please select tenant");
								selectedTenant = (String) JOptionPane.showInputDialog(frame,
										"Which tenant do you wish to change details for? ",
										"Please select Tenant's ID number:", JOptionPane.QUESTION_MESSAGE, null,
										tenantIds, tenantIds[0]);
							} else if (textArea.getText().trim().length() == 0) {
								JOptionPane.showMessageDialog(null,
										"No Tenant registered by the name: " + searchTenant);
								foundMatch = true;
								// return null;
							}
							// Now I have the selected tenant ID I must now open a new window displaying
							// their details and allow to change
							for (Tenant tent : tenantList) {
								if (selectedTenant.equals("" + tent.getTenantID())) {
									searchedTenant = tent;
								}
							}
						}
					}

				}
			}

		});

		j.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amendTenMenu.dispose();
			}
		});

		return amdTenant;
	}

	private Tenant searchTenant() {
		boolean foundMatch = false;
		ArrayList<String> tenantIdList = new ArrayList<String>();
		String tenantlIDString = "";
		String selectedTenant = "";
		Object[] tenantIds = {};
		String searchName = JOptionPane.showInputDialog("Enter name of tenant: ");
		Tenant searchedTenant = new Tenant();

		if (searchName.equals("")) {
			JOptionPane.showMessageDialog(null, "No name entered!");
		} else {
			StringBuilder builder = new StringBuilder(ownerList.size());
			while (!foundMatch) {
				for (Tenant ten : tenantsAvailable) {
					if (ten.getName().equalsIgnoreCase(searchName)) {
						builder.append(ten.toString() + "\n");
						tenantlIDString = Integer.toString(ten.getTenantID());
						tenantIdList.add(tenantlIDString);
						tenantIds = tenantIdList.toArray();
						foundMatch = true;
					}
				}
				// JTextArea for displaying the list (StringBuilder)
				JTextArea textArea = new JTextArea(builder.toString());
				JScrollPane scrollPane = new JScrollPane(textArea);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				scrollPane.setPreferredSize(new Dimension(500, 500));

				// Display list if not empty
				if (!(textArea.getText().trim().length() == 0)) {
					JOptionPane.showMessageDialog(null, scrollPane, "List of Owners", JOptionPane.OK_OPTION);
				} else if (textArea.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "No Owner registered by the name: " + searchName);
					foundMatch = true;
					return null;
				}
				// Now I have the selected owner ID I must now open a new window displaying
				// their details and allow to change
//				for (Tenant tent : tenantsAvailable) {
//					if (selectedTenant.equals("" + tent.getTenantID())) {
//						searchedTenant = tent;
//					}
//				}
			}
		}
		return searchedTenant;
	}
}
