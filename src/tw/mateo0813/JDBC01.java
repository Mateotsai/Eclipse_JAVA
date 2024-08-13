package tw.mateo0813;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC01 {

	public static void main(String[] args) {
		//Load Driver (Connector)載入驅動程式
		//IDE可省略，網頁不行
		
		
		//測試驅動程式是否載入成功
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver"); 
//			System.out.println("Download OK!");
//		} catch (ClassNotFoundException e) {
//			System.out.println(e);
//			throw new RuntimeException();
//		}
		
		//DriverManager連線方式
//		String url01 = "jdbc:mysql://127.0.0.1:3306/brad?user=root&password=root";
//		try(Connection conn = DriverManager.getConnection(url01)){
//			System.out.println("Success Connecting!");
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
		
		//DriverManager連線方式帶參數寫法
//		String url02 = "jdbc:mysql://127.0.0.1:3306/brad";
//		try(Connection conn = DriverManager.getConnection(url02,"root","root")){
//			System.out.println("Success Connecting!");
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
		
		
		
		//Properties連線方法
		String url03 = "jdbc:mysql://127.0.0.1:3306/brad";
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try(Connection conn = DriverManager.getConnection(url03,prop)){
//			System.out.println("Success Connecting!");
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO cust(name,tel,birthday) VALUES('Brad','123','1999-01-02')";
			sql += ", ('Eric','1111','1999-02-02')";
			sql += ", ('Peter','222','1999-03-02')";
			int n = stmt.executeUpdate(sql);
			System.out.println(n);
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		
	}
}
