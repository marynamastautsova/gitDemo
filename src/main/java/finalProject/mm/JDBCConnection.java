package finalProject.mm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String databasename = "marynadb";
		String host = "localhost";
		String port = "3306";
		String dbUsername = "root";
		String dbPassword = "pdc98tsv";
		Connection con =DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + databasename, dbUsername, dbPassword);
		
		Statement s =con.createStatement();
		ResultSet rs = s.executeQuery("select * from EmployeeInfo where name='sam';");
		rs.next();
		System.out.println(rs.getString("location"));
	}

}
