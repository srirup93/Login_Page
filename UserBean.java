package ExamplePackage;

public class UserBean {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	public boolean valid;
	public boolean regSuccess;
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String newFirstName)
	{
		firstName=newFirstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String newPassword)
	{
		password=newPassword;
	}
	public void setLastName(String newLastName)
	{
		lastName=newLastName;
	}
	
	public String getUserName()
	{
		return username;
	}
	
	public void setUserName(String newUserName)
	{
		username=newUserName;
	}
	
	public boolean isValid()
	{
		return valid;
	}
	
	public void setValid(boolean newValid)
	{
		valid=newValid;
	}
	
	public boolean isRegistered()
	{
		return regSuccess;
	}
	
	public void setRegistered(boolean newReg)
	{
		regSuccess=newReg;
	}
}
