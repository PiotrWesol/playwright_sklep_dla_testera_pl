package pl.akadaemiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akadaemiaqa.pages.modals.AddToCartConfirmationModalPage;
import pl.akadaemiaqa.pages.sections.productDetailsPage.AddToCartSection;
import pl.akadaemiaqa.pages.sections.productDetailsPage.ProductCustomizationSection;

import static pl.akademiaqa.utils.PageUtils.waitForPageToLoad;

@Getter
public class ProductDetailsPage extends BasePage {

    private ProductCustomizationSection productCustomizationSection;
    private AddToCartSection addToCartSection;

    public ProductDetailsPage(Page page) {
        super(page);
        waitForPageToLoad(page);
        this.productCustomizationSection = new ProductCustomizationSection(page);
        this.addToCartSection = new AddToCartSection(page);
    }

    public ProductDetailsPage customizeProduct(String customMessage) {
        productCustomizationSection.customizeProduct(customMessage);
        return this;
    }

    public AddToCartConfirmationModalPage addProductToCart() {
        return addToCartSection.addProductToCart();
    }
}
