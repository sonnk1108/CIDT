package Base64;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

public class Base64ToImage {
	public static void main(String[]args) throws IOException {
		FileOutputStream imageOutFile= new FileOutputStream("D:\\checkerVn.JPEG");
		String Encode="";
		BufferedReader reader = new BufferedReader(new FileReader("D:\\warning.txt"));
		String line = reader.readLine();
		while (line != null) {
            Encode=Encode +line;
			line = reader.readLine();
		}
		reader.close();
	      byte[] imageByteArray = Base64.getDecoder().decode(Encode);   
	      imageOutFile.write(imageByteArray);


	}

}
