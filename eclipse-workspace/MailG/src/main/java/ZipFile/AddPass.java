package ZipFile;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.Zip4jUtil;
public class AddPass {

	public static void  main(String[] args ) throws IOException, ParseException {
		ZipParameters zipParameters = new ZipParameters();
		zipParameters.setEncryptFiles(true);
		zipParameters.setEncryptionMethod(EncryptionMethod.AES);
		// Below line is optional. AES 256 is used by default. You can override it to use AES 128. AES 192 is supported only for extracting.
		zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256); 
        File dir = new File("C:\\Users\\Admin\\eclipse-workspace\\MailG\\Zip");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
        Date now = new Date();
        String k = sdf2.format(now);
        Date date1=sdf2.parse(k);
        System.out.println(""+sdf2.format(now));
		ZipFile zipFile = new ZipFile("filenameTest.zip", "password".toCharArray());
		 File[] files = dir.listFiles();
		 
	        for(File file : files){
	            if(file.isFile()) 		{
	                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	                java.text.DateFormat df = new java.text.SimpleDateFormat("MM/dd/yyyy");

	            			File Check = new File(file.getAbsolutePath());
	            			Date date2= df.parse(sdf.format(Check.lastModified()));
	            			if((Check.length()/1024>300) || (date1.getYear()-date2.getYear() >2) ) {
	            	zipFile.addFile(file.getAbsolutePath(), zipParameters);
	            			}
	            	}
	        }
		}
}
