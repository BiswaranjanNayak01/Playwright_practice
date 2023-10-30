package compare;

import base.BaseTest;
import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.nio.file.Paths;

import static pageDriverFactory.playwrightPageDriver.browser;
import static pageDriverFactory.playwrightPageDriver.browserContext;

public class RecordVideo extends BaseTest {
    @BeforeMethod(dependsOnMethods = "setup")
    public void setVideoDirectory() throws InterruptedException {
        browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("src/test/resources/video/")));
        page=browserContext.newPage();
    }

    @Test
    public void recordVideo() throws InterruptedException {
        page.navigate("https://demo.opencart.com/");
        HomePage homePage=new HomePage(page);
        String title = homePage.getHomePageTitle();
        Thread.sleep(2000);
        Assert.assertEquals(title, "Your Store");
        System.out.println(homePage.getFeaturedText());
        Assert.assertEquals(homePage.getFeaturedText(), "Featured");
        homePage.doSearch("Apple");
        Thread.sleep(2000);
        browserContext.close();
        browser.close();
        System.out.println(page.video().path());
        /*
        always close everything after recording the video otherwise the program will continue to run.
         */
    }

}
