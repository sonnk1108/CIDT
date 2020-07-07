package x1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class PG5 {
	public static void main (String [] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");	
    	WebDriver driver = new ChromeDriver();
    	driver.get("http://demo.guru99.com/test/newtours/register.php");
    	Select chose = new Select( driver.findElement(By.name("country")));
    	chose.selectByVisibleText("ANTARCTICA");
    	driver.close();
    	driver.get("http://jsbin.com/osebed/2");
		Select fruits = new Select(driver.findElement(By.id("fruits")));
		fruits.selectByVisibleText("Banana");
		fruits.selectByIndex(1);
		driver.close();
	}

}
