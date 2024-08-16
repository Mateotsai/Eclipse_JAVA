package tw.mateo0816;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.API.vehicle.Bike;

public class lesson06_OBJOut {
	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/brad";
	private static final String SQL_QUERY = "SELECT * FROM member WHERE id = ? ";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWd);

		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				
				InputStream in = rs.getBinaryStream("bike");

				ObjectInputStream oin = new ObjectInputStream(in);
				Object obj = oin.readObject();
				Bike b1 = (Bike)obj;
				System.out.println(b1.getSpeed());
				
			}else {
				System.out.println("id not exist");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
