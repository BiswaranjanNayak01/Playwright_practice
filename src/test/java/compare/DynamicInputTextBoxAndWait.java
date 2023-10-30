package compare;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicInputTextBoxAndWait {
    private String schoolBox="//span[text()=\"Select a School\"]";
    private String eduDrpBox="//div[@class=\"select2-search\"]/input";
    private String eduDrpBox_name="//div[@class=\"select2-search\"]/label[@class=\"select2-offscreen\"]";
    private String options="//div[@role=\"option\"]";


    @Test
    public void input() throws InterruptedException {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();;
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://boards.greenhouse.io/accenturefederalservices/jobs/4240532006");
        page.locator(schoolBox).click();
        String x= page.locator(eduDrpBox_name).all().toString();
        System.out.println("x :: "+x);
        System.out.println("vvv :: "+page.locator(eduDrpBox_name).allTextContents());
        for (int i=0;i<page.locator(eduDrpBox_name).all().size();i++) {
            System.out.println("vvv 2v:: " + page.locator(eduDrpBox_name).all().get(i).allTextContents());
            if (page.locator(eduDrpBox_name).allTextContents().get(i).contains("School")) {
                System.out.println("== inside if condition ==");
                page.locator(eduDrpBox).all().get(i).fill("Excelsior College");
                break;
            }
        }
        int count=page.locator(options).all().size();
        page.waitForLoadState();
        page.waitForCondition(()->page.locator(options).all().size()>0);
//        page.waitForCondition(()->count>0);---------this will not work
        System.out.println(page.locator(options).isVisible());
        chooseFromOption(page.locator(options).all(),"Excelsior College");
        Thread.sleep(8000);
    }
    public void chooseFromOption(List<Locator> name, String value) {
        System.out.println("name :: "+name);
        for (Locator yn : name) {
            String text= yn.allTextContents().toString();
            System.out.println("yn :: " + yn.allTextContents());
            System.out.println("text :: "+text);
            if (text.contains(value)) {
                System.out.println("yn :: "+yn);
                yn.click();
                break;
            }
        }
    }
}
