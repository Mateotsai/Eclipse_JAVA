package tw.mateo.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Brad01
 */
@WebServlet("/Brad01")
public class Brad01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("從用戶端呼叫一次");
		PrintWriter pw = response.getWriter();
		pw.print("Hello World!");
	}


}
