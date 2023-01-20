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
import user.NewJoiningDetails;

@WebServlet("/NewHiers")
public class NewHiers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NewHiers() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newHierList="";
		
		InputStream st= getServletContext().getResourceAsStream("/responseFiles/newHires.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(st));
		String line;
		while((line = in.readLine()) != null)
		{
			newHierList+=line;
			System.out.println(line);
		}
		
		response.getWriter().append(newHierList);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
