package Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Base64.Encoder;

public class ImageToBase64 {
	 public static void main(String[] args) throws Exception{
		 
         File f =  new File("D:\\test.jpeg");
           String encodstring = encodeFileToBase64Binary(f);
			FileWriter myWriter;
			myWriter = new FileWriter("D://warning.txt");
			 myWriter.append(encodstring);
     }

     private static String encodeFileToBase64Binary(File file) throws Exception{
          FileInputStream fileInputStreamReader = new FileInputStream(file);
          byte[] bytes = new byte[(int)file.length()];
          fileInputStreamReader.read(bytes);
          Encoder z=Base64.getEncoder();
          return new String(z.encode(bytes), "UTF-8");

          
      }
}
