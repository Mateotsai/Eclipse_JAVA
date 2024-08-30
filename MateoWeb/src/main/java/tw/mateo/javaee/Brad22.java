package tw.mateo.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Brad22")
@MultipartConfig
public class Brad22 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 1. 僅處理Part
		Part part = request.getPart("icon");
		byte[] buf = part.getInputStream().readAllBytes();
		request.setAttribute("icon", buf);
		// 2. 其他交給jsp處理 
		request.getRequestDispatcher("insertMember.jsp").forward(request,response);
	}

}
