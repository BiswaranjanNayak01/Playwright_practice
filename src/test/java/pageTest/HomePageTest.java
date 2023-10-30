package pageTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;

import static pageDriverFactory.playwrightPageDriver.browserContext;

public class HomePageTest extends BaseTest {
    @BeforeMethod(dependsOnMethods = "setup")
    public void br(){
        page=browserContext.newPage();
        homePage=new HomePage(page);
        page.navigate("https://demo.opencart.com/");
    }


    @Test()
    public void HomePageTitleTest() {
        String title = homePage.getHomePageTitle();
        Assert.assertEquals(title, "Your Store");
        System.out.println(homePage.getFeaturedText());
        Assert.assertEquals(homePage.getFeaturedText(), "Featured");
    }

    @Test
    public void search() throws InterruptedException {
        homePage.doSearch("Apple");

    }
}
