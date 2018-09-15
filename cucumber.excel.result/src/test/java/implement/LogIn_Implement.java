package implement;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogIn_Implement {
	WebDriver driver;
	WebElement element;
	static String User_Name="";
	static String Pass_word="";
	static String Status="";
	static Excel_Reporting reporting=new Excel_Reporting();
	static int total_data=0;
	SoftAssert assertion = new SoftAssert();
	
		
	@Given("^open the browser$")
	public void open_the_browser() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./Browser_Drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://in.yahoo.com/?p=us");
		String a= driver.getTitle();
		driver.manage().window().maximize();
		}
		
		
	
	

	@When("^Enter username  \"([^\"]*)\"$")
	public void enter_username(String username) throws Throwable {
		User_Name=username;
		element=driver.findElement(By.id("uh-signin"));
		element.click();
		
		Thread.sleep(3000);
		element=driver.findElement(By.id("login-username"));
		element.sendKeys(username);
		
		element=driver.findElement(By.id("login-signin"));
		element.click();
		}
		
	
    
	@Then("^enter password \"([^\"]*)\"$")
	public void enter_password(String password) throws Throwable {
		try {
		Pass_word=password;
		Thread.sleep(3000);
		element=driver.findElement(By.id("login-passwd"));
		
		element.sendKeys(password);
		Thread.sleep(3000);
		element=driver.findElement(By.id("login-signin"));
		element.click();
		Status="pass";
		}
		catch(Exception e)
		{
			Status="fail";
			driver.close();
		}
		
		
	   
	}

	@Then("^try logging in$")
	public void try_logging_in() throws Throwable {
		
		reporting.logging_data();
		total_data=total_data+1;
		System.out.println("we have done for --"+total_data);
		driver.close();
		
	}

	@After(" @TestExcel")
	public void closure() throws Throwable
	{
		if(total_data==20)
		{
		reporting.column_auto_spacing();
		reporting.closing();
		
	}

	
	}
	
}

	
