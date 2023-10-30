package pageDriverFactory;

import com.microsoft.playwright.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Properties;

public class playwrightPageDriver {
    Playwright playwright;
    public static Browser browser;
    Page page;
    public static BrowserContext browserContext;

    public Page initBrowser(String BrowserName) {
        playwright=Playwright.create();
        switch (BrowserName.toLowerCase()){
            case "chromium":browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "edge":browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("edge").setHeadless(false));
                break;
            default:
                System.out.println("Please pass the right browser name ...");
                break;
        }
        browserContext=browser.newContext();
//        page=browserContext.newPage();
//        page.navigate("https://demo.opencart.com/");
        return page;
    }
    public static String getValue(String keyName) {
        String value = null;
        try {
            FileInputStream in = new FileInputStream("src/test/resources/config/Config.properties");
            Properties prop=new Properties();
            prop.load(in);
             value=prop.getProperty(keyName);
        }catch (Exception e){e.printStackTrace();}
        return value;
    }

}
