package BasePackage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	

	
	
	
	public  WebDriver initialize() throws IOException {
		
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("E:\\zzz_maven\\src\\main\\java\\Global.properties");
		
		
		prop.load(fis);
		
		String browserName=System.getProperty("browser")!= null ? System.getProperty("browser") :prop.getProperty("browser");
		
		
		//String browser=prop.getProperty("browser");
		
		 
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			 
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			
			WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			 
			
		
			
		}
		return driver;
	// 	Landing_page lp = new Landing_page(driver);
	// 	return lp;
		
	 
		
	 
		
	}
	
	  

}

	
	
	
 