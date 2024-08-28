package tw.mateo.tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport{
	private String name;

	public void setName(String name) {
		this.name = name;
	}

  @Override
    public void doTag() throws JspException, IOException {
        String message = (name != null && !name.isEmpty()) ? 
            String.format("Hello, %s!", name) : "Hello, Guest!";
        getJspContext().getOut().print(message);
        

        	
        JspFragment body = getJspBody();
        if( body != null) {
       
        	 getJspContext().getOut().print("I am Brad");
        }
        
    }

	
}
