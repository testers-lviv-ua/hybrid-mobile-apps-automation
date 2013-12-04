package hybrid.testcase;

import hybrid.pages.MainPage;
import hybrid.webdriver.HybridDriverFactory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/*
 * Base class for all the test classes
 * 
 * @author Taras Lytvyn
 */

public class TestBase {
	
	protected WebDriver webDriver;	
	protected MainPage mainPage;

	@Parameters({"browserName", "port"})
	@BeforeMethod (groups = {"groupAndroid", "groupIOS"})
	public void init(String browserName, String port) throws Exception {
		
		webDriver = HybridDriverFactory.getInstance(browserName, port);	
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.manage().deleteAllCookies();
		mainPage = PageFactory.initElements(webDriver, MainPage.class);
	
	}
	
	@AfterMethod (groups = {"groupAndroid", "groupIOS"})
	public void reopenApp(){
		webDriver.quit();
	}
	
}
