package pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;
        private String search="input[name='search']";
//    private String search ="search";
    private String searchIcon = "div#search button";
    private String featuredText = "div#content h3";
    private String nextPageTitle = "div.container-fluid h5";
    private String macbook="//h4/a[contains(text(),'MacBook')]";

    public HomePage(Page page) {
        this.page = page;
    }

    public String getHomePageTitle() {
        System.out.println(page.title()
        );
        return page.title();
    }

    public String getHomePageUrl() {
        return page.url();
    }

    public void doSearch(String name) {
        page.fill(search, name);
        page.click(searchIcon);
        System.out.println(page.textContent(nextPageTitle));
    }

    public String getFeaturedText() {
        return page.textContent(featuredText);
    }
    public LoginPage navigateToLoginPage(){
        page.click(macbook);
        return new LoginPage(page);
    }
}
