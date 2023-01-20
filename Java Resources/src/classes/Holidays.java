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


@WebServlet("/Holidays")
public class Holidays extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Holidays() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InputStream stream=getServletContext().getResourceAsStream("/responseFiles/UpcomminHolidays.txt");
		BufferedReader buffer=new BufferedReader(new InputStreamReader(stream));
		String holidays="";
		String readedData=buffer.readLine();
		while(readedData!=null) {
			holidays+=readedData;
			readedData=buffer.readLine();
		}
		
		response.getWriter().append(holidays);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
