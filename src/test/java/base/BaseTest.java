package base;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageDriverFactory.playwrightPageDriver;
import pages.HomePage;
import pages.LoginPage;

import static pageDriverFactory.playwrightPageDriver.browser;
import static pageDriverFactory.playwrightPageDriver.browserContext;

public class BaseTest {
    playwrightPageDriver pageDriver;
    protected Page page;
    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        pageDriver=new playwrightPageDriver();
        page=pageDriver.initBrowser("chrome");
//        loginPage=new LoginPage(page);
    }
    @AfterMethod
    public void tearDown(){
        page.context().browser().close();
    }
}
