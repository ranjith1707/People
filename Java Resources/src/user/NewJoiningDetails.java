//$Id$
package user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class NewJoiningDetails {
  public static void main(String[] args) {
	  new NewJoiningDetails().getNewJoiningList();
  }
	
	public String getNewJoiningList() {
		 String workingDir = System.getProperty("user.dir");
		String newHierList="";
		String path=workingDir+"/WebContent/responseFiles/newHires.txt";
		try {
			File file=new File(path);
			FileReader fileReader=new FileReader(file);
			BufferedReader buffer=new BufferedReader(fileReader);
			String readedData=buffer.readLine();
			while(readedData!=null) {
				newHierList+=readedData;
				readedData=buffer.readLine();
			}
		}catch(Exception e) {
			
		}
		System.out.println(newHierList);
		return newHierList;
		
	}
}
