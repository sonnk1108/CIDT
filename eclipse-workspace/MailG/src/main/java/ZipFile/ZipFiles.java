package ZipFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
public class ZipFiles {
	    
	    List<String> filesListInDir = new ArrayList<String>();

	    public static void main(String[] args) {
	        
	        
	        File dir = new File("C:\\Users\\Admin\\eclipse-workspace\\MailG\\Zip");
	        //Đường dẫn thư mục
	        String zipDirName = "C:\\Users\\Admin\\eclipse-workspace\\MailG\\End22.zip";
	        //Đường dẫn đến thư mục lưu file zip
	        ZipFiles zipFiles = new ZipFiles();
	        //Khởi tạo object zipfile mới
	        zipFiles.zipDirectory(dir, zipDirName);
	    }

		private void zipDirectory(File dir, String zipDirName) {
			 try {
		            populateFilesList(dir);
		            
		            //Tạo luồng Zip output để ghi file Zip
		            FileOutputStream fos = new FileOutputStream(zipDirName);
		            ZipOutputStream zos = new ZipOutputStream(fos);
		            for(String filePath : filesListInDir){
		                System.out.println("Zipping "+filePath);
		                
		                //Đối với Zipentry chỉ cần giữ đường dẫn tương đối 
		                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
		                zos.putNextEntry(ze);
		                //Đọc file và ghi vào zip out put
		                FileInputStream fis = new FileInputStream(filePath);
		                byte[] buffer = new byte[1024];
		                int len;
		                while ((len = fis.read(buffer)) > 0) {
		                    zos.write(buffer, 0, len);
		                }
		                zos.closeEntry();
		                fis.close();
		            }
		            zos.close();
		            fos.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			
		}

		private void populateFilesList(File dir) {
			 File[] files = dir.listFiles();
			 
		        for(File file : files){
		            if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
		            else populateFilesList(file);
		        }
			
		}

	

}
