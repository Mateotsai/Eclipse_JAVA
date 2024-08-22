package tw.mateo.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.apis.MemberDB;

@WebServlet("/Register")
public class Register extends HttpServlet { 
	private MemberDB memberDB = null;; //連結資料表的建構式  =null等同於初始化
	
	public Register() {
		try {
			memberDB = new MemberDB();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (memberDB == null) return;
		
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("acccount");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		
		if(!memberDB.isAccountExsisting(account)) {
			try {
				if(memberDB.addMember(account, passwd, name)) {
					response.sendRedirect("brad17.jsp");
				}else {
					response.sendRedirect("brad16.jsp?errType=3");
				}
			} catch (Exception e) {
				response.sendRedirect("brad16.jsp?errType=2");
			}
		}else {
			response.sendRedirect("brad16.jsp?errType=1");
			//如果帳號有重複，轉回去Brad16頁面，並帶入參數顯示給使用者
		}
		
	}

}
