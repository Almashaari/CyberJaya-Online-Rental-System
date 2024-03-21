
import java.io.Serializable;

public class Tenant extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4610310004678788881L;
	private final int tenantID;
	private String tenantStatus;
	private static int nextTenantID = 1;

	public Tenant() {
		super();
		setTenantStatus("Unknown");
		tenantID = getNextTenantID();
	}

	public Tenant(String name, String address, String phone, String ic, String role, String username, String password,
			String tenStatus) {
		super(name, address, phone, ic, role, username, password);
		tenantID = getNextTenantID();
		setTenantStatus(tenStatus);
	}

	public int getTenantID() {
		return tenantID;
	}

	public static int getNextTenantID() {
		if (CORS.tenantsAvailable.isEmpty()) {
			int Id = nextTenantID;
			nextTenantID++;
			return Id;
		} else {
			int Id = CORS.tenantsAvailable.get(CORS.tenantsAvailable.size() - 1).getTenantID();
			return (Id + 1);
		}
	}

	public void setTenantStatus(String tenStatus) {
		tenantStatus = tenStatus;
	}

	public String getTenantStatus() {
		return tenantStatus;
	}

	public String toString() {
		return "\n" + super.toString() + "\nTenant ID: " + this.getTenantID() + "\nTenant Status: "
				+ this.getTenantStatus();
	}
}
