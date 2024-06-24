package pl.akadaemiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akadaemiaqa.pages.sections.shoppingCartPage.SummarySection;

import static pl.akademiaqa.utils.PageUtils.waitForPageToLoad;

@Getter
public class ShoppingCartPage extends BasePage {

    private SummarySection summarySection;

    public ShoppingCartPage(Page page) {
        super(page);
        waitForPageToLoad(page);
        this.summarySection = new SummarySection(page);
    }

    public OrderDetailsPage proceedToCheckoutOnShoppingCartPage() {
        return summarySection.proceedToCheckout();
    }
}
