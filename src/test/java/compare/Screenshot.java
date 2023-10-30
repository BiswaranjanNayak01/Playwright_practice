package compare;

import base.BaseTest;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static pageDriverFactory.playwrightPageDriver.browserContext;

public class Screenshot extends BaseTest {
    @BeforeMethod(dependsOnMethods = "setup")
    public void br() {
        page = browserContext.newPage();
    }

    @Test
    public void screenshot(){
        page.navigate("https://demo.opencart.com/");
        page.locator("[title=\"iPhone\"]").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("src/test/resources/screenshot/screenshot1.png")));
    }

    @Test
    public void getFullScreenShot(){
        page.navigate("https://demo.opencart.com/");
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("src/test/resources/screenshot/screenshot.png"))
                .setFullPage(true));
    }
}
