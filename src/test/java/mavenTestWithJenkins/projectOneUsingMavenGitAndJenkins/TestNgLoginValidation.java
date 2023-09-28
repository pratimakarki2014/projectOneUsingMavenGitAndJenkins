package mavenTestWithJenkins.projectOneUsingMavenGitAndJenkins;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class TestNgLoginValidation {
	
  WebDriver driver;
	
  @Test
  public void VerifyIfUserIsAbleToLoginWithValidUsernameButBlankPassword() {
		 String userName = "Admin123";
		 String userPassword = "";
		 
		 driver.findElement(By.id("loginLink")).click();
		 Reporter.log("\r\nHome login button clicked and login page get open");
		 
		 driver.findElement(By.id("UserName")).sendKeys(userName);
		 Reporter.log("user name input");
		 
		 driver.findElement(By.id("Password")).sendKeys(userPassword);
		 Reporter.log("password input");
		 
		 driver.findElement(By.xpath("//*[@id=\'loginForm\']/form/div[4]/div/input")).click();
		 Reporter.log("click button clicked");
		 
		 WebElement ErrorMsg = driver.findElement(By.xpath("//*[@id=\'loginForm\']/form/div[2]/div/span/span"));
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
	  Reporter.log("Browser Init and navigate to http://eaapp.somee.com/Account/Login");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
