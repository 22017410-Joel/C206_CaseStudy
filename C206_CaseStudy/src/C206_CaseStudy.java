import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Account> accList = new ArrayList<Account>();

		int option = 0;

		while (option != 4) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an Option > ");

			if (option == 1) {
				Account acc = inputAccount();
				C206_CaseStudy.addAccount(accList, acc);
			} else if (option == 2) {
				C206_CaseStudy.viewAllacc(accList);
			} else if (option == 3) {
				C206_CaseStudy.deleteacc(accList);
			} else {
				System.out.println("Invalid option. ");

			}
		}
	}

	private static void menu() {
		C206_CaseStudy.setHeader("Account Managment");
		System.out.println("1. Add new account");
		System.out.println("2. View All Account");
		System.out.println("3. Delete Existing Account");
	}
	// TODO Auto-generated method stub

	private static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");

	}

	private static Account inputAccount() {
		// TODO Auto-generated method stub
		String accountID = Helper.readString("Enter Account ID > ");
		String customerId = Helper.readString("Enter Customer ID > ");
		double balance = Helper.readDouble("Enter Account Balance > $ ");

		return new Account(accountID, customerId, balance);
	}

	private static void addAccount(ArrayList<Account> accList, Account acc) {
		// Add the provided Account object to the ArrayList accList
		accList.add(acc);
		System.out.println("Account added successfully.");
	}

	public static String retrieveAllAccount(ArrayList<Account> AccList) {
		String output = "";

		for (int i = 0; i < AccList.size(); i++) {

			output += String.format(" %-15s %-15s %-10.2f\n", AccList.get(i).getAccountID(),
					AccList.get(i).getCustomerId(), AccList.get(i).getBalance());

		}
		return output;
	}

	private static void viewAllacc(ArrayList<Account> accList) {
		// TODO Auto-generated method stub
		if (accList.isEmpty()) {
			System.out.println("No accounts available.");
		} else {
			C206_CaseStudy.setHeader("ACCOUNT LIST");
			String output = String.format(" %-15s %-15s %-10s\n", "Account ID", "Customer ID", "Balance");
			output += retrieveAllAccount(accList);
			System.out.println(output);
		}
	}

	private static void deleteacc(ArrayList<Account> accList) {
		String accountID = Helper.readString("Enter the account ID to delete > ");
		boolean removed = false;

		for (Account acc : accList) {
			if (acc.getAccountID().equals(accountID)) {
				accList.remove(acc);
				System.out.println("Account deleted successfully.");
				removed = true;
				break;
			}
		}

		if (!removed) {
			System.out.println("Account with the given ID not found.");
		}
	}
}