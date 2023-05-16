package SwiggyBaseClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utility.utils;

public class BaseClass extends utils {
	
	@BeforeMethod
	public void start() throws Exception {
		
		browserLaunch(getpropvalue("browser"));
		launchUrl(getpropvalue("url"));
		
		
			}
	
	
	@AfterMethod
	public void closeUp() throws Exception {
		
		Thread.sleep(7);
		driver.quit();

}

}
