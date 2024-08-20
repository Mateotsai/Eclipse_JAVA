package tw.mateo.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad07")
public class Brad07 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		
		String x ,y, result; //第一次執行的時候XY都沒有執，讓印出來的至少是空白字串而不是null或0
		x = y = result = "";
		
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("x") != null) {
			x = request.getParameter("x");
			y = request.getParameter("y");
			try {
				int r = Integer.parseInt(x) + Integer.parseInt(y);
				result += r;
			}catch(Exception e) {
				System.out.println(e); //輸入空值的話無視例外(不做任何動作
			}
		}
		
		
		response.setContentType("text/html;chatset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<meta charset='UTF-8'>");
		out.println("<form action='Brad07'>");
		out.printf("<input name='x' value = '%s' />\n", x);
		out.println("<span>+</span>");
		out.printf("<input name ='y' value = '%s'/>\n", y);
		out.println("<input type='submit' value='=' />");
		out.printf("<span> %s </span>\n",result);
		out.println("</form>");
		

		response.flushBuffer();
	}

	

}
