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


@WebServlet("/OrganizationFiles")
public class OrganizationFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrganizationFiles() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream stream=getServletContext().getResourceAsStream("/responseFiles/Organization.txt");
		BufferedReader buffer=new BufferedReader(new InputStreamReader(stream));
		String oganizationFile="";
		String readed=buffer.readLine();
		while(readed!=null) {
			oganizationFile+=readed;
			readed=buffer.readLine();
		}
		response.getWriter().append(oganizationFile);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
