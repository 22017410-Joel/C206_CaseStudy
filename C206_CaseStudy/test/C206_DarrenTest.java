import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class C206_DarrenTest {

	private Currency c1;
	private Currency c2;
	
	private ArrayList<Currency> currencyList;

    @Before
    public void setup() throws Exception {
        c1 = new Currency("USD", "US Dollar", 1.0);
        c2 = new Currency("EUR", "Euro", 0.85);
        
        currencyList = new ArrayList<Currency>();
    }

    @Test
    public void testAddCurrency() {
    	assertNotNull(currencyList);
    	
        C206_Darren.addCurrency(c1, currencyList);
        
        assertEquals("Check that the currency has been added into the list", 1, currencyList.size());
        assertSame("Check the currency is the same as the one added in", currencyList.get(0), c1);
        
        C206_Darren.addCurrency(c2, currencyList);
        assertEquals("Check that the currency has been added into the list", 2, currencyList.size());
        
        C206_Darren.addCurrency(c1, currencyList);
        assertEquals("Check if add duplicated currencies it wont add it in", 2, currencyList.size());
    }
    
    @Test
    public void testDeleteCurrency() {
    	C206_Darren.addCurrency(c1, currencyList);
        assertEquals("Check that the currency has been added into the list", 1, currencyList.size());
        assertSame("Check the currency is the same as the one added in", currencyList.get(0), c1);
        
        C206_Darren.deleteCurrency(currencyList, "USD");
        assertEquals("Check if the currency has been deleted", 0, currencyList.size());
        
        C206_Darren.addCurrency(c1, currencyList);
        assertEquals("Check that the currency has been added into the list", 1, currencyList.size());
        assertSame("Check the currency is the same as the one added in", currencyList.get(0), c1);
        
        C206_Darren.deleteCurrency(currencyList, "USDD");
        assertEquals("Check if the currency has not been deleted due to wrong input", 1, currencyList.size());
    }

    @Test
    public void testViewAllCurrencies() {
    	C206_Darren.addCurrency(c1, currencyList);
        
        assertEquals("Check that the currency has been added into the list", 1, currencyList.size());
        String sentence = C206_Darren.viewAllCurrency(currencyList);
        String output = "All Currencies: \n";
        output += String.format("%-27s\n", c1.toString());
        assertEquals("Check if the output is the same as the method", output, sentence);
        
        C206_Darren.addCurrency(c2, currencyList);
        sentence = C206_Darren.viewAllCurrency(currencyList);
        output += String.format("%-27s\n", c2.toString());
        assertEquals("Check if the output is the same if we add a new currency", output, sentence);
    }
    
    @After
    public void tearDown() throws Exception{
    	c1 = null;
    	c2 = null;
    	
    	currencyList = null;
    }
}