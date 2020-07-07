import java.net.MalformedURLException;
import java.util.TimerTask;

import javax.mail.MessagingException;

import org.apache.commons.mail.EmailException;

public class ScheduleDate extends TimerTask {
	
	public void Schedule(String User, String Pass, String Receive,String []filePath,String [] Cc, String [] Bcc) throws MalformedURLException, EmailException, InterruptedException, MessagingException {
		SendMail send = new SendMail();
		send.SendMail(User, Pass, Receive, filePath, Cc, Bcc);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	

}
