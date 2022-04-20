package Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	
	public static WebDriver driver;
	public static boolean isClickable(WebElement webelement) {
	
		try {
			
			WebDriverWait wait= new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(webelement));
			return true;
		}
		
		catch(Exception e) {
			
			return false;
		}
	}
	
	
	public static boolean isClickableByJScript(WebElement webelement) {
		
		try {
			
			WebDriverWait wait= new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(webelement));
			return true;
		}
		
		catch(Exception e) {
			
			return false;
		}
	}

}
