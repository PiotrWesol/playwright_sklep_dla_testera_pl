package pl.akadaemiaqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akadaemiaqa.pages.HomePage;
import pl.akadaemiaqa.pages.ProductDetailsPage;
import pl.akadaemiaqa.pages.SearchResultsPage;
import pl.akademiaqa.utils.Properties;

public class FullPurchaseTest extends BaseTest{

    private HomePage homePage;

    @BeforeEach
    void beforeEach(){
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
    }
    @Test
    void should_purchase_selected_product_test(){

        SearchResultsPage searchResultsPage = homePage.getTopMenuAndSearchSection()
                .searchForProducts("Customizable Mug");
        ProductDetailsPage productDetailsPage = searchResultsPage.getSearchResultsSection()
                .viewProductDetails("Customizable Mug");

        productDetailsPage.getProductCustomizationSection().customizeProduct("Customizable Mug");
        productDetailsPage.getAddToCartSection().addProductToCart();

    }
}
