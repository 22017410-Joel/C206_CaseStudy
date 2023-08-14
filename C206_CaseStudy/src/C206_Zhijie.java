import java.util.ArrayList;
import java.util.regex.Pattern;

public class C206_Zhijie {
	public static void main(String[] args) {
		ArrayList<User> userlist = new ArrayList<User>();
		User user1 = new User("U1", "darren", "123", 999, "admin");
		User user2 = new User("U2", "joel", "111", 911, "customer");
		userlist.add(user1);
		userlist.add(user2);

		int choice = 0;

		while (choice != 4) {
			userMenu();
			choice = Helper.readInt("Enter choice: ");
			if (choice == 1) {
				User newuser = newUser();
				String output = addUser(userlist, newuser);
				System.out.println(output);
			} else if (choice == 2) {
				String output = retrieveAllUser(userlist);
				System.out.println(output);
			} else if (choice == 3) {
				String Id = Helper.readString("Enter user ID to delete: ");
				boolean deleteuser = deleteUser(userlist, Id);

				if (deleteuser == false) {
					System.out.println("failed to delete user");
				} else {
					System.out.println("user deleted successfully.");
				}
			}
		}
		System.out.println("Exiting the system.");

	}

	public static void userMenu() {
		System.out.println("Money Exchange Management System");
		System.out.println("1. Add a new user");
		System.out.println("2. View all users");
		System.out.println("3. Delete an existing user");
		System.out.println("4. Exit");
		System.out.print("Enter your choice: ");
	}

	public static User newUser() {

		String ID = Helper.readString("Enter user ID: ");
		String name = Helper.readString("Enter user name: ");
		String password = Helper.readString("Enter user password: ");
		int contactNo = Helper.readInt("Enter user contact: ");
		String role = Helper.readString("Enter user role: ").toLowerCase();

		User user = new User(ID, name, password, contactNo, role);

		return user;
	}

	public static String addUser(ArrayList<User> userlist, User user) {
		String validateUserID = "U\\d{1,}";
		String validateMobile = "[89]\\d{7}";
		String validateRole = "(admin|customer)";
		String sentence = "";
		boolean duplicate = false;

		boolean checkemptyinput = user.getId().isEmpty() || user.getPassword().isEmpty() || user.getId().isEmpty();
		if (checkemptyinput) { // check if inputs are blank
			sentence = "Please input all user information";
			return sentence;
		}

		for (int i = 0; i < userlist.size(); i++) {
			if (userlist.get(i).getId().equalsIgnoreCase(user.getId())) {
				duplicate = true;
				break;
			}
		}
		String stringMobileNo = Integer.toString(user.getContactNo());
		if (Pattern.matches(validateUserID, user.getId()) && Pattern.matches(validateMobile, stringMobileNo)
				&& Pattern.matches(validateRole, user.getRole())) {
			if (!duplicate) { // if duplicate is not true, add user into list
				userlist.add(user);
				sentence = "user added";
			} else {
				sentence = "duplicated user inside list";
			}
		} else {
			sentence = "Invalid values for inputs";
		}

		return sentence;
	}

	public static String retrieveAllUser(ArrayList<User> userlist) {
		String adminoutput = "Admins: \n";
		String customeroutput = "Customer: \n";
		for (int i = 0; i < userlist.size(); i++) {
			if (userlist.get(i).getRole().equalsIgnoreCase("admin")) {
				adminoutput += String.format("%40s\n", userlist.get(i).toString());
			} else if (userlist.get(i).getRole().equalsIgnoreCase("customer")) {
				customeroutput += String.format("%40s\n", userlist.get(i).toString());
			}
		}
		return adminoutput + "\n" + customeroutput;
	}

	public static boolean deleteUser(ArrayList<User> userlist, String id) {
		boolean deleteuser = false;
		for (int i = 0; i < userlist.size(); i++) {
			boolean userId = userlist.get(i).getId().equalsIgnoreCase(id);
			if (userId) {
				userlist.remove(i);
				deleteuser = true;
				break;
			}
		}

		return deleteuser;
	}
}
