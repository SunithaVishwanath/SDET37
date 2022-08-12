package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ToInsertData {

	public static void main(String[] args) throws SQLException {
		
		//Step1:-to register to database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step-2:to connect with mysql
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
		//step-3:write query
		Statement statement = connection.createStatement();
		String query = "insert into project values('TY_PROJ_002','ravi','11/07/2022','ddddd','completed','0')";
		
		//step-4:execute query
		int result = statement.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("data created");
		}
		else
		{
			System.out.println("data not created");
		}
	}

}
