package tw.API.gift;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class GiftDB {
	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/brad";
	private static final String SQL_QUERY = "SELECT * FROM gift";

	private Connection conn;
	private ResultSet rs;
	private String[] fields;

	public GiftDB() throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWd);

		conn = DriverManager.getConnection(URL, prop);

	}

	public void query() throws SQLException {
		query(SQL_QUERY);
	}

	public void query(String sql) throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);

		// getCols()的前置作業
		ResultSetMetaData rsmd = rs.getMetaData();
		fields = new String[rsmd.getColumnCount()];
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			fields[i] = rsmd.getColumnLabel(i + 1);
//			System.out.println(fields[i]);
		}
	}

	public int getRows() {
		try {
			rs.last(); // 移到最後一列，返回最後一列的數字，即是列的總比數
			return rs.getRow();
		} catch (SQLException e) {
			return 0;
		}
	}

	public int getCols() {
		return fields.length;
	}

	// row 0-base 要加一
	// 將資料一一丟進欄位中
	public String getData(int row, int col) {
		try {
			rs.absolute(row + 1);
			return rs.getString(fields[col]);
		} catch (Exception e) {
			return "ERROR";
		}
	}

	public String[] getfieldNames() {
		return fields;
	}

	// 刪除資料按鈕功能
	public void delData(int row) throws SQLException {
		rs.absolute(row + 1);
		rs.deleteRow();
	}

	public void updateData(String newdata, int row, int col) {
		try {
			rs.absolute(row + 1);
			rs.updateString(col + 1, newdata);
			rs.updateRow();
		} catch (SQLException e) {
			System.out.println(e);

		}
	}
	
	  public void addNewGift(String[] data) throws SQLException {
	        StringBuilder sql = new StringBuilder("INSERT INTO gift (");
	        for (int i = 1; i < fields.length; i++) {
	            sql.append(fields[i]);
	            if (i < fields.length - 1) sql.append(", ");
	        }
	        sql.append(") VALUES (");
	        for (int i = 0; i < data.length; i++) {
	            sql.append("?");
	            if (i < data.length - 1) sql.append(", ");
	        }
	        sql.append(")");

	        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
	            for (int i = 0; i < data.length; i++) {
	                pstmt.setString(i + 1, data[i]);
	            }
	            pstmt.executeUpdate();
	        }

	        // 重新查詢以更新結果集
	        query();
	    }
	
	
	
	
	
	
	
}
