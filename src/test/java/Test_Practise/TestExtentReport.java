package Test_Practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestExtentReport {

	

	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		
	
	 
		// TODO Auto-generated method stub
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		
		 
		ExtentSparkReporter Reports = new ExtentSparkReporter(path);
		
		Reports.config().setReportName("automate test");
		Reports.config().setDocumentTitle("test reports");
		
		
		
	    extent= new ExtentReports();
        extent.attachReporter(Reports);
        extent.setSystemInfo("Tester", "Ramesh K");
		
		
		
	}
	

	@Test
	public void initialDemo() {
		
		ExtentTest test = extent.createTest("first test"); // when we createTest extent, report will create object which is unique to test method
		
		//  this object will be responsible to listen and report all happening back to reports
		 
	WebDriver driver;
		
		System.setProperty(
	            "webdriver.chrome.driver",
	            "E:\\work\\chromedriver.exe");
		
	//	WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();                         
		
		driver.manage().window().maximize();
		 driver.get("https://www.google.com/");
		
		test.fail("this is failed"); // Fail test in report 
		
		extent.flush();
		
	}
 
	
	
}
