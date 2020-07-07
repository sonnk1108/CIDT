import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;

import org.apache.commons.mail.EmailException;

public class Main  {
	public static void main(String [] args) throws EmailException, InterruptedException, MalformedURLException, MessagingException {
		//Dia Chi Email 
		String User="tranlientrang1998@gmail.com";
		//app password bao mat 2 lop
		String pass="sixtwoxlrauxjuon";
		//Dia chi mail Nhan
		String Receive="tranlientrang1998@gmail.com";
		//Tạo Đối Tượng Sent Mail
		SendMail Sent= new SendMail();
		String [] Cc= {"tranlientrang1998@gmail.com","sonnk.B17AT157@stu.ptit.edu.vn"};
		String [] Bcc={"tranlientrang1998@gmail.com","sonnk.B17AT157@stu.ptit.edu.vn","quang.itptit@gmail.com"};
		String [] filepath= {"D:\\warning.txt"};
		
		String Button ="Send";
		switch(Button){
		case "Send":
			//Gửi luôn
			Sent.SendMail(User, pass, Receive, filepath,Cc,Bcc);		
			break;
		case "Schedule":
			//Lên lịch
			int time=5;
			ScheduleDate schedule = new ScheduleDate();
		    Timer timer = new Timer();
		  schedule.Schedule(User, pass, Receive, filepath, Cc, Bcc);
		  timer.schedule(schedule, time);
			
			break;
			
		}
	}
}
