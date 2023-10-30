package compare;

import base.BaseTest;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.nio.file.Paths;

import static pageDriverFactory.playwrightPageDriver.browserContext;

public class download extends BaseTest {
    @BeforeMethod(dependsOnMethods = "setup")
    public void br() {
        page = browserContext.newPage();
    }

    @Test
    public void download() {
        page.navigate("https://demoqa.com/upload-download");
        Download download = page.waitForDownload(() -> {
            // Perform the action that initiates download
//            page.locator("[id='downloadButton']").click();
//            page.locator("[id=\"downloadButton\"]").click();
            page.locator("id=downloadButton").click();
            /*
            [id=\"downloadButton\"] or id=downloadButton or [id='downloadButton'] , you can use any one from both of them.
             */
        });

// Wait for the download process to complete and save the downloaded file somewhere
        download.saveAs(Paths.get("src/test/resources/testData/downloaf/", download.suggestedFilename()));
    }
}
