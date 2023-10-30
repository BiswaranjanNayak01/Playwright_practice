package compare;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class SelectFromDropDown {

    @Test
    public void select() {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        ;
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://boards.greenhouse.io/accenturefederalservices/jobs/4240532006");
//        page.pause();
        page.locator("#s2id_job_application_answers_attributes_1_answer_selected_options_attributes_1_question_option_id").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Please select")).click();
        page.locator("#select2-result-label-26").click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Select a School")).click();
        page.locator("#select2-result-label-90").click();

        /*
        #select2-result-label-26 is not the id for Alaska but still clicking on this.
        ----------------------------- Confused -----------------------
         */
//        page.locator("").selectOption("");
        page.pause();
    }

    @Test
    public void selectWithSelectTag() {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        ;
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://demo.automationtesting.in/Register.html");

        page.locator("id=Skills").selectOption("Adobe Photoshop");
        page.locator("#yearbox").selectOption("1927");
        page.locator("#Skills").selectOption("Android");

        page.pause();
    }

    @Test
    public void select3() {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        ;
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://demo.automationtesting.in/Register.html");

        page.getByLabel("", new Page.GetByLabelOptions().setExact(true)).click();
        page.getByRole(AriaRole.TREEITEM, new Page.GetByRoleOptions().setName("Hong Kong")).click();
        page.getByTitle("Hong Kong").click();
        page.getByRole(AriaRole.TREEITEM, new Page.GetByRoleOptions().setName("India")).click();

        page.pause();
    }

    @Test
    public void select4_Select1_having_same_School_ID_But_Different_Result() {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        ;
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://boards.greenhouse.io/accenturefederalservices/jobs/4240532006");

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Select a School")).click();
        page.locator("#select2-result-label-90").click();
        page.reload();
        page.locator("#select2-chosen-20").click();
        page.locator("#select2-result-label-90").click();

        page.pause();
    }
}
