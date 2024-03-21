
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveTester {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// construct a fitness class
		Admin one = new Admin("Admin", "Cyberjaya", "0871234567", "2468965R", "admin", "admin", "123456", "Up to date");
//		Admin two = new Admin("Jemy Chowdhury", "Selangor", "0858372932", "3928652R", "owner", "jemy", "123456",
//				"Up to date");
		ArrayList<Admin> ownerList = new ArrayList<Admin>();
		ownerList.add(one);
//		ownerList.add(two);

		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("files/Admin.txt"));
		os.writeObject(ownerList);
		os.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("files/Admin.txt"));

		ArrayList<Admin> classes;
		// read the list from the stream object
		classes = (ArrayList<Admin>) in.readObject();

		for (Admin line : classes) {
			System.out.println(line.getName() + "\nAdmin id:" + line.getAdminID() + "\nAdmin username:"
					+ line.getUsername() + "\nPassword:" + line.getPassword() + "\n");
		}
		// close the stream
		in.close();
	}
}
