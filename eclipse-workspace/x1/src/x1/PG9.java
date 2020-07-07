package x1;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PG9 {
	 public static void main(String [] args) throws ParseException {
		 
		 WebDriver wd;
		 System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
		 wd= new ChromeDriver();
	     wd.get("http://demo.guru99.com/test/web-table-element.php");
	     
	     String max,name = null;
	     double m=0,r=0;
	     List rows=wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
	     for(int i=1;i<rows.size();i++) {
	    	 max= wd.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+(i+1)+"]/td[4]")).getText();
	    	 NumberFormat f =NumberFormat.getNumberInstance(); 
	            Number num = f.parse(max);
	            max = num.toString();
	            m = Double.parseDouble(max);
	            if(m>r)
	             {    
	                r=m;
	                name=wd.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+(i+1)+"]/td[1]")).getText();
	             }
	    	 
	    	 } 
	     System.out.print("Max price "+name+" is "+r);
	     
	 }
}
