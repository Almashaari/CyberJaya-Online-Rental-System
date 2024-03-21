
import java.io.Serializable;

public class Property extends PropertyRent implements Serializable {

	private final int propertyID__;
	private String address__;
	private String beds__;
	private String propertyType__;
	private String rentAmount__;
	private String propertyStatus__;
	private static int nextPropertyID__ = 1;

	public Property() {
		propertyID__ = getNextPropertyID__();
		setAddress__("Unassigned");
		setBeds__("Unassigned");
		setPropertyType__("Unassigned");
		setRentAmount__("Unassigned");
		setPropertyStatus__("Unassigned");
	}

	public Property(String address, String beds, String pType, String rent, String pStatus) {
		propertyID__ = getNextPropertyID__();
		nextPropertyID__++;
		setAddress__(address);
		setBeds__(beds);
		setPropertyType__(pType);
		setRentAmount__(rent);
		setPropertyStatus__(pStatus);
	}

	public int getPropertyID__() {
		return propertyID__;
	}

	public static int getNextPropertyID__() {
		if (CORS.propertyAvailable.isEmpty()) {
			int Id = nextPropertyID__;
			nextPropertyID__++;
			return Id;
		} else {
			int Id = CORS.propertyAvailable.get(CORS.propertyAvailable.size() - 1).getPropertyID__();
			return (Id + 1);
		}
	}

	public void setAddress__(String address) {
		address__ = address;
	}

	public String getAddress__() {
		return address__;
	}

	public void setBeds__(String beds) {
		beds__ = beds;
	}

	public String getBeds__() {
		return beds__;
	}

	public void setPropertyType__(String pType) {
		propertyType__ = pType;
	}

	public String getPropertyType__() {
		return propertyType__;
	}

	public void setRentAmount__(String rent) {
		rentAmount__ = rent;
	}

	public String getRentAmount__() {
		return rentAmount__;
	}

	public void setPropertyStatus__(String pStatus) {
		propertyStatus__ = pStatus;
	}

	public String getPropertyStatus__() {
		return propertyStatus__;
	}

	public String toString() {
		return "\n" + super.toString() + "\nProperty ID: " + this.getPropertyID__() + "\nAddress: "
				+ this.getAddress__() + "\nBeds: " + this.getBeds__() + "\nProperty Type: " + this.getPropertyType__()
				+ "\nRent Amount: " + this.getRentAmount__() + "\nProperty Status: " + this.getPropertyStatus__();
	}
}
