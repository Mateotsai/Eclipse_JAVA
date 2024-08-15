package tw.mateo0815;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class lesson01_JDBC {

	public static void main(String[] args) {
	
		Properties prop = new Properties();
		prop.put("user","root");
		prop.put("password","root");
		
		String url = "jdbc:mysql://127.0.0.1:3306/brad";
		
		try {
			Connection conn = DriverManager.getConnection(url,prop);
			String sql = "SELECT * FROM gift ORDER BY city";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String city = rs.getString("city");
				
				System.out.printf("%s : %s : %s\n" , id , name, city);
			}
			
			
//			rs.next();
//			
//			int id = rs.getInt(1);
//			System.out.println(id);
//			rs.getInt("id");
//			System.out.println(id);
//			
//			String name = rs.getString(2);
//			System.out.println(name);
//			rs.getString("name");
//			System.out.println(name);
//			
//			String idString = rs.getString("id");
//			System.out.println(idString);
//			
//			System.out.println("----------");
//			
//			rs.next();
////			System.out.println(rs.getRow());
//			id = rs.getInt("id");
//			System.out.println(id);
//			name = rs.getString("name");
//			System.out.println(name);
//			
//			System.out.println("----------");
//			rs.next();
//			System.out.println(rs.getRow());
//			String feature = rs.getString("feature");
//			System.out.println(feature);
//			
//			System.out.println("----------");
//			rs.next();
//			System.out.println(rs.getRow());
//			String addr = rs.getString("addr");
//			System.out.println(addr);
			
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
