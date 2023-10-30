package compare;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class AutoScrollToFindLocator {
    @Test
    public void autoScroll(){
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();;
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://boards.greenhouse.io/accenturefederalservices/jobs/4240532006");

        page.getByLabel("Select a School", new Page.GetByLabelOptions().setExact(true)).click();
        page.locator("#select2-result-label-90").click();

        page.pause();
    }
}