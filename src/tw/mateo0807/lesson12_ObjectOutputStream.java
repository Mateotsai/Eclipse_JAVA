package tw.mateo0807;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import Student.Student;

public class lesson12_ObjectOutputStream {

	public static void main(String[] args) {
		
		Student s1 = new Student("Brad",40,72,53);
		System.out.println(s1);
		System.out.println("總成績:" + s1.sum());
		System.out.println("平均成績: " + s1.avg());
		
		try {
			
			FileOutputStream fout = new FileOutputStream("dir1/student.score");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			
			oout.writeObject(s1);
			
			oout.flush();
			oout.close();
			System.out.println("成功輸出Brad成績");
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
