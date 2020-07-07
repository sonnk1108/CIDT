package thongsothietbi;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;
import java.util.TimerTask;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class thongsothietbi2 extends TimerTask {
 static int count;
@Override
public void run() {
	// TODO Auto-generated method stub
	 OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
		long totalRam= osBean.getTotalPhysicalMemorySize();
		long FreeRam=osBean.getFreePhysicalMemorySize();
		long loadRam=100-FreeRam*100/totalRam;
	      			 
			 if((osBean.getSystemCpuLoad() >0.3) || (loadRam > 0.8)) {
				 	count++;
				 		
			 } else {
					 count=0;
					 }
			 if(count >10) {
		 			count=0;
					FileWriter myWriter;
					try {
						myWriter = new FileWriter("D://warning.txt",true);
						 myWriter.append("Warning........... "+LocalDateTime.now()+"\n");
						 
			 		      myWriter.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

		 			
		 		}
}
}
