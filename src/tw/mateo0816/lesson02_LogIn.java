package tw.mateo0816;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import org.mindrot.BCrypt;

public class lesson02_LogIn {
	static Connection conn;

	public static void main(String[] args) {
		System.out.println("Log In...... ");
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		String url = "jdbc:mysql://127.0.0.1:3306/brad";

		try {
			conn = DriverManager.getConnection(url, prop);
			
			Scanner scanner = new Scanner(System.in);

			System.out.println("Account: ");
			String account = scanner.next();
			System.out.println("Password: ");
			String passwd = scanner.next();
			
			String sql = "SELECT * FROM member WHERE account = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,account);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String hashPasswd = rs.getString("passwd");
				if(BCrypt.checkpw(passwd, hashPasswd)) {
					System.out.println("Login Success");
					
				}else {
					System.out.println("Login Failture(1)");
				}
			}else {
				System.out.println("Login Failture(1)");
			}

			
		}catch(Exception e){
		System.out.println(e);
	}
}
}
