package SwiggyTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import SwiggyBaseClass.BaseClass;
import SwiggyPages.LoginPage;

public class LoginTestcase extends BaseClass {
	
@Test
	
	public void tc001_validate_location() throws Exception {
		LoginPage lp=new LoginPage();
		
		lp.location("Chennai");
		Thread.sleep(5000);
		lp.searchtext("pizza");
	    Thread.sleep(5000);

}
@Test

    public void validatesearchButton() {
	LoginPage lg = new LoginPage();

	 Assert.assertTrue(validateElement(lg.clickOnsearch()));
}



}