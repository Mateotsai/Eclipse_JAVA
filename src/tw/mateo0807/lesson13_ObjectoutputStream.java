package tw.mateo0807;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.ClassNotFoundException;

import Student.Student;

public class lesson13_ObjectoutputStream {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/student.score");
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			Object obj = oin.readObject();
			Student s1 = (Student)obj;
			System.out.println(s1);
			System.out.println("總成績:" + s1.sum());
			System.out.println("平均成績: " + s1.avg());
			
			oin.close();
			System.out.println("OK");
			
		} catch (IOException e) {
			System.out.println(e);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		}

	}

}
