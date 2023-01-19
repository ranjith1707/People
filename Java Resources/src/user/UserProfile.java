//$Id$
package user;
import java.io.*;
public class UserProfile {
	
	public static void main(String[] args) {
		new UserProfile().getUserProfile();
	}
	
    public String getUserProfile() {
    	
    	String path="/Users/ranjith-16481/eclipse-workspace/People/WebContent/responseFiles/favorites.txt";
    	String data="";
    	try {
    		File file=new File(path);	
    		FileReader fileReader=new FileReader(file);
    		BufferedReader buffer=new BufferedReader(fileReader);
    		String readedData=buffer.readLine();
    		while(readedData!=null) {
    			data+=readedData;
    			readedData=buffer.readLine();
    		}
    	}
    	catch(Exception e)
    	{
    	e.printStackTrace();	
    	}
    	System.out.println(data);
    	return data;
    }
}
