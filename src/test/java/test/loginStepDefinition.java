package test;


//import java.io.IOException;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;

import common.ReadExl;
import common.common2;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.homepage;

public class loginStepDefinition {
	private WebDriver driver;
	public common2 obj1;
	public homepage obj2;
	
	public  Logger logger= Logger.getLogger(loginStepDefinition.class);
	
	//@Parameters({ "BrowserType"})
	//@Given("^I have open the browser$")
	
	@Before
	public void setup() {
		obj1=new common2();
		driver=obj1.OpenBrowser("Chrome");
	}
	
	@Given ("^User is on Home Page$")
	public void setUp()
	{

	obj1.Openurl();
	logger.info("first comment");
	
	}
	
	@When ("^User Navigate to Log yourself in link And User enters UserName and Password$")
	public void mainTest()
	{
		   ReadExl object=new ReadExl();
			String name=object.sendUsername();
			String Pwd=object.sendPwd();
		
		 obj2=new homepage(driver);
		obj2.Login(name, Pwd);
		
		logger.info("second comment");
		
	}
	
	@Then("^Welcome to iBusiness page display$")
	public void welcome_to_iBusiness_page_display() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  String ExpectedText="Welcome to iBusiness";
	  String ActualText=driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/h1")).getText();
	  Assert.assertEquals(ExpectedText, ActualText);
	}

	@Then("^click on logoff and click on closebutton$")
	public void click_on_logoff_and_click_on_closebutton() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		obj2.logOff();
	}
	

	@After
	public void tearDown() {
		driver.quit();
	}
	/*
	public void teardown()
	{
		
		//obj1.closeBrowser();
	// Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		 // now copy the  screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File("C:\\Users\\anmol\\eclipse-workspace\\MavenProject1\\screenshot\\error.png"));
		}
		 
		catch (IOException e)
		 {
		  System.out.println(e.getMessage());
		 
		 }
}*/
	}
