package ExamplePackage;
import java.text.*;
import java.util.*;
import java.sql.*;
public class UserDAO {
	static Connection currentCon=null;
	static ResultSet rs=null;
	
	public static UserBean login(UserBean bean)
	{
		Statement stmt=null;
		
		String userName=bean.getUserName();
		String password=bean.getPassword();
		String searchQuery="select * from users where UserName='"+userName+"' AND Password='"+ password+ "'";
		System.out.println("Your Name is :"+userName);
		System.out.println("Your Password is :"+password);
		System.out.println("Query :"+searchQuery);
		//ConnectionManager con1=new ConnectionManager();
		try {
			currentCon=ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
			rs=stmt.executeQuery(searchQuery);
			boolean more=rs.next();
			if(!more)
			{
				System.out.println("Sorry you are not a registered user! Please Sign up first.");
				bean.setValid(false);
			}
			else if(more)
			{
				String firstName=rs.getString("FirstName");
				String lastName=rs.getString("LastName");
				System.out.println("Welcome :"+firstName);
				bean.setFirstName(firstName);
				bean.setLastName(lastName);
				bean.setValid(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		finally {
			
			if(rs!=null)
			{
				try {
					rs.close();
				}catch(Exception e) {
				}
				rs=null;
			}
			
			if(stmt!=null)
			{
				try {
					stmt.close();
				}catch(Exception e) {}
				stmt=null;
			}
			
			if(currentCon!=null)
			{
				try {
					currentCon.close();
				}catch(Exception e) {}
				currentCon=null;
			}
		}
		
		return bean;
		
	}
	
	public static UserBean register(UserBean bean)
	{
		Statement st2=null;
		String firstName=bean.getFirstName();
		String lastName=bean.getLastName();
		String userName=bean.getUserName();
		String password=bean.getPassword();
		
		String query="insert into users (FirstName,LastName,UserName,Password) values ('" + firstName + "','" + lastName + "','" + userName + "','" + password + "')";
		
		try {
			currentCon=ConnectionManager.getConnection();
			st2=currentCon.createStatement();
			int i=st2.executeUpdate(query);
			if(i>0)
			{
				bean.setRegistered(true);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {

			if(st2!=null)
			{
				try {
					st2.close();
				}catch(Exception e) {}
				st2=null;
			}
			
			if(currentCon!=null)
			{
				try {
					currentCon.close();
				}catch(Exception e) {}
				currentCon=null;
			}
		}
		return bean;
	}
}
