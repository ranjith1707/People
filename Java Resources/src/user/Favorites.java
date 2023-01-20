//$Id$
package user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Favorites {
	
	public static void main(String[] args) {
		new Favorites().getFavoritesList();
	}
  public String getFavoritesList() {
	  String workingDir = System.getProperty("user.dir");
	  
	  String fList="";
	  String path=workingDir+"/WebContent/responseFiles/favorites.txt";
	  try {
		 
		  File file=new File(path);
		  FileReader fileReader=new FileReader(file);
		  BufferedReader buffer=new BufferedReader(fileReader);
		  String data=buffer.readLine();
		  while(data!=null) {
			  fList+=data;
			  data=buffer.readLine();
		  
		}
		 
		
		  
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  System.out.println (fList);
	  return fList;
  }
}
