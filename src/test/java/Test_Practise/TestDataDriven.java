package Test_Practise;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataPackage.DataReader;

public class TestDataDriven {
	
	WebDriver driver;
	
	@Test(dataProvider="getData")
	
	
	public void mainTest(HashMap <String, String> input) throws IOException {
		
		System.setProperty(
	            "webdriver.chrome.driver",
	            "E:\\work\\chromedriver.exe");
		  driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.cssSelector("#user-name")).sendKeys(input.get("userName"));
		driver.findElement(By.cssSelector("#password")).sendKeys(input.get("Password"));
		driver.findElement(By.cssSelector("#login-button")).click();
		
		System.out.println("changes done by x person");
		 
	
		
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {


		
	//	 HashMap<String, String> sh = new HashMap<String, String>();
	//	 sh.put("username", "standsdsdsaadard_user");
	//	 sh.put("password", "secret_sauce");
	//	 
	//	 HashMap<String, String> sh1 = new HashMap<String, String>();
	//	 sh1.put("username", "problasdsadem_user");
	//	 sh1.put("password", "secret_sauce");
		 
		 DataReader json = new DataReader();
		 
		 List<HashMap<String, String>>	sdata = json.getJsonDataToMap(System.getProperty("user.dir")+ "\\src\\test\\java\\DataPackage\\purchase.json");
		
			 
  
		 
		 return new Object[] []  {{sdata.get(0)},{sdata.get(1)}};
		 
		 

		
		
	}
	
 
	
	 
}
