import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CORS {
	public static ArrayList<Admin> adminList = new ArrayList<>();
	public static ArrayList<Owner> ownerList = new ArrayList<>();
	public static ArrayList<Property> propertyList = new ArrayList<>();
	public static ArrayList<Property> propertyAvailable = new ArrayList<>();
	public static ArrayList<Property> propertyLet = new ArrayList<>();

	public static ArrayList<Tenant> tenantsAvailable = new ArrayList<>();
	public static ArrayList<Tenant> tenantList = new ArrayList<>();
	public static ArrayList<Rental> rentalList = new ArrayList<>();

	private static void loadDatabases() {
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

	private static void loadOwnersFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/Owners.txt"));
			CORS.ownerList = (ArrayList<Owner>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Owners successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading Owners.txt file");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading the Owners file. System closing\n");
		}
	}

	private static void loadPropertiesListFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/PropertyList.txt"));
			CORS.propertyList = (ArrayList<Property>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Properties successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading propertiesList.txt file");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading the Properties file. System closing\n");
		}
	}

	private static void loadPropertiesFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/Property.txt"));
			CORS.propertyAvailable = (ArrayList<Property>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Properties successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading properties.txt file");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading the Properties file. System closing\n");
		}
	}

	private static void loadPropertiesLetFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/PropertyRent.txt"));
			CORS.propertyLet = (ArrayList<Property>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Properties successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading properties.txt file");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading the Properties file. System closing\n");
		}
	}

	private static void loadTenantsFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/Tenants.txt"));
			CORS.tenantsAvailable = (ArrayList<Tenant>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Tenants successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading Tenants.txt file");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading the Tenants file. System closing\n");
		}
	}

	private static void loadTenantsListFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/TenantsList.txt"));
			CORS.tenantList = (ArrayList<Tenant>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Tenants successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading Tenants.txt file");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading the Tenants file. System closing\n");
		}
	}

	private static void loadRentalsFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/Rentals.txt"));
			CORS.rentalList = (ArrayList<Rental>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Rentals successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading Rentals.txt file");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading the Rentals file. System closing\n");
		}
	}

	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		loadDatabases();

		MainWindow mainWindow__ = new MainWindow();
		// registerOwnerGUI__.setVisible(false);
//		Owner owner__ = new Owner();
		MainWindowController mainWController = new MainWindowController(mainWindow__);
		mainWindow__.setVisible(true);
	}

}
