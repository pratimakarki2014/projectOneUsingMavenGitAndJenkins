package mavenTestWithJenkins.projectOneUsingMavenGitAndJenkins;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class testNgRegisterValidation {
	
  WebDriver driver;
	
  @Test
  public void verifyIfUserCanRegisterWithoutValidInformation() {
     driver.findElement(By.id("registerLink")).click();
	 driver.findElement(By.xpath("/html/body/div[2]/form/div[6]/div/input")).click(); 
  }
  
  @Parameters({"url", "browser"})
  @BeforeTest
  public void beforeTest(String url, String browser) {
	  if(browser.equals("firefox")) {
		  driver = new FirefoxDriver(); 
		  
	  }else if(browser.equals("chrome")) {
		  driver = new ChromeDriver();
	  
	  }else{
		  driver = new EdgeDriver();
	  }
	  driver.get(url);
	  driver.manage().window().maximize();
	  Reporter.log("http://eaapp.somee.com/Account/Register"); 
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
