
import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1102083847607348335L;
	private String name__;
	private String address__;
	private String phoneNumber__;
	private String ic__;
	private String role__;
	private String username__;
	private String password__;

	public Person() {
		name__ = "";
		address__ = "";
		phoneNumber__ = "";
		ic__ = "";
		role__ = "";
		username__ = "";
		password__ = "";
	}

	public Person(String name, String address, String phone, String ic, String role, String username, String password) {
		setName(name);
		setAddress(address);
		setPhoneNumber(phone);
		setIC(ic);
		setRole(role);
		setUsername(username);
		setPassword(password);
	}

	public String getUsername() {
		return username__;
	}

	public void setUsername(String username) {
		this.username__ = username;
	}

	public void setPassword(String password) {
		password__ = password;
	}

	public String getPassword() {
		return password__;
	}

	public void setName(String name) {
		name__ = name;
	}

	public String getName() {
		return name__;
	}

	public void setAddress(String address) {
		address__ = address;
	}

	public String getAddress() {
		return address__;
	}

	public void setPhoneNumber(String phone) {
		phoneNumber__ = phone;
	}

	public String getPhoneNumber() {
		return phoneNumber__;
	}

	public void setIC(String ic) {
		ic__ = ic;
	}

	public String getIC() {
		return ic__;
	}

	public String getRole() {
		return role__;
	}

	public void setRole(String role) {
		role__ = role;
	}

	public String toString() {
		return "Name: " + this.getName() + "\nAddress: " + this.getAddress() + "\nPhone Number: "
				+ this.getPhoneNumber() + "\nIC Number: " + this.getIC();
	}

}
