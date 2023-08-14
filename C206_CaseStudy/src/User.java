public class User {
	private String Id;
	private String username;
	private String password;
	private int contactNo;
	private String role;

	public User(String Id, String username, String password, int contactNo, String role) {
		this.Id = Id;
		this.username = username;
		this.password = password;
		this.contactNo = contactNo;
		this.role = role;
	}

	public String getId() {
		return Id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String toString() {
		String output = String.format("Username= %-10s username= %-10s Contact= %-10d Role: %-10s", Id, username,
				contactNo, role);
		return output;
	}
}
