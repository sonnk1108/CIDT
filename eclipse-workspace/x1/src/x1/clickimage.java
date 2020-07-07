package x1;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;	
import org.openqa.selenium.*;
public class clickimage {
	public static void main(String []args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");	
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://facebook.com");
    	String d1=driver.getTitle();
    	WebElement click1= driver.findElement(By.cssSelector("a[title=\"Vào Trang chủ Facebook\"]"));
    	click1.click();
    	
    	if(driver.getTitle().equals(d1)) {
    	
    		System.out.print("Da quay ve trang chu");
	} else {
		System.out.print("Chua quay ve trang chu");
	}
    	
    driver.close();	
}
}