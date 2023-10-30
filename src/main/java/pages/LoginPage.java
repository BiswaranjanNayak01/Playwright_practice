package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    public LoginPage(Page page){
        this.page=page;
    }
    Page page;
    private String price="//span[@class=\"price-new\"]";

    public String getPrice(){
        System.out.println("price :: "+page.textContent(price));
        return page.textContent(price);
    }
}
