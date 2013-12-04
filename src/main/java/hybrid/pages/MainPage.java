package hybrid.pages;

import hybrid.pages.base.Page;
import hybrid.pages.base.PageFactoryHybrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends Page{

	public MainPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (how = How.LINK_TEXT, using = "By Category")
	public WebElement byCategoryButton;
	
	@FindBy (how = How.LINK_TEXT, using = "By Location")
	public WebElement byLocationButton;
	
	public ByCategoryPage openByCategoryPage() throws InterruptedException{
		byCategoryButton.click();
		return PageFactoryHybrid.initElements(webDriver, ByCategoryPage.class);
	}
	
	public ByLocationPage openByLocationPage() throws InterruptedException{
		byLocationButton.click();
		return PageFactoryHybrid.initElements(webDriver, ByLocationPage.class);
	}
	
}
