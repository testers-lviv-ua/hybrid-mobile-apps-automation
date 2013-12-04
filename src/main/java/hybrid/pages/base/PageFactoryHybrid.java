package hybrid.pages.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactoryHybrid extends PageFactory{
	
	public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
	    T page = instantiatePage(driver, pageClassToProxy);
	    initElements(driver, page);
	    waitForNextPageToLoad(driver);
	    return page;
	  }
	
	private static <T> T instantiatePage(WebDriver driver, Class<T> pageClassToProxy) {
	    try {
	      try {
	        Constructor<T> constructor = pageClassToProxy.getConstructor(WebDriver.class);
	        return constructor.newInstance(driver);
	      } catch (NoSuchMethodException e) {
	        return pageClassToProxy.newInstance();
	      }
	    } catch (InstantiationException e) {
	      throw new RuntimeException(e);
	    } catch (IllegalAccessException e) {
	      throw new RuntimeException(e);
	    } catch (InvocationTargetException e) {
	      throw new RuntimeException(e);
	    }
	  }
	
	public static void waitForNextPageToLoad(WebDriver driver){
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>(){
			@Override
			public Boolean apply(WebDriver expectationDriver) {
				JavascriptExecutor js = (JavascriptExecutor) expectationDriver;
				return js.executeScript("return document.readyState").equals("complete");
			}
		};
		
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
		} catch(Throwable error){
			System.out.println("Timeout waiting page to Load because of: " + error.getMessage());
		}
	}

}
