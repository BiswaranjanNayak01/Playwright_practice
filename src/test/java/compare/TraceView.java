package compare;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.nio.file.Paths;

public class TraceView {
    @Test
    public void trace() throws InterruptedException {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();;
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();

// Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        Page page = context.newPage();
        page.navigate("https://demo.automationtesting.in/Register.html");
        page.getByPlaceholder("First Name").click();
        page.getByPlaceholder("First Name").fill("biswa");
        page.getByPlaceholder("Last Name").click();
        page.getByPlaceholder("Last Name").fill("nayak");
        Thread.sleep(1000);
// Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("src/test/resources/screenshot/trace.zip")));
    }
}
