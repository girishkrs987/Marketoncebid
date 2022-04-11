package stepDefinitions;

import org.openqa.selenium.Alert;
//
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

//
public class LoginStepDefinition {
	//
	WebDriver driver;

	//
	//	
	@Given("^user is already on Login Page$")
	public void user_already_on_login_page() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://mo-qa-spa.marketonce.com/");
	}

	//	
	//	
	@When("^title of login page is MarketOnce$")
	public void title_of_login_page_is_Marketonce() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(false, false);
		Assert.assertEquals("Sign In", title);
	}

	//	
	//	 //Reg Exp:
	//	 //1. \"([^\"]*)\"
	//	 //2. \"(.*)\"
	//	
	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.name("Username")).sendKeys(username);
		driver.findElement(By.name("Password")).sendKeys(password);
	}

	//	
	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}

	//	
	//	
	@Then("^user is on home page$")
	public void user_is_on_hopme_page() {
		String title = driver.getTitle();
		System.out.println("Home Page title ::" + title);
		// Assert.assertEquals("Dashboard - MarketOnce Bidding", title);
	}

	@Then("^user clicks on Bids$")
	public void user_clicks_on_Bids() throws InterruptedException {
		String title = driver.getTitle();
		System.out.println("Home Page title1 ::" + title);
		Assert.assertEquals("MarketOnce Bidding", title);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement Bid = driver.findElement(By.cssSelector("div[class='sc-fYxtnH hItRWp']"));
		Bid.click();

		// Click on Project management icon
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement PM_Bid = driver.findElement(By.cssSelector("div[class='sc-jbKcbu cfYrKG']"));
		PM_Bid.click();

	}

	// ***************************

	// }

	@Then("^user validate Projects By searching project ID \"(.*)\"$")
	public void user_filter_Projects_By_project(String projid) {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement ProjectIDFilter = driver.findElement(By.cssSelector("div[class='sc-fKGOjr etFiGS']"));
		ProjectIDFilter.click();

		// Click on Project Filter Text

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// Input Project ID

		WebElement ProjectIDFilterText = new WebDriverWait(driver, 3).until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input[id='currentProjects-1-filterInput']")));

		ProjectIDFilterText.sendKeys(projid);

		// String ProjectID ="2377";

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String BeforeXpath = "div[id='";

		String AfterXpath = "-currentProjects-row']";

////div[contains (text(),3305)]
		
		
		/*
		 * for (int i = 0; i <= 551; i++) {
		 * 
		 * String CurrentProjectID = driver.findElement(By.cssSelector(BeforeXpath + i +
		 * AfterXpath)).getText();
		 * 
		 * // System.out.println("ProjectID"+ " " +projID);
		 * 
		 * if (projid.contains(CurrentProjectID)) {
		 * 
		 * // driver.findElement(By.xpath("//div[contains (text(),3305)]")).click();
		 * System.out.println("Searching Project ID found" + "     " + projid);
		 * 
		 * break;
		 * 
		 * 
		 * }
		 * 
		 * 
		 * else { System.out.println("Searching Project ID NOT found" + "     " +
		 * projid);
		 * 
		 * break; }
		 * 
		 * 
		 * }
		 */
		// Click submit button

		WebElement ProjectIDFilterSubmittnButton = new WebDriverWait(driver, 3).until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("button[id='currentProjects-1-filterInput-submit']")));
		ProjectIDFilterSubmittnButton.click();
		
		
		
		String BXpath ="div[id='";
		
		 String AXpath ="-currentProjects-row']";
		 
		// div[id='0-currentProjects-row']
		 
		// xapth of project ID cloumn   :   //div[@id ='0-currentProjects-row']//div[contains (text(),2384)]
		                                   // div[@id ='0-currentProjects-row']//div[contains (text(),2384)]
		
		 String BXpathprojid ="//div[@id ='0-currentProjects-row']//div[contains (text(),";
			
		 String AXpathprojid =")]";
		 
		//div[@id ='0-currentProjects-row']//div[contains (text(),2384)]
		 
			for(int j=0;  j<=0; j++) {
				
				WebElement CurrentProjectID = new WebDriverWait(driver, 3).until(ExpectedConditions
						.visibilityOfElementLocated(By.cssSelector(BXpath+j+AXpath))); 
				
				String FindingProjectID=CurrentProjectID.getText();
				System.out.println("******************************");
				
				System.out.println("After search project ID and Record informtion" + "\r\n"+ FindingProjectID);
				//break;
				System.out.println("******************************");
				
						 
			
				
				
				
				 
			}
			
				  
				  
	
	  WebElement ProjectColumnID = new WebDriverWait(driver,
	  3).until(ExpectedConditions
	  .visibilityOfElementLocated(By.xpath(BXpathprojid+projid+AXpathprojid))); //
	  ProjectColumnID.getText();
	  
	  System.out.println("After Validate the  ProjectID and One Project has been found in the Application  " +" \r\n"  +ProjectColumnID.getText());
	
	  
	  //Asserting Project ID column : 
	  
	  Assert.assertEquals(projid,ProjectColumnID.getText());
		System.out.println("******************************");
	  
	  }
	 
			
			
	
	

	
	
	@Then("^Logout the Application$")
		public void logout_the_application() {
		WebElement Uermenu = new WebDriverWait(driver, 3).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='userMenu']"))); 
		Uermenu.click();
		WebElement logout = new WebDriverWait(driver, 3).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@id='userMenu-logout ']"))); 
		logout.click();
	}
	
	
	@Then("^Close the browser$")
	public void close_the_browser() {
		
		driver.quit();
	}
	
}
