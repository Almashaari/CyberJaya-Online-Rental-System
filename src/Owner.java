
import java.io.Serializable;

public class Owner extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3958803520631813911L;
	private final int ownerID__;
	private String ownerStatus__;
	private static int nextOwnerID__ = 1;

	public Owner() {
		super();
		setOwnerStatus("Unknown");
		ownerID__ = getNextID();
	}

	public Owner(String name, String address, String phone, String ic, String role, String username, String password,
			String ownerStatus) {
		super(name, address, phone, ic, role, username, password);
		ownerID__ = getNextID();
		setOwnerStatus(ownerStatus);
	}

	public int getOwnerID() {
		return ownerID__;
	}

	public static int getNextID() {
		if (CORS.ownerList.isEmpty()) {
			int Id = nextOwnerID__;
			nextOwnerID__++;
			return Id;
		} else {
			int Id = CORS.ownerList.get(CORS.ownerList.size() - 1).getOwnerID();
			return (Id + 1);
		}
	}

	public void setOwnerStatus(String lanStatus) {
		ownerStatus__ = lanStatus;
	}

	public String getOwnerStatus() {
		return ownerStatus__;
	}

	public String toString() {
		return "\n" + super.toString() + "\nOwner ID: " + this.getOwnerID() + "\nOwner Status: "
				+ this.getOwnerStatus();
	}
}
