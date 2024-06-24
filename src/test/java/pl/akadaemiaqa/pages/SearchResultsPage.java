package pl.akadaemiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akadaemiaqa.pages.sections.searchResultsPage.SearchResultsSection;

import static pl.akademiaqa.utils.PageUtils.waitForPageToLoad;

public class SearchResultsPage extends BasePage{

    @Getter
    private SearchResultsSection searchResultsSection;

    public SearchResultsPage(Page page) {
        super(page);
        waitForPageToLoad(page);
        this.searchResultsSection = new SearchResultsSection(page);
    }

    public ProductDetailsPage viewProductDetails(String productName){
        return getSearchResultsSection().viewProductDetails(productName);
    }
}
