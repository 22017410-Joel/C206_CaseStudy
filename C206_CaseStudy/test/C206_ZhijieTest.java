import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class C206_ZhijieTest {

	private User user1;
	private User user2;

	private ArrayList<User> userlist;

	@Before
	public void setup() throws Exception {
		user1 = new User("U1", "darren", "123", 99999999, "admin");
		user2 = new User("U2", "joel", "111", 88888888, "customer");

		userlist = new ArrayList<User>();
	}

	@Test
	public void testAddUser() {
		assertNotNull(userlist);

		C206_Zhijie.addUser(userlist, user1);

		assertEquals("test that the list has the new user inside it", 1, userlist.size());
		assertSame("test that the new user is the user added in", userlist.get(0), user1);

		C206_Zhijie.addUser(userlist, user2);
		assertEquals("test that the method can detect the other user added in", 2, userlist.size());

		C206_Zhijie.addUser(userlist, user1);
		assertEquals("test that the if we add a duplicated user it will not be added in", 2, userlist.size());
	}

	@Test
	public void testDeleteUser() {
		C206_Zhijie.addUser(userlist, user1);
		assertEquals("test that the user has been added into the list", 1, userlist.size());
		assertSame("test that the user that has been added in is the same as the user in the list", userlist.get(0), user1);

		C206_Zhijie.deleteUser(userlist, "U2");
		assertEquals("Check that the user input given wrongly will not delete any user in the list", 1, userlist.size());

		C206_Zhijie.deleteUser(userlist, "U1");
		assertEquals("Check if the user has been deleted from the list", 0, userlist.size());

	}

	@Test
	public void testRetrieveAllUser() {
		String sentence = C206_Zhijie.retrieveAllUser(userlist);
		String adminoutput = "Admins: \n";
		String customeroutput = "Customer: \n";
		String output = adminoutput + "\n" + customeroutput;
		C206_Zhijie.addUser(userlist, user1);
		assertEquals("Check that list is empty if no user has been added in", output, sentence);
		assertEquals("Ensure that the user has been added in", 1, userlist.size());
		sentence = C206_Zhijie.retrieveAllUser(userlist);
		adminoutput += String.format("%-40s\n", user1.toString());
		output = adminoutput + "\n" + customeroutput;
		assertEquals("Check if the output will display the correct information and the user inside it", output,
				sentence);

		C206_Zhijie.addUser(userlist, user2);
		sentence = C206_Zhijie.retrieveAllUser(userlist);
		customeroutput += String.format("%-40s\n", user2.toString());
		output = adminoutput + "\n" + customeroutput;
		assertEquals("Check that the output will display the customer user in the customer section", output, sentence);
	}

	@After
	public void tearDown() throws Exception {
		user1 = null;
		user2 = null;

		userlist = null;
	}
}
