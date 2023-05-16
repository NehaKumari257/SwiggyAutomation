package Utility;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.aventstack.extentreports.Status;

//import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class utils {
	public static WebDriver driver;

	public static void launchUrl(String url) {

		driver.get(url);
	}

	public static String getpropvalue(String key) {
		String value = null;
		try {
			Properties prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
			prop.load(ip);
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void browserLaunch(String browser) throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();

	}

	public static boolean waitforme(WebElement element) {
		boolean flag = false;

		try {

			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));
			// test.log(Status.PASS, id + "is available");
			flag = true;
		} catch (Exception e) {
			System.out.println("Error occured while waiting for the element :" + "with exception " + e.getMessage());
			// test.log(Status.FAIL, id + "is not available");

		}
		return flag;
	}

	public void clickElement(WebElement element) {
		try {

			if (waitforme(element)) {
				element.click();
				// test.log(Status.PASS, id + "is clicked ");
			}
		} catch (Exception e) {
			System.out.println("Error in clicking the webelement :" + e.getMessage());
			// test.log(Status.FAIL, "Failed to click the element :" + id);
		}

	}

	public boolean validateElement(WebElement element) {

		if (waitforme(element)) {
			element.isDisplayed();
			return true;
			// test.log(Status.PASS, id + "is clicked ");
		}

		else
			return false;

	}
	public String textgetmethod(WebElement element) {
		
		return element.getText(); 
		
		
	}

}
