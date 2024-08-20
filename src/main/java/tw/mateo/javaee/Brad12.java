package tw.mateo.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad12")
public class Brad12 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
//		String x = request.getParameter("x");
		
		
		int intX =(Integer)request.getAttribute("x");
		String aname =(String)request.getAttribute("name");
		
		
		response.getWriter().printf("Welcome,%s, %d, %s",name,intX,aname);
		

	}

}
