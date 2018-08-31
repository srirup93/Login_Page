package ExamplePackage;
import java.sql.*;
import java.util.*;
public class ConnectionManager {
	static Connection con;
	static String url;
	
	public static Connection getConnection() throws ClassNotFoundException
	{
		url="jdbc:mysql://localhost:3306/srirup";
		String uName="root";
		String pwd="admin";
		
		 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, uName, pwd);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
