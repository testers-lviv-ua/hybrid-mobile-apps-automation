package hybrid.webdriver;

import hybrid.util.PropertyLoader;
import io.selendroid.SelendroidCapabilities;
import io.selendroid.device.DeviceTargetPlatform;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.uiautomation.ios.IOSCapabilities;

/*
 * Factory to instantiate a WebDriver object. It returns an instance of RemoteWebDriver
 * for executing on IOS server or Selendroid binding of WebDriver for IOS and Android devices
 * 
 * @author Taras Lytvyn
 */

public class HybridDriverFactory { 
	
	public static final String IPHONE = "iphone";
	public static final String ANDROID = "android";
	
	public static final String IOS_APPIUM = "iphoneAppium";
	
	public static WebDriver getInstance(String browserName, String port) throws Exception {
		
		WebDriver webDriver = null;
		DesiredCapabilities capa = null;
		URL remoteUrl = new URL("http://localhost:" + port + "/wd/hub");
		
		if (IPHONE.equals(browserName)) {
			
			/**
			 * https://github.com/ios-driver/ios-driver/issues/179 
			 * */
			  capa = IOSCapabilities.iphone(PropertyLoader.loadProperty("appId.ios"));
			  webDriver = new RemoteWebDriver(remoteUrl, capa);
		      webDriver.switchTo().window("Web");
			
			
		} else if (ANDROID.equals(browserName)) {
				capa = SelendroidCapabilities.device(DeviceTargetPlatform.ANDROID16, PropertyLoader.loadProperty("appId.android"));
				webDriver = new RemoteWebDriver(remoteUrl, capa);
				webDriver.switchTo().window("WEBVIEW");
			
		} else if (IOS_APPIUM.equals(browserName)){
				capa = new DesiredCapabilities();
				capa.setCapability("device", "iPhone Simulator");
				capa.setCapability("app", "/Users/administrator/git/new-development/TicketMonster.app");
				webDriver = new RemoteWebDriver(remoteUrl, capa);
				//switch to the latest web view
				  for(String winHandle : webDriver.getWindowHandles()){
				    webDriver.switchTo().window(winHandle);
				  }
			}
		
		return webDriver;
	}


}