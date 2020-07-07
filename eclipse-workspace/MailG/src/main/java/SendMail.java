
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.mail.MultiPartEmail;
import java.nio.charset.StandardCharsets;
import		java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;



public class SendMail {
	public int CountSentMail=0;
	public void resetDay() {
		CountSentMail=0;
	}
	//Funtion thêm  file đính kèm vào email 
	public void add( HtmlEmail   email, String filename) throws MessagingException, EmailException {
		
		DataSource source = new FileDataSource(filename);
	    BodyPart messageBodyPart = new MimeBodyPart();    
        MimeMultipart multipart = new MimeMultipart();
	    messageBodyPart.setDataHandler(new DataHandler(source));
	    messageBodyPart.setFileName(filename);
	    multipart.addBodyPart(messageBodyPart);
	    email.addPart(multipart);
		
		
	}
	
	public  void  SendMail(String User, String Pass, String Receive,String []filePath,String [] Cc, String [] Bcc) throws EmailException, InterruptedException, MalformedURLException, MessagingException {
		
			HtmlEmail   email = new HtmlEmail();
	        email.setHostName(MailConfig.HOST_NAME);
	        email.setSmtpPort(MailConfig.SSL_PORT);
	        email.setAuthenticator(new DefaultAuthenticator(User,Pass));
	        email.setSSLOnConnect(true);
	        //Chọn đường dẫn file 
	       
	        //Chèn thẻ URl 
	        String link="https://img.thuthuatphanmem.vn/uploads/2018/10/08/anh-anime-phong-canh-dep_093817122.jpg";
	        String url="https://img.thuthuatphanmem.vn/uploads/2018/10/08/anh-anime-phong-canh-dep_093817122.jpg"	;
			//Chèn đoạn mã HTML
	        String HTML=" " + 
	        		"" + 
					" <h1> Email này chỉ mang hình thức nghiên cứu </h1>"
	        		+ "<img src="+url+" />" 
	        		+ " </br> <h2> 什麼	shén me (sấn mơ): cái gì, hả.\r\n" + 
	        		"3	知道	zhī dào (trư tao): biết, hiểu, rõ.\r\n" + 
	        		"4	他們	tāmen (tha mân): bọn họ.\r\n" + 
	        		"5	一個	yīgè (ý cừa): một cái, một.\r\n" + 
	        		"6	你們Đây Là đường dẫn <h2><a href="+link+">Click Vao Day </a> ";
			
	        //Gửi từ tài khoản nào
	        email.setFrom(User);
	        //Thêm người nhận
	        email.addTo(Receive);
	        //Thêm tiêu đề 
	        email.setSubject("Test HTML ");
	        // Tạo 1 multipart để thêm đoạn HTML vào 
	        MimeMultipart multipart = new MimeMultipart();
	        BodyPart textBody = new MimeBodyPart();
	        
	        //Set UTF-8 để Encoding tiếng việt
	        textBody.setContent(HTML,"text/html;charset=UTF-8;");
	        multipart.addBodyPart(textBody);
	        //Thêm  multipart vào eamil
	        email.addPart(multipart);
	        //Đính kèm nhiều File
	        for(int i=0; i < filePath.length;i++) {
	        	add(email,filePath[i]);
	        }
	        // Gửi mail cc
	        email.addCc(Cc);
	        //Gửi mail Bcc
	        email.addBcc(Bcc);
	        //Delay 30s để chống spam
	        TimeUnit.SECONDS.sleep(30);
	        System.out.println("Message sent successfully");
	        email.send();
	        
		
	}

}
