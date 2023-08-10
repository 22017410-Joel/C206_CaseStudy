
public class Account {
	private  String accountID;
	private String customerId;
    private double balance;
    private String status;
    
    public Account(String accountID, String customerId,double balance) {
        this.accountID = accountID;
        this.customerId = customerId;
        this.balance = balance;
        this.status = "Active";

}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

