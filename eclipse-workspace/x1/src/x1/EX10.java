package x1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;		

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class EX10 {
	public static void main(String[] args) {
		String baseUrl = "http://demo.guru99.com/test/tooltip.html";					
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");					
        WebDriver driver = new ChromeDriver();					
        driver.get(baseUrl);					
        String expectedTooltip = "What's new in 3.2";	
        String xp="//*[@id=\"download_now\"]";
        WebElement download= driver.findElement(By.xpath("//*[@id=\"download_now\"]"));
        Actions builder= new Actions(driver);
        builder.clickAndHold().moveToElement(download);
        builder.moveToElement(download).build().perform();
        WebElement TooltipElement= driver.findElement(By.xpath("//*[@id=\"demo_content\"]/div/div/div/a"));
        String actualTooltip=TooltipElement.getText();
        if(actualTooltip.equals(expectedTooltip)) {
        	System.out.print("Actual Tittle : "+actualTooltip);
        	System.out.print("\n Test Passed");
        } else {
        	System.out.print("unpassed");
        }
        driver.close();
	}
	
	
}
