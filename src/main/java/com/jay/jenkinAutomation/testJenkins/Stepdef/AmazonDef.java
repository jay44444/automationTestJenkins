package com.jay.jenkinAutomation.testJenkins.Stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonDef {
	
	WebDriver driver;

	@Given("^Open Google Chrome$")
	public void open_Google_Chrome() throws Throwable {
		try {
			String workDir = System.getProperty("user.dir");
			System.out.println(workDir);
			workDir = workDir + "\\src\\main\\java\\com\\jay\\jenkinAutomation\\testJenkins\\SupportingFiles\\chromedriver.exe";
			System.out.println(workDir);
			System.setProperty("webdriver.chrome.driver", workDir);
			driver=new ChromeDriver();
			Logclass logclass=new Logclass();
			logclass.initializeLogger();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://www.amazon.in/");
			Logclass.logger.info("New Run Started.....................................");
			
			Logclass.logger.info("Google Chrome Opened");
			
			Logclass.logger.info("Amazon Homepage opened");
		} catch (Exception e) {
			Logclass.logger.error("Exception while opening Google Chrome   "+e);
			throw new RuntimeException(e);
		}
	}

	@When("^I entered valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_entered_valid_username_and_password(String uname, String pwd) throws Throwable {
	    
		try {
			driver.findElement(By.id("nav-link-yourAccount")).click();
			driver.findElement(By.id("ap_email")).sendKeys(uname);
			driver.findElement(By.id("continue")).click();
			driver.findElement(By.id("ap_password")).sendKeys(pwd);
			
			
			Logclass.logger.info("User Logging in");
		} catch (Exception e) {
			Logclass.logger.error("Exception while Logging in with "+uname+" and "+pwd+"    "+e);
			throw new RuntimeException(e);
		}
	}

	@Then("^User should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {
		
		try {
			driver.findElement(By.id("signInSubmit")).click();
			
			Logclass.logger.info("User Login Successful");
		} catch (Exception e) {
			Logclass.logger.error("Exception while logging into Amazon  page    "+e);
			throw new RuntimeException(e);
		}
	}
	
	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Throwable {
		try {
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 8");
			
			Logclass.logger.info("User searching for a product");
		} catch (Exception e) {
			Logclass.logger.error("Exception while Searching for Product    "+e);
			throw new RuntimeException(e);
		}
		
	}

	@Then("^Results should be displayed$")
	public void results_should_be_displayed() throws Throwable {
		try {
			driver.findElement(By.className("nav-input")).click();
			
			Logclass.logger.info("Search results Displayed");
		} catch (Exception e) {
			Logclass.logger.error("Exception while Searching for Product    "+e);
			throw new RuntimeException(e);
		}
	}

	@When("^I clicked a specific Product$")
	public void i_clicked_a_specific_Product() throws Throwable {
	    //driver.findElement(By.linkText("Apple iPhone 8 (Space Grey, 64GB)")).click();
	}

	@Then("^its price will be printed$")
	public void its_price_will_be_printed() throws Throwable {
		try {
			String price=driver.findElement(By.xpath("(//span[contains(@class, 'a-size-base a-color-price s-price a-text-bold')])[1]")).getText();
			System.out.println("The Price of this Product is "+price);
			Logclass.logger.info("The Price of this Product is "+price);
			
			WebElement dd=driver.findElement(By.id("sort"));
			
			Select sort_dd=new Select(dd);
			
			sort_dd.selectByVisibleText("Price: Low to High");
			
			Logclass.logger.info("The Product Price is printed");
			
			WebElement navLink = driver.findElement(By.id("nav-link-yourAccount"));
			Actions hover = new Actions(driver);
			hover.moveToElement(navLink).build().perform();
			Thread.sleep(1000);
			/*driver.findElement(By.id("nav-item-signout-sa")).click();
			Thread.sleep(1000);*/
			
			Logclass.logger.info("User Signed out of the Account..");
		} catch (Exception e) {
			Logclass.logger.error("Exception while printing the Product Price    "+e);
			throw new RuntimeException(e);
		}finally {
			driver.close();
		}
	}
	
}
