package pl.akadaemiaqa.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pl.akadaemiaqa.pages.ArtPage;
import pl.akadaemiaqa.pages.SearchResultsPage;

public class TopMenuAndSearchSection {

    private Page page;
    private Locator searchInput;
    private Locator artLink;

    public TopMenuAndSearchSection(Page page) {
        this.page = page;
        this.searchInput = page.locator("input[name=s]");
        this.artLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Art").setExact(true));
    }

    public SearchResultsPage searchForProducts(String productName) {
        searchInput.fill(productName);
        page.keyboard().press("Enter");

        return new SearchResultsPage(page);
    }

    public ArtPage clickArtLink(){
        artLink.click();
        return new ArtPage(page);
    }
}
