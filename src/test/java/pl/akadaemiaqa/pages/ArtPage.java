package pl.akadaemiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akadaemiaqa.pages.sections.products.FilterBySection;
import pl.akadaemiaqa.pages.sections.products.ProductsSection;

import static pl.akademiaqa.utils.PageUtils.waitForPageToLoad;

@Getter
public class ArtPage {

    private ProductsSection productsSection;
    private FilterBySection filterBySection;

    public ArtPage(Page page) {
        waitForPageToLoad(page);
        this.productsSection = new ProductsSection(page);
        this.filterBySection = new FilterBySection(page);
    }
}
