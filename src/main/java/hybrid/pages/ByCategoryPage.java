package hybrid.pages;

import hybrid.pages.base.PageFactoryHybrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ByCategoryPage extends MainPage{

	public ByCategoryPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (how = How.XPATH, using = "//*//h2/a/span/span")
	public WebElement concertButton;
	
	public ConcertMenu openConcertMenu(){
		concertButton.click();
		return PageFactoryHybrid.initElements(webDriver, ConcertMenu.class);
	}
	

}
