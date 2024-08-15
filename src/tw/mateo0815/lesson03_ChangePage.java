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
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class lesson03_ChangePage {

	public static void main(String[] args) {
		int rpp = 8; //一頁有幾筆
		
		System.out.println("第幾頁:");
		Scanner scanner = new Scanner(System.in);
		int page = scanner.nextInt();
		int changeRPP = (page-1) * rpp;
		
		Properties prop = new Properties();
		prop.put("user","root");
		prop.put("password","root");
		
		String url = "jdbc:mysql://127.0.0.1:3306/brad";
		
		try {
			Connection conn = DriverManager.getConnection(url,prop);
			String sql = "SELECT * FROM gift ORDER BY id LIMIT ?,?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, changeRPP);
			pstmt.setInt(2, rpp);
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String city = rs.getString("city");
				
				System.out.printf("%s : %s : %s\n" , id , name, city);
			}
			
			

			
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
