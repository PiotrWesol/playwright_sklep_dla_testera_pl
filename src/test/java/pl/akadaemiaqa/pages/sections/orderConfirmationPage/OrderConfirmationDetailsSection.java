package pl.akadaemiaqa.pages.sections.orderConfirmationPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akadaemiaqa.pages.BasePage;

public class OrderConfirmationDetailsSection extends BasePage {


    private final String orderConfirmationSection = "#content-hook_order_confirmation ";
    private Locator title;
    public OrderConfirmationDetailsSection(Page page) {
        super(page);
        this.title = page.locator(orderConfirmationSection + ".card-title");
    }

    public String getConfirmationTitle(){
        return title.innerText();
    }
}
