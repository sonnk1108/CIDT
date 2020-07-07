package x1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PG2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        String baseUrl = "http://www.facebook.com";
        String tagName = "";
        
        driver.get(baseUrl);
        WebElement my= driver.findElement(By.id("email"));
        my.sendKeys("tranlientrang1998@gmai,com");
        WebElement my2= driver.findElement(By.id("pass"));
        my2.sendKeys("Hson2412@1234567890123456789");
        driver.findElement(By.id("loginbutton")).click();
        System.out.println(tagName);
}
}