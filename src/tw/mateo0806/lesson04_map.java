package tw.mateo0806;

import java.util.HashMap;
import java.util.Set;

public class lesson04_map {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "brad");
		map.put("age", 18);
		map.put("gender",true);
		map.put("weight", 80.1);
		System.out.println(map.get("age"));
		System.out.println("----尋訪資料----");
		
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.printf("%s => %s\n", key, map.get(key));
		}
	}

}
