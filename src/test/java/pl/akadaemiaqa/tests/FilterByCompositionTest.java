package pl.akadaemiaqa.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akadaemiaqa.pages.ArtPage;
import pl.akadaemiaqa.pages.HomePage;
import pl.akademiaqa.utils.Properties;

class FilterByCompositionTest extends BaseTest {
    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);

    }

    @Test
    void should_return_3_products_filtered_by_matt_paper() {

        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        artPage.getFilterBySection().clickCheckboxMattPaper();
        Assertions.assertThat(artPage.getProductsSection().getNumberOfProducts()).isEqualTo(3);

    }

    @Test
    void should_return_text_number_of_filtered_products() {

        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        artPage.getFilterBySection().clickCheckboxMattPaper();
        Assertions.assertThat(artPage.getProductsSection().extractNumberOfProductsFromText()).isEqualTo(3);

    }
}
