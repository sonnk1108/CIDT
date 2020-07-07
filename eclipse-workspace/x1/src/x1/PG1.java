package x1;
import org.openqa.selenium.WebDriver;
//Dòng trên nếu bạn sử dụng Firefox hoặc thay bằng dòng cmt bên dưới nếu bạn sử dụng Chrome 
import org.openqa.selenium.chrome.ChromeDriver;
public class PG1 {

    public static void main(String[] args) {
    	//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//Dòng trên nếu bạn sử dụng Firefox hoặc thay bằng dòng cmt bên dưới nếu bạn sử dụng Chrome
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

//Chạy fire fox và chuyển hướng đến đường dẫn trang chủ 
        driver.get(baseUrl);

        // Lấy giá trị thật của tiêu đề 
        actualTitle = driver.getTitle();
        /*
         
         * So sánh kết quả thực tế và kết quả mong đợi rồi in ra kết quả 
         * Kết quả trả về  "Passed" hoặc "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        //close Fire fox
        driver.close();
       
    }

}