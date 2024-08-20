package tw.mateo.javaee;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Brad02
 */
@WebServlet("/Brad02")  //URL由這邊決定
public class Brad02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> headers = request.getHeaderNames();
		//抓用戶端資訊
		while(headers.hasMoreElements()) {
			String name = headers.nextElement();
			String value = request.getHeader(name);
			System.out.printf("%s : %s \n", name, value);
			
		}
	}

	

}
