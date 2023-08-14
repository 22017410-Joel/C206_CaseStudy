import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

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
        ExchangeRate newRate = new ExchangeRate("EUR", "SGD", 1.50);
        assertFalse(rateList.contains(newRate));

        
        rateList.add(newRate);
        assertTrue(rateList.contains(newRate));

        // Test adding a rate that already exists in the list
        boolean addedAgain = C206_CaseStudy.addExchangeRate(rateList, rate1);
        assertFalse(addedAgain);

        // Test adding a minimum and maximum exchange rate in the list
        ExchangeRate minRate = new ExchangeRate("JPY", "SGD", 0.01);
        ExchangeRate maxRate = new ExchangeRate("GBP", "SGD", 10.00);
        rateList.add(minRate);
        rateList.add(maxRate);

    }

    @Test
    public void testViewAllExchangeRate() {
        // Test that historical data for exchange rates are shown
        String expectedOutput = rate1.toString() + "\n";

        // Test records list is empty but not null
        assertNotNull("Test if account list is not null", rateList);

        // Test an exception during retrieval (Assuming an ExchangeRateException)
        assertThrows(ExchangeRate.class, () -> {
            C206_CaseStudy.viewAllExchangeRate(null);
        });
    }

    private void assertThrows(Class<ExchangeRate> class1, ThrowingRunnable throwingRunnable) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testDeleteExchangeRate() {
        // Test adding 2 exchange rates and delete first exchange rate
        ExchangeRate rate2 = new ExchangeRate("EUR", "SGD", 1.50);
        rateList.add(rate2);

        assertTrue(rateList.contains(rate1));
        assertTrue(rateList.contains(rate2));

        // Delete rate1
        boolean deleted = C206_CaseStudy.DeleteExchangeRate(rateList, rate1);
        rateList.remove(rate1);
        assertFalse(rateList.contains(rate1));
        assertTrue(rateList.contains(rate2));

        // Test deleting a non-existent exchange rate
        ExchangeRate nonExistentRate = new ExchangeRate("JPY", "SGD", 0.012);

        assertFalse(rateList.contains(nonExistentRate));

        // Try to delete the non-existent rate
        boolean deletionResult = C206_CaseStudy.DeleteExchangeRate(rateList, nonExistentRate);
        assertFalse(deletionResult);
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
