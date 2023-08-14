

public class Currency { 
    private String currencyCode; 
    private String currencyName; 
    private double exchangeRate; 
    
    public Currency(String currencyCode, String currencyName, double exchangeRate) { 
        this.currencyCode = currencyCode; 
        this.currencyName = currencyName; 
        this.exchangeRate = exchangeRate; 
    } 
    
    public Currency(String currencyCode, String currencyName) {
    	this.currencyCode = currencyCode;
    	this.currencyName = currencyName;
    }
 
    public String getCurrencyCode() { 
        return currencyCode; 
    } 
 
    public String getCurrencyName() { 
        return currencyName; 
    } 
 
    public double getExchangeRate() { 
        return exchangeRate; 
    } 
 
    public void setExchangeRate(double exchangeRate) { 
        this.exchangeRate = exchangeRate; 
    } 
 
    @Override 
    public String toString() { 
    	String output = String.format("currencyCode= %-7s currencyName= %-10s exchangeRate= %-10.2f", currencyCode, currencyName, exchangeRate);
        return  output;
        		
    }
    
}