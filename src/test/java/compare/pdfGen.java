package compare;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class pdfGen {
    @Test
    public static void withURLn() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://demo.automationtesting.in/Register.html");
            page.getByPlaceholder("First Name").click();
            page.getByPlaceholder("First Name").fill("biswa");
            page.getByPlaceholder("Last Name").click();
            page.getByPlaceholder("Last Name").fill("nayak");
//            page.pause();
            page.locator("input[type=\"tel\"]").click();
            page.locator("input[type=\"tel\"]").fill("12345");
            page.pdf(new Page.PdfOptions().setPath(Paths.get("src/test/resources/screenshot/pdf_gen.pdf")));
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("src/test/resources/screenshot/pdf_gen.png"))
                    .setFullPage(true));

                /*
                page.context().browser().close();
                above call will not work after page.pause() call
                 */
        }
    }
}
