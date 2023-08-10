import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
    private Account acc1;
    private ArrayList<Account> accList;

    @Before
    public void setUp() throws Exception {
        // prepare test data
        acc1 = new Account("yama", "22023643", 2000);
        accList = new ArrayList<Account>();
    }

    @Test
    public void testAddAccount() {
        // Test if account list is not null, so that can add a new account
        assertNotNull("Test if account list is not null", accList);

        // Given an empty list, after adding 1 account
        // Add an account that has missing detail
        assertEquals("Test if adding account list size is 0", 0, accList.size());

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
        assertTrue("C206_CaseStudy_SampleTest", true);
    }
}
