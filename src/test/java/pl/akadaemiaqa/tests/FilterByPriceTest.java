package pl.akadaemiaqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akadaemiaqa.pages.ArtPage;
import pl.akadaemiaqa.pages.HomePage;
import pl.akademiaqa.utils.Properties;

import static org.assertj.core.api.Assertions.assertThat;

class FilterByPriceTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);

    }

    @Test
    void should_return_products_with_price_grater_than_40_by_url() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        String newUrl = page.url() + "&q=Price-zł-40-44";
        page.navigate(newUrl);
        assertThat(artPage.getProductsSection().getProductsPrices().stream().allMatch(p -> p > 40)).isTrue();
    }

    @Test
    void should_return_products_with_price_grater_than_40_by_mouse() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        artPage.getFilterBySection().filterProductsByPriceWithMouse(40.00);
        assertThat(artPage.getProductsSection().getProductsPrices().stream().allMatch(p -> p > 40)).isTrue();
    }

    @Test
    void should_return_products_with_price_grater_than_40_by_keyboard() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        artPage.getFilterBySection().filterProductsByPriceWithKeyboard(40.00);
        assertThat(artPage.getProductsSection().getProductsPrices().stream().allMatch(p -> p > 40)).isTrue();
    }
}
