package hybrid.testcase.tests;

import hybrid.pages.ByCategoryPage;
import hybrid.pages.ByLocationPage;
import hybrid.pages.ConcertMenu;
import hybrid.testcase.TestBase;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicTests extends TestBase{

	@DataProvider(name = "test1")
    public static Object[][] concertNames() {
        return new Object[][] { { 1, "Rock concert of the decade" }, { 2, "Arrhythmia: Graffiti" }, { 3, "Battle of the Brass Bands" }};
    }

	@Test(groups = {"groupAndroid", "groupIOS"}, dataProvider = "test1")
	public void firstBasicTest(int concertIndex, String expectedResult) throws InterruptedException{
		ByCategoryPage categoryPage = mainPage.openByCategoryPage();
		ConcertMenu concertMenu = categoryPage.openConcertMenu();
		Assert.assertEquals(expectedResult, concertMenu.concertManuText(concertIndex));
	}

	@Test(groups = {"groupAndroid", "groupIOS"})
	public void secondBasicTest() throws InterruptedException{
		ByLocationPage locationPage = mainPage.openByLocationPage();
		Assert.assertTrue(locationPage.citiesQuantity() == 5);
	}

}
