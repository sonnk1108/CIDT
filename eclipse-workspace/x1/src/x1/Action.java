package x1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;		

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Action {
	public static void main(String [] args) {

        String baseUrl = "https://gamek.vn/";					
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");					
        WebDriver driver = new ChromeDriver();					
        driver.get(baseUrl);					
        String expectedTooltip = "MOBILE & SOCIAL";	
        
        // Find the Github icon at the top right of the header		
        WebElement github = driver.findElement(By.xpath("//*[@id=\"admWrapsite\"]/div[3]/div[1]/div/ul/li[6]/a"));	
        
        //get the value of the "title" attribute of the github icon		
        String actualTooltip = github.getAttribute("title");	
        
        //Assert the tooltip's value is as expected 		
        System.out.println("Actual Title of Tool Tip: "+actualTooltip);							
        if(actualTooltip.equals(expectedTooltip)) {							
            System.out.println("Test Case Passed");					
        }		
        driver.close();			
	}
}
