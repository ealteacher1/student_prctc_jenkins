package Utilities_;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseClass {
  WebDriver driver;
  @Parameters({"browser", "websiteurl"})
  @BeforeMethod
  public void beforeClass(String browsername, String URL) throws InterruptedException  {
	 
	  Ibrowser(browsername,URL );
  }

  @AfterMethod
  public void aftermethod () {
	  driver.close();
	  
  } 
  
  
	 public  void Ibrowser(String BrowserName, String URL) throws InterruptedException  {
		 
			if (BrowserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				
				 driver= new ChromeDriver();
				 driver.get(URL);
				 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				 driver.manage().window().maximize();
				 Thread.sleep(3000);
				
			}
				
			else if (BrowserName.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();

				 driver= new EdgeDriver();
				 driver.get(URL);
			
				 driver.manage().window().maximize();
				 
				 Thread.sleep(3000);
			}
  	 }
  
  
  

}
