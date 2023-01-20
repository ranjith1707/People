package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/QuickLinks")
public class QuickLinks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public QuickLinks() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream stream=getServletContext().getResourceAsStream("/responseFiles/Links.txt");
		BufferedReader buffer=new BufferedReader(new InputStreamReader(stream));
		String listOfLinks="";
		String readed=buffer.readLine();
		while(readed!=null) {
			listOfLinks+=readed;
			readed=buffer.readLine();
			
		}
		
		response.getWriter().append(listOfLinks);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
