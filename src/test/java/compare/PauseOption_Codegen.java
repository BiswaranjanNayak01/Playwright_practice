package compare;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class PauseOption_Codegen {
    @Test
    public static void withoutURL() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType chromium = playwright.chromium();
            // Make sure to run headed.
            Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
            // Setup context however you like.
            BrowserContext context = browser.newContext(/* pass any options */);
            context.route("**/*", route -> route.resume());
            // Pause the page, and start recording manually.
            Page page = context.newPage();
//            page.navigate("https://demo.automationtesting.in/Register.html");
            page.pause();
        }
    }

    @Test
    public static void withURL() {
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
            page.pause();
            page.context().browser().close();

                /*
                page.context().browser().close();
                above call will not work after page.pause() call
                 */
        }
    }
}

