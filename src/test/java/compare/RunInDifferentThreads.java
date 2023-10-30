package compare;
//
//public class newcheck {
//}


import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static java.util.Arrays.asList;

public class RunInDifferentThreads extends Thread {
    private String browserName;

    private RunInDifferentThreads(String browserName) {
        this.browserName = browserName;
    }

    public static void main(String[] args) throws InterruptedException {
        for (String browserName: asList("chromium", "webkit", "firefox")) {
            Thread thread = new RunInDifferentThreads(browserName);
            thread.start();
            System.out.println(thread.getName());
            Thread.sleep(8000);
//            System.out.println(thread.isVirtual());
        }
    }
    @Test
    public static void allBrowsers() throws InterruptedException {
        // Create separate playwright thread for each browser.
        for (String browserName: asList("chromium", "webkit", "firefox")) {
            Thread thread = new RunInDifferentThreads(browserName);
            thread.start();
            System.out.println(thread.getName());
            Thread.sleep(8000);
        }
    }

    @Test
    public void chromium() throws InterruptedException {
        browserName="chromium";
        Thread thread = new RunInDifferentThreads(browserName);
        System.out.println(thread.getName());
        thread.start();
        Thread.sleep(8000);
    }

    @Test
    public void webkit() throws InterruptedException {
        browserName="webkit";
        Thread thread = new RunInDifferentThreads(browserName);
        System.out.println(thread.getName());
        thread.start();
        Thread.sleep(8000);
    }
    @Test
    public void firefox() throws InterruptedException {
        browserName="firefox";
        Thread thread = new RunInDifferentThreads(browserName);
        System.out.println(thread.getName());
        thread.start();
        Thread.sleep(8000);
    }

    @Override
    public void run() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = getBrowserType(playwright, browserName);
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));;
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("user-agent-" + browserName + ".png")));
        }
    }

    private static BrowserType getBrowserType(Playwright playwright, String browserName) {
        switch (browserName) {
            case "chromium":
                return playwright.chromium();
            case "webkit":
                return playwright.webkit();
            case "firefox":
                return playwright.firefox();
            default:
                throw new IllegalArgumentException();
        }
    }
}