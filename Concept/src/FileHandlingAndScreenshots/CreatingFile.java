
// Below code will explain how to create the any file.
package FileHandlingAndScreenshots;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author will create the file
 *
 */
public class CreatingFile {

	public static void main(String[] args) throws IOException {
		
		// Create the File Object and pass the path where you want to store that file 
		String FileName = "temp1.txt";
		File fileobj = new File("C:\\Users\\ankit\\Desktop\\temp\\"+FileName);
		
		// Will check for the file if file is alredy exeis then will not creae the new file i not Create the new File 
		
		if(fileobj.exists()) {
			System.out.println(" already file exist  :- "+ FileName);
		}else if(fileobj.createNewFile()) {
			System.out.println("Sucessfully file is created :- "+ FileName);
		}else {
			System.out.println("unable to create the file :- "+ FileName);
		}
		

		// size of the file
		System.out.println(fileobj.length());
		System.out.println(fileobj.getName());
		System.out.println(fileobj.delete());
	}

}
