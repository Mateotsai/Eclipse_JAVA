package tw.mateo0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class Map_OpenData {

	public static void main(String[] args) {
		try (FileReader reader = new FileReader("./dir1/ns1hosp.csv");
				BufferedReader br = new BufferedReader(reader);){
			//補上自動關閉功能
			String line;
			while((line = br.readLine()) != null) {
				String[] data = line.split(",");
				System.out.printf("%s:%s:%s:%s\n",data[1],data[2],data[4],data[7]);
			}
			
			System.out.println("資料讀取完畢!");
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
