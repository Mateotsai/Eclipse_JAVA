package tw.mateo.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Brad10")
@MultipartConfig(location = "C:\\Users\\User\\eclipse-workspace\\MateoWeb\\src\\main\\webapp\\upload")  //宣告我會處理，並指定儲存路徑
public class Brad10 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Collection<Part> parts = request.getParts();
		
		String account = request.getParameter("account");
		response.setContentType("text/html;chatset=UTF-8");
		
		int count = 0;
		for (Part part : parts) {
			if(part.getName().equals("upload")) {
				if(part.getSize() > 0) {
					String fname = account + "_" + part.getSubmittedFileName();
					
					try {
						part.write(fname);
						count++;
					}catch(Exception e) {
						
					}
				}
			}
			
		}
	response.setContentType("text/html;charset=UTF-8");
	response.getWriter().print("%d File(s) Upload Success".formatted(count));
		
	}

}
