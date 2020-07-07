package x1;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;		
import org.openqa.selenium.*;
public class PG4 {
	public static void main(String [] args) {
    	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");	
    	WebDriver driver = new ChromeDriver();
    	driver.get("http://demo.guru99.com/test/radio.html");
    	WebElement option1 =driver.findElement(By.id("vfb-7-1"));
    	option1.click();
    	WebElement option2 =driver.findElement(By.id("vfb-7-2"));
    	option2.click();
    	if(option1.isSelected()) {
    		System.out.print("Caiconcak");
    	}
    	else {
    		System.out.print("caiconcakkkk");
    	}
    	WebElement cb1 =driver.findElement(By.id("vfb-6-0"));

    	WebElement cb2 =driver.findElement(By.id("vfb-6-1"));

    	WebElement cb3 =driver.findElement(By.id("vfb-6-2"));
    	cb1.click();
    	cb2.click();
    	cb3.click();
	}

}
