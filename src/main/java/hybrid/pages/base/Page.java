package hybrid.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class Page {
	
	protected WebDriver webDriver;
	
	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

}
