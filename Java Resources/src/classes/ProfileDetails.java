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
import user.UserProfile;
@WebServlet("/ProfileDetails")
public class ProfileDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProfileDetails() {
        super();
      
    }

	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String profileDetails="";
		
		InputStream st= getServletContext().getResourceAsStream("/responseFiles/userDetails.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(st));
		String line;
		while((line = in.readLine()) != null)
		{
			profileDetails+=line;
			
		}
		response.getWriter().append(profileDetails);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
