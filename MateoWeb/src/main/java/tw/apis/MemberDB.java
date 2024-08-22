package tw.apis;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.mindrot.BCrypt;

public class MemberDB {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost/brad";
	private static final String SQL_CHECK = "SELECT count(account) count FROM member WHERE account = ?";
	private static final String SQL_INSERT = "INSERT INTO member (account,passwd,name) VALUES (?,?,?)";
	private static final int INSERT_ACCOUNT = 1;
	private static final int INSERT_PASSWD = 2;
	private static final int INSERT_NAME = 3;
	
	private Connection conn;
	
	public MemberDB() throws Exception{
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("passwd", PASSWORD);
		
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, prop);
	}

	
	public boolean isAccountExsisting(String account) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL_CHECK);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count") > 0; 
			//count是上面SQL查詢設定的別名(搜尋到的帳號)，判斷>0代表帳號重複
		} catch (SQLException e) {
			System.out.println("ERROR(isAccountExsisting)");
		}
		return true;
	}
	public boolean addMember(String account, String passwd, String name) throws Exception{
		PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
		pstmt.setString(INSERT_ACCOUNT, account);
		pstmt.setString(INSERT_PASSWD, BCrypt.hashpw(passwd,BCrypt.gensalt() ));
		pstmt.setString(INSERT_NAME, name);
		
		return  pstmt.executeUpdate() > 0;
		
	}
		
}

