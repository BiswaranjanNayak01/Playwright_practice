package pageTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import static pageDriverFactory.playwrightPageDriver.browserContext;

public class LoginPageTest extends BaseTest {
    @BeforeMethod(dependsOnMethods = "setup")
    public void br(){
        page=browserContext.newPage();
        homePage=new HomePage(page);
        page.navigate("https://demo.opencart.com/");
    }

    @Test
    public void price() throws InterruptedException {
        loginPage=homePage.navigateToLoginPage();
        String price=loginPage.getPrice();
        Assert.assertEquals(price,"$602.00");
    }
}
