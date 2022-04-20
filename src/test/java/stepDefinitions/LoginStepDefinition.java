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

import Utils.Utility;
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
WebDriver driver;
	
	public Utility obj= new Utility();
	

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
	// //Reg Exp:
	// //1. \"([^\"]*)\"
	// //2. \"(.*)\"
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

		String BXpath = "div[id='";

		String AXpath = "-currentProjects-row']";

		// div[id='0-currentProjects-row']

		// xapth of project ID cloumn : //div[@id
		// ='0-currentProjects-row']//div[contains (text(),2384)]
		// div[@id ='0-currentProjects-row']//div[contains (text(),2384)]

		String BXpathprojid = "//div[@id ='0-currentProjects-row']//div[contains (text(),";

		String AXpathprojid = ")]";

		// div[@id ='0-currentProjects-row']//div[contains (text(),2384)]

		for (int j = 0; j <= 0; j++) {

			WebElement CurrentProjectID = new WebDriverWait(driver, 3)
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(BXpath + j + AXpath)));

			String FindingProjectID = CurrentProjectID.getText();
			System.out.println("******************************");

			System.out.println("After search project ID and Record informtion" + "\r\n" + FindingProjectID);
			// break;
			System.out.println("******************************");

		}

		WebElement ProjectColumnID = new WebDriverWait(driver, 3)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BXpathprojid + projid + AXpathprojid))); //
		ProjectColumnID.getText();

		System.out.println("After Validate the  ProjectID and One Project has been found in the Application  " + " \r\n"
				+ ProjectColumnID.getText());

		// Asserting Project ID column :

		Assert.assertEquals(projid, ProjectColumnID.getText());
		System.out.println("******************************");

	}

	@Then("^user view Project details$")
	public void user_view_Project_details() {
		// Click Project view

		WebElement ViewProjDetails = new WebDriverWait(driver, 3).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"0-currentProjects-row-toggleOpen-icon\"]")));
		ViewProjDetails.click();

		

	}

	@Then("^user click Edit Project$")
	public void user_click_Edit_Project() {

		// Click Edit project

		WebElement EditProj = new WebDriverWait(driver, 3)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='0-editSampleIcon']")));
		EditProj.click();

	}

	@Then("^User verify Test and Lanuch tabs are in disable status$")
	public void User_verify_Test_and_Lanuch_tabs_are_in_disable_status() {

		// verify Test tab status 

		WebElement TestTab = new WebDriverWait(driver, 3)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='Wizard-Test']")));
		
		boolean ActualTest=Utility.isClickable(TestTab);
		
		//boolean ActualTest=TestTab.isEnabled();
		
		System.out.println("Test tab status is" +"          "+ActualTest);
		
		//Verify Test tab status
		Assert.assertEquals(false, ActualTest);
		
		

				WebElement LaunchTab = new WebDriverWait(driver, 3)
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='Wizard-Launch']")));
				
				boolean ActualLaunch=Utility.isClickable(LaunchTab);
				
				//boolean ActualLaunch=TestTab.is
				System.out.println("Launch tab status is" +"          "+ActualLaunch);

				// verify Launch tab status 
				Assert.assertEquals(false, ActualLaunch);
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
				
	}
	
	
	
	
	@Then("^User Edit Requested N and enter quota group Requested N as\"(.*)\"$")
	//Then User enter quota group Requested N as"3"
	public void User_Edit_Requested_N_and_enter_quota_group_Requested_N_as(String RNquota) throws InterruptedException {
		// click Requsted N
		
		WebElement IQGRequestN = new WebDriverWait(driver, 3)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-yZwTr cpvWLC']/div[1]//div[contains(text(),'Requested N')]/following-sibling::div[1]//button//*[local-name()='svg']")));
		
		//*[@id="overviewQuotaGroups"]/div[1]/div[4]/div/div/div[2]/button
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		IQGRequestN.click();
		
		// Select all quota group
		WebElement AllQuota = new WebDriverWait(driver, 3)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'All')]")));
		
		
		AllQuota.click();
		
		// Count number of selected Quota group
		
		List <WebElement> SelectedQuotas=driver.findElements(By.xpath("//ul[@class='MuiList-root sc-kREsUy jwTuPR MuiList-padding']"));
		
		//System.out.println("number of selected Quota groups"+"        "+SelectedQuotas.size());
		int checkedCount=0,uncheckedCount=0;
		
		for(int i=0; i<SelectedQuotas.size();i++) {
			
			System.out.println(i+ " checkbox is selcted"+SelectedQuotas.get(i).isSelected() );
			if(SelectedQuotas.get(i).isSelected()) {
				checkedCount++;
			}
			else {
				uncheckedCount++;
			}
		}
		
		System.out.println("number of selected checkbxes"+"     "+checkedCount);
		System.out.println("number of unselected checkbxes"+"     "+uncheckedCount);
		
		// enter quota group Requested N
				WebElement EnterQuota = new WebDriverWait(driver, 3)
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='sc-fnwBNb djdyJs']")));
				
				EnterQuota.sendKeys(RNquota);
				
				
				/*
				 * WebElement SelectedQuotas = new WebDriverWait(driver, 3)
				 * .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				 * "//button[@id='requested-n-bulk-edit-quota-group-value-modal-complete']")));
				 */
				
				
				// Click Complete button 
				WebElement Complete_Button = new WebDriverWait(driver, 3)
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='requested-n-bulk-edit-quota-group-value-modal-complete']")));
				
				Complete_Button.click();
				
				
	}
	
	
	@Then("^Logout the Application$")
	public void logout_the_application() {
		WebElement Uermenu = new WebDriverWait(driver, 3)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='userMenu']")));
		Uermenu.click();
		WebElement logout = new WebDriverWait(driver, 3)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='userMenu-logout ']")));
		logout.click();
	}

	@Then("^Close the browser$")
	public void close_the_browser() {

		driver.quit();
	}

	
}
