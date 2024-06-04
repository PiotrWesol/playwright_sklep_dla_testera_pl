package pl.akadaemiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akadaemiaqa.pages.sections.searchResultsPage.SearchResultsSection;

import static pl.akademiaqa.utils.PageUtils.waitForPageToLoad;

public class SearchResultsPage {

    @Getter
    private SearchResultsSection searchResultsSection;

    public SearchResultsPage(Page page) {
        waitForPageToLoad(page);
        this.searchResultsSection = new SearchResultsSection(page);
    }
}
