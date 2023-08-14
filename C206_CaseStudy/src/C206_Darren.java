

import java.util.ArrayList; 
 
public class C206_Darren {
	
	public static void main(String[] args) {
		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		currencyList.add(new Currency("SGD", "SG Dollar", 1.0));
		currencyList.add(new Currency("USD", "US Dollar", 1.0));
		int option = -1;
		
		while (option != 4) {
			if (option == 1) {
				Currency currency = inputAddCurrency();
				addCurrency(currency, currencyList);
			} else if (option == 2) {
				String viewAllcurrencies = viewAllCurrency(currencyList);
				System.out.println(viewAllcurrencies);
			} else if (option == 3) {
				String codeDelete = Helper.readString("Enter currency code to delete: ");
				deleteCurrency(currencyList, codeDelete);
			}
			currencyMenu();
			option = Helper.readInt("Enter the option: ");
		}
	}
	
	public static void currencyMenu() {
		System.out.println("Money Exchange Management System"); 
        System.out.println("1. Add a new currency"); 
        System.out.println("2. View all currencies"); 
        System.out.println("3. Delete an existing currency"); 
        System.out.println("4. Exit"); 
	}
	
	public static Currency inputAddCurrency() {
		Currency currency = null;
		String code = Helper.readString("Enter currency code: ");
		String name = Helper.readString("Enter currency name: ");
		char yesNo = Helper.readChar("Does currency have rate? (Y/N): ");
		if (yesNo == 'y' || yesNo == 'Y') {
			double rate = Helper.readDouble("Enter exchange rate: ");
			currency = new Currency(code, name, rate);
		} else if (yesNo == 'n' || yesNo == 'N') {
			currency = new Currency(code, name);
		}
		
		return currency;
	}
	
	public static void addCurrency(Currency currency,ArrayList<Currency> currencyList) {
		
		boolean addCurrency = false;
		boolean duplicatedCurrency = false;

		for (int i = 0; i < currencyList.size(); i++) {
			// refactor local variable
			boolean checkDuplicate = currencyList.get(i).getCurrencyCode().compareTo(currency.getCurrencyCode()) == 0;
			if (checkDuplicate) {
				duplicatedCurrency = true;
				break;
			}
		}

		if (!duplicatedCurrency) {
			currencyList.add(currency);
			addCurrency = true;
		}

		if (!addCurrency) {
			System.out.println("Duplicated currency");
		}
	}

	public static String viewAllCurrency(ArrayList<Currency> currencyList) { 
		String viewAllcurrencies = "All Currencies: \n";
        for (Currency currency : currencyList) { 
             viewAllcurrencies += String.format("%-27s\n",currency.toString()); // changed to toString 
        } 
        return viewAllcurrencies;
	}
	
	public static void deleteCurrency(ArrayList<Currency> currencyList, String code) {
		boolean deleteCurrency = false;
		for (int i = 0; i< currencyList.size(); i++) {
			// refactor local variable
			boolean currencyCode = currencyList.get(i).getCurrencyCode().equalsIgnoreCase(code);
			if (currencyCode) {
				currencyList.remove(i);
				deleteCurrency = true;
				break;
			}
		}
		
		if (deleteCurrency == false) {
			System.out.println("Delete currency failed.");
		} else {
			System.out.println("Currency Deleted.");
		}
	}
}