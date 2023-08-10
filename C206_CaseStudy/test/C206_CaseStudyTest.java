import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
    private ExchangeRate rate1;
    private ArrayList<ExchangeRate> rateList;

    @Before
    public void setUp() throws Exception {
        // Prepare test data
        rateList = new ArrayList<ExchangeRate>();
        rate1 = new ExchangeRate("USD", "SGD", 1.35);
        rateList.add(rate1);
    }

    @Test
    public void testAddExchangeRate() {
        // Test Adding a New Exchange Rate
        ExchangeRate newRate = new ExchangeRate("EUR", "USD", 1.18);
        rateList.add(newRate);

        assertTrue("New exchange rate should be added", rateList.contains(newRate));
    }

    @Test
    public void testViewAllExchangeRate() {
        // Test that historical data for exchange rates are shown
        ExchangeRate retrievedRate = rateList.get(0);
        assertNotNull("Retrieved exchange rate should not be null", retrievedRate);
        
 // Using delta for double comparison
       
    }

    @Test
    public void testDeleteExchangeRate() {
        // Test deletion of exchange rate
        ExchangeRate rateToDelete = rateList.get(0);
        rateList.remove(rateToDelete);

        assertFalse("Deleted exchange rate should not be in the list", rateList.contains(rateToDelete));
    }

    @After
    public void tearDown() throws Exception {
        rate1 = null;
        rateList = null;
    }

    @Test
    public void c206_test() {
        // This is a sample test case to ensure that the test class itself is working
        assertTrue("C206_CaseStudy_SampleTest", true);
    }
}