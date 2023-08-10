public class ExchangeRate extends Currency {
    private double exchangeRate;

  public ExchangeRate(String currency, String name, double exchangeRate) {
		// TODO Auto-generated constructor stub
	  super(currency, name);
      this.exchangeRate = exchangeRate;
	}

public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

	public Object getTargetCurrency() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getSourceCurrency() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getRate() {
		// TODO Auto-generated method stub
		return 0;
	}
}
