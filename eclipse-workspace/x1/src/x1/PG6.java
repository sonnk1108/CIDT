package x1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PG6 {
public static void main(String [] args) {
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");	
	WebDriver driver = new ChromeDriver();
	driver.get("http://demo.guru99.com/test/link.html");
	driver.findElement(By.linkText("click here")).click();
	System.out.print("Title: "+driver.getTitle());
	driver.close();
}

}
