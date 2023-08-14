import java.util.ArrayList;

public class RateManagement {
	public static void main(String [] args) {
	ArrayList<ExchangeRate> rateList = new ArrayList<ExchangeRate>();
	
	int option = 0;
	
	while (option != 4) {
		RateManagement.menu();
		option = Helper.readInt("Enter an option > ");
		
		if(option == 1) {
			ExchangeRate exchangerate = inputExchangeRate();
			RateManagement.addExchangeRate(rateList, exchangerate);
			
			
		}else if (option == 2) {
			RateManagement.viewAllExchangeRate(rateList);
			
		}else if (option == 3) {
			RateManagement.deleteExchangeRate(rateList);


		}else {
			System.out.println("Invalid option.");
		}
	}}

	private static void menu() {
		// TODO Auto-generated method stub
		RateManagement.setHeader("Rate Management");
		System.out.println("1. Add new rate");
		System.out.println("2. View All Rate");
		System.out.println("3. Delete Existing Rate");
		
		
		
	}

	private static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
		
	}

	private static ExchangeRate inputExchangeRate() {
        String currency = Helper.readString("Enter rate code > ");
        String name = Helper.readString("Enter name > ");
        double exchangeRate = Helper.readDouble("Enter exchange rate > ");

        ExchangeRate exchangerate = new ExchangeRate(currency, name, exchangeRate);
        return exchangerate;
    }

	public static boolean addExchangeRate(ArrayList<ExchangeRate> rateList, ExchangeRate exchangerate) {
        rateList.add(exchangerate);
        System.out.println("Exchange rate added successfully.");
		return false;
    }

    public static void viewAllExchangeRate(ArrayList<ExchangeRate> rateList) {
        if (rateList.isEmpty()) {
            System.out.println("No exchange rates available.");
        } else {
            System.out.println("All Exchange Rates: ");
            for (ExchangeRate rate : rateList) {
                System.out.println(rate);
            }
        }
    }

    public static void deleteExchangeRate(ArrayList<ExchangeRate> rateList) {
        if (rateList.isEmpty()) {
            System.out.println("No exchange rates available to delete.");
        } else {
            String currencyToDelete = Helper.readString("Enter currency to delete > ");
            ExchangeRate rateToDelete = null;
            for (ExchangeRate rate : rateList) {
                if (rate.getCurrencyCode().equalsIgnoreCase(currencyToDelete)) {
                    rateToDelete = rate;
                    break;
                }
            }
            if (rateToDelete != null) {
                rateList.remove(rateToDelete);
                System.out.println("Exchange rate deleted successfully.");
            } else {
                System.out.println("Currency not found.");
            }
        }
    }

	public static boolean deleteExchangeRate(ArrayList<ExchangeRate> rateList, ExchangeRate rate1) {
		// TODO Auto-generated method stub
		return false;
	}
}