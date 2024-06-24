package pl.akadaemiaqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akadaemiaqa.fasades.AddProductToCartFacade;
import pl.akadaemiaqa.fasades.OrderProductFacade;
import pl.akadaemiaqa.pages.HomePage;
import pl.akadaemiaqa.pages.OrderConfirmationPage;
import pl.akadaemiaqa.pages.OrderDetailsPage;
import pl.akadaemiaqa.pages.ProductDetailsPage;
import pl.akadaemiaqa.pages.SearchResultsPage;
import pl.akadaemiaqa.pages.ShoppingCartPage;
import pl.akadaemiaqa.pages.modals.AddToCartConfirmationModalPage;
import pl.akadaemiaqa.pages.sections.orderDetailsPage.OrderAddressSection;
import pl.akadaemiaqa.pages.sections.orderDetailsPage.OrderPaymentSection;
import pl.akadaemiaqa.pages.sections.orderDetailsPage.OrderShippingSection;

import static org.assertj.core.api.Assertions.assertThat;

class FullPurchaseTest extends BaseTest {

    private String productName = "Customizable Mug";
    private HomePage homePage;
    private AddProductToCartFacade addProductToCartFacade;
    private OrderProductFacade orderProductFacade;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        addProductToCartFacade = new AddProductToCartFacade(homePage);
        orderProductFacade = new OrderProductFacade();
    }

    @Test
    void should_purchase_selected_product_v1_test() {

        SearchResultsPage searchResultsPage = homePage.getTopMenuAndSearchSection().searchForProduct(productName);
        ProductDetailsPage productDetailsPage = searchResultsPage.getSearchResultsSection()
                .viewProductDetails(productName);

        productDetailsPage.getProductCustomizationSection().customizeProduct(productName);
        AddToCartConfirmationModalPage confirmationModal = productDetailsPage.getAddToCartSection().addProductToCart();
        assertThat(confirmationModal.getConfirmationMessage()).contains(
                "Product successfully added to your shopping cart");
        ShoppingCartPage shoppingCartPage = confirmationModal.proceedToCheckoutOnModal();
        OrderDetailsPage orderDetailsPage = shoppingCartPage.getSummarySection().proceedToCheckout();

        OrderAddressSection addressSection = orderDetailsPage.getPersonalInformation().enterPersonalInformation();
        OrderShippingSection shippingSection = addressSection.enterAddress();
        OrderPaymentSection paymentSection = shippingSection.selectShippingMethod();
        OrderConfirmationPage confirmationPage = paymentSection.placeOrder();
        assertThat(confirmationPage.getConfirmationDetailsSection().getConfirmationTitle()).containsIgnoringCase(
                "Your order is confirmed");

    }

    @Test
    void should_purchase_selected_product_v2_test() {

        AddToCartConfirmationModalPage confirmationModal = homePage.searchForProduct(productName)
                .viewProductDetails(productName)
                .customizeProduct(productName)
                .addProductToCart();

        assertThat(confirmationModal.getConfirmationMessage()).contains(
                "Product successfully added to your shopping cart");

        OrderConfirmationPage confirmationPage = confirmationModal.proceedToCheckoutOnModal()
                .proceedToCheckoutOnShoppingCartPage()
                .enterOrderDetails();

        assertThat(confirmationPage.getConfirmationDetailsSection().getConfirmationTitle()).containsIgnoringCase(
                "Your order is confirmed");

    }

    @Test
    void should_purchase_selected_product_v3_test(){

        AddToCartConfirmationModalPage confirmationModal = addProductToCartFacade.addProductWithCustomizationToCart(
                productName);

        assertThat(confirmationModal.getConfirmationMessage()).contains("Product successfully added to your shopping cart");

        OrderConfirmationPage confirmationPage = orderProductFacade.orderProduct(confirmationModal);
        assertThat(confirmationPage.getConfirmationDetailsSection().getConfirmationTitle()).containsIgnoringCase(
                "Your order is confirmed");


    }
}
