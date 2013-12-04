package hybrid.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConcertMenu extends ByCategoryPage{

	public ConcertMenu(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how = How.XPATH, using = "//*//a[contains(@href,'#events')]")
	public List <WebElement> concerts;
	
	public String concertManuText(int menuItem){
		return concerts.get(menuItem - 1).getText();
	}

}
