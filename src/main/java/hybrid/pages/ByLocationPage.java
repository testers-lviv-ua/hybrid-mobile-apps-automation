package hybrid.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ByLocationPage extends MainPage{

	public ByLocationPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (how = How.XPATH, using = "*//div[contains(@id,'itemMenu')]/div/h2/a/span/span[1]")
	public List <WebElement> cities;
	
	public int citiesQuantity(){
		return cities.size();
	}

}
