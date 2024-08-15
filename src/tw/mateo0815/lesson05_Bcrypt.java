package tw.mateo0815;

import org.mindrot.BCrypt;

public class lesson05_Bcrypt {

	public static void main(String[] args) {
		String passwd = "123456";
		String newpasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(newpasswd);
		
		System.out.println("雜湊值那麼長: " + newpasswd.length());
	
		 if (BCrypt.checkpw("123456", newpasswd)) {
			 System.out.println("Password is correct!");
		 }else {
			 System.out.println("Please enter again");
		 }
	
	}

}
