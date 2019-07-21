
// Below Code will show how to create the Folder and SubFolder.abstract
package FileHandlingAndScreenshots;

import java.io.File;

public class CreatingFolder {

	public static void main(String[] args) {
		
		String FolderName = "temp";
		File FileObj = new File("C:\\Users\\ankit\\Desktop\\"+FolderName);
		
		if(FileObj.exists()) {
			System.out.println("Folder already exist :- "+ FolderName );
		}else if(FileObj.mkdirs()) {			
			System.out.println("Directeory has created sucessfully :- "+ FolderName);
		}else {
			System.out.println("unable to creaet the directory :- "+ FolderName);
		}
		
	}

}
