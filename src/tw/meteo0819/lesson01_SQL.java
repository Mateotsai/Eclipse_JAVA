package tw.meteo0819;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.API.vehicle.Bike;




/*
 SELECT e.EmployeeID, e.LastName,sum(od.UnitPrice * od.Quantity) total FROM orders o 
join orderdetails od on (o.orderID = od.OrderID) 
join employees e ON (o.EmployeeID = e.EmployeeID) 
GROUP by o.EmployeeID order by total desc;
*/

/*驗算
 select sum(unitprice*quantity) fro, orderdetails
 where orderID in(
 select OrderID FrOM orders
 Where employeeID = 5
 ) 
 */


public class lesson01_SQL {
	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/northwind";
	private static final String SQL_QUERY = "SELECT e.EmployeeID, e.LastName,SUM(od.UnitPrice * od.Quantity) total FROM orders o "+
											 "JOIN orderdetails od ON (o.orderID = od.OrderID) " +
											 "JOIN employees e ON (o.EmployeeID = e.EmployeeID) " +
											 "GROUP BY o.EmployeeID " +
											 "ORDER BY total DESC";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWd);

		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("EmployeeID");
				String name = rs.getString("LastName");
				String total = rs.getString("total");
				System.out.printf("%s : %s: %s\n", id, name, total);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
