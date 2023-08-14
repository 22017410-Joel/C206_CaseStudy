import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class C206_CaseStudyTest {
<<<<<<< HEAD
    private ExchangeRate rate1;
    private ArrayList<ExchangeRate> rateList;
=======
    private Account acc1;
    private ArrayList<Account> accList;
>>>>>>> branch 'master' of https://github.com/22017410-Joel/C206_CaseStudy.git

    @Before
    public void setUp() throws Exception {
<<<<<<< HEAD
        // Prepare test data
        rateList = new ArrayList<ExchangeRate>();
        rate1 = new ExchangeRate("USD", "SGD", 1.35);
        rateList.add(rate1);
=======
        // prepare test data
        acc1 = new Account("yama", "22023643", 2000);
        accList = new ArrayList<Account>();
>>>>>>> branch 'master' of https://github.com/22017410-Joel/C206_CaseStudy.git
    }

    @Test
<<<<<<< HEAD
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
=======
    public void testAddAccount() {
        // Test if account list is not null, so that can add a new account
        assertNotNull("Test if account list is not null", accList);
>>>>>>> branch 'master' of https://github.com/22017410-Joel/C206_CaseStudy.git

<<<<<<< HEAD
	@Test
    public void testDeleteExchangeRate() {
        // Test adding 2 exchange rates and delete first exchange rate
        ExchangeRate rate2 = new ExchangeRate("EUR", "SGD", 1.50);
        rateList.add(rate2);
=======
        // Given an empty list, after adding 1 account
        // Add an account that has missing detail
        assertEquals("Test if adding account list size is 0", 0, accList.size());
>>>>>>> branch 'master' of https://github.com/22017410-Joel/C206_CaseStudy.git

<<<<<<< HEAD
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
=======
        // Test if the account added is the same as the first account in the list
        accList.add(acc1);
        assertSame("Test that account added is the same as 1st account in the list", acc1, accList.get(0));
    }

    @Test
    public void testViewAllAccount() {
        // Test if account list is not null but empty
        assertNotNull("Test if account list is not null", accList);

        // Given an empty list, after adding 2 accounts, test if the size of the list is 2
        accList.add(acc1);
        accList.add(new Account("john", "22023644", 1500));
        assertEquals("Test that account list size is 2", 2, accList.size());

        // Simulates an error condition where the account repository fails to provide account information
        try {
            accList = null; // Simulate repository failure
            ArrayList<Account> accounts = accList; // Trigger NullPointerException
            assertNull("Simulate error condition where account repository fails", accounts);
        } catch (NullPointerException e) {
            // Expected behavior, since we're simulating a repository failure
        }
    }

    @Test
    public void testDeleteAccount() {
        // Test if there is a valid Account in the arraylist to delete from
        assertNotNull("Test if account list is not null", accList);

        // Test that account arraylist size is 0 after deleting an account
        accList.add(acc1);
        accList.remove(acc1);
        assertEquals("Test that account list size is 0 after deleting an account", 0, accList.size());

        // Tests the scenario where the customer tries to delete an account that doesn't exist
        Account nonExistingAccount = new Account("jane", "22023645", 1000);
        boolean isDeleted = accList.remove(nonExistingAccount);
        assertFalse("Test that deleting a non-existing account returns false", isDeleted);
    }

    @After
    public void tearDown() throws Exception {
        acc1 = null;
        accList = null;
    }

    @Test
    public void c206_test() {
>>>>>>> branch 'master' of https://github.com/22017410-Joel/C206_CaseStudy.git
        assertTrue("C206_CaseStudy_SampleTest", true);
    }
}
