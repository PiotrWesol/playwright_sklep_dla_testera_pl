package pl.akadaemiaqa.fasades;

import pl.akadaemiaqa.pages.OrderConfirmationPage;
import pl.akadaemiaqa.pages.modals.AddToCartConfirmationModalPage;

public class OrderProductFacade {

    public OrderConfirmationPage orderProduct(AddToCartConfirmationModalPage confirmationPage){
        return confirmationPage
                .proceedToCheckoutOnModal()
                .proceedToCheckoutOnShoppingCartPage()
                .enterOrderDetails();
    }
}
