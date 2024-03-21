
import java.io.Serializable;

public class Admin extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3958803520631813911L;
	private final int adminID__;
	private String adminStatus__;
	private static int nextAdminID__ = 1;

	public Admin() {
		super();
		setAdminStatus("Active");
		adminID__ = getNextID();
	}

	public Admin(String name, String address, String phone, String ic, String role, String username, String password,
			String adminStatus) {
		super(name, address, phone, ic, role, username, password);
		adminID__ = getNextID();
		setAdminStatus(adminStatus);
	}

	public int getAdminID() {
		return adminID__;
	}

	public static int getNextID() {
		if (CORS.adminList.isEmpty()) {
			int Id = nextAdminID__;
			nextAdminID__++;
			return Id;
		} else {
			int Id = CORS.adminList.get(CORS.adminList.size() - 1).getAdminID();
			return (Id + 1);
		}
	}

	public void setAdminStatus(String lanStatus) {
		adminStatus__ = lanStatus;
	}

	public String getAdminStatus() {
		return adminStatus__;
	}

	public String toString() {
		return "\n" + super.toString() + "\nAdmin ID: " + this.getAdminID() + "\nAdmin Status: "
				+ this.getAdminStatus();
	}
}
