package tw.mateo0813;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC04 {

	public static void main(String[] args) {

		String url = "jdbc:mysql://127.0.0.1:3306/brad";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try(Connection conn = DriverManager.getConnection(url,prop)){
			String name = "Anny";
			String tel = "123456";
			String birthday = "1999-03-04";
			int id = 4;
			//?皆為使用者透過前端可輸入的位置，使用"?"避免隱碼攻擊
			String sql = "UPDATE cust SET name = ?, tel = ?, birthday = ? WHERE id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, birthday);
			pstmt.setInt(4, id);
			
			pstmt.executeUpdate();
			System.out.println("OK");
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
}
