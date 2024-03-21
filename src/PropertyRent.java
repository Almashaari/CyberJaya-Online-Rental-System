
import java.io.Serializable;

public class PropertyRent implements Serializable {

	private String property;
	private int propertyAvailable;
	private int propertyRent;

	public void cancelProperty() {
		if (propertyRent > 0)
			propertyRent--;
	}

	public boolean takeProperty() {
		if (propertyRent < propertyAvailable) {
			propertyRent++;
			return true;
		} else
			return false;
	}

	public int placesLeft() {
		return propertyAvailable - propertyRent;
	}

	public int available() {
		return propertyAvailable - propertyRent;
	}

	public PropertyRent(String title, int totCapacity) {
		this.property = title;
		this.propertyAvailable = propertyRent;
		propertyRent = 0;
	}

	public PropertyRent(String className) {
		this(className, 2); // temp, for purposes of testing the class system
	}

	public PropertyRent() {
		this("Title unknown", 0);
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public void setPropertyAvailable(int totCapacity) {
		this.propertyAvailable = totCapacity;
	}

	public String getProperty() {
		return property;
	}

	public int getPropertyAvailable() {
		return propertyAvailable;
	}

	public int getPropertyRent() {
		return propertyRent;
	};

	public String toString() {
		return "\n Property: " + getProperty() + "\n Property Available: " + getPropertyAvailable()
				+ "\n Property Taken: " + getPropertyRent();
	}
}
