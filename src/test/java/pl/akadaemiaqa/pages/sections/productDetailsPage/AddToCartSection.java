package pl.akadaemiaqa.pages.sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AddToCartSection {

    private Locator addToCartButton;

    public AddToCartSection(Page page) {
        this.addToCartButton = page.locator(".add-to-cart");

    }

    public void addProductToCart(){
        addToCartButton.click();
    }
}
