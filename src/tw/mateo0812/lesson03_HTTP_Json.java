package tw.mateo0812;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class lesson03_HTTP_Json {

	public static void main(String[] args) {
		try { 				//從農委會抓原始碼JSON然後解析
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");//頁面原始碼
		URLConnection conn = url.openConnection();
		BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(bin));
		
		String line; 
		StringBuffer sb = new StringBuffer();  //整串的JSon全抓來當一個大字串	，不換列	
		while((line = reader.readLine()) != null) {
			sb.append(line);
		}
		bin.close();
		
		 parseJSON(sb.toString());
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);
		System.out.println(root.length());
		
		for (int i=0; i<root.length();i++) {
			JSONObject element = root.getJSONObject(i);
			String findoutName = element.getString("Name");
			String findoutAddress = element.getString("SalePlace");
			String findoutPhone = element.getString("ContactTel");
			
			System.out.printf("%s : %s : %s\n",findoutName,findoutAddress,findoutPhone);
		}
	}

}
