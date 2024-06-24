package pl.akadaemiaqa.pages.sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akadaemiaqa.pages.BasePage;
import pl.akadaemiaqa.pages.modals.AddToCartConfirmationModalPage;

public class AddToCartSection extends BasePage {

    private Locator addToCartButton;

    public AddToCartSection(Page page) {
        super(page);
        this.addToCartButton = page.locator(".add-to-cart");

    }

    public AddToCartConfirmationModalPage addProductToCart(){
        addToCartButton.click();

        return new AddToCartConfirmationModalPage(page);
    }
}
