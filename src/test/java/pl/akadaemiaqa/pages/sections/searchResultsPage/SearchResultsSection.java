package pl.akadaemiaqa.pages.sections.searchResultsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

import java.util.List;

@Getter
public class SearchResultsSection {

    private List<Locator> products;

    public SearchResultsSection(Page page) {

        this.products = page.locator(".js-product").all();
    }

}
