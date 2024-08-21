package tw.mateo.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/table9x9")
public class table9x9 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int rows = Integer.parseInt(request.getParameter("rows"));
		int cols = Integer.parseInt(request.getParameter("cols"));
		int start = Integer.parseInt(request.getParameter("start"));
		
		request.setAttribute("rows", rows);
		request.setAttribute("cols", cols);
		request.setAttribute("start", start);
		
		request.getRequestDispatcher("table99.jsp").forward(request, response);
	}

}
