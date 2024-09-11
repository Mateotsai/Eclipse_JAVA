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



public class lesson02_SQL2 {
	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/brad";
	private static final String SQL_QUERY = "SELECT * FROM gift";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWd);

		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY,
															ResultSet.TYPE_SCROLL_INSENSITIVE, 
															ResultSet.CONCUR_UPDATABLE );
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s : %s \n", id, name);
			}
			System.out.println("-------------");
			if (rs.first()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s : %s \n", id, name);
			}
			
			System.out.println("-------------");
			if (rs.absolute(47)){
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s : %s \n", id, name);
			}
			System.out.println("------更改一列中的資訊-------");
			rs.updateString("name", "我改名字囉");
			rs.updateString("town", "我改地址囉");
			rs.updateRow(); //直接下SQL update語句，更動網路資料
			
			String id = rs.getString("id");
			String name = rs.getString("name");
			System.out.printf("%s : %s \n", id, name);
			
//			System.out.println("-------刪掉一列------");
//			rs.deleteRow();
//			id = rs.getString("id");  //47被砍掉後，游標改至46的位置
//			name = rs.getString("name");
//			System.out.printf("%s : %s \n", id, name);
			
			System.out.println("-------新增一列------");
			rs.moveToInsertRow();
			rs.updateString("name", "新增名字囉");
			rs.updateString("feature", "");
			rs.updateString("addr", "新增");
			rs.updateString("picurl", "新增");
			rs.updateString("city", "新增");
			rs.updateString("town", "新增地址囉");
			rs.updateDouble("lat", 0.0);
			rs.updateDouble("lng", 0.0);
			rs.insertRow();

			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
