package pl.akadaemiaqa.pages.modals;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pl.akadaemiaqa.pages.BasePage;
import pl.akadaemiaqa.pages.ShoppingCartPage;

import static pl.akademiaqa.utils.PageUtils.waitForPageToLoad;

public class AddToCartConfirmationModalPage extends BasePage {

    private Locator confirmationLabel;
    private Locator proceedToCheckoutButton;

    public AddToCartConfirmationModalPage(Page page) {
        super(page);
        waitForPageToLoad(page);
        this.confirmationLabel = page.locator("#myModalLabel");
        this.proceedToCheckoutButton = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Proceed to checkout"));
    }

    public String getConfirmationMessage() {

        return confirmationLabel.innerText();

    }

    public ShoppingCartPage proceedToCheckoutOnModal() {

        proceedToCheckoutButton.click();
        return new ShoppingCartPage(page);
    }
}
