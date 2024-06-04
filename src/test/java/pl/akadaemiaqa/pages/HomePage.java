package pl.akadaemiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akadaemiaqa.pages.sections.TopMenuAndSearchSection;
import pl.akadaemiaqa.pages.sections.TopNavigationSection;

@Getter
public class HomePage {

    private TopMenuAndSearchSection topMenuAndSearchSection;

    private TopNavigationSection topNavigationSection;

    public HomePage(Page page){
        this.topMenuAndSearchSection = new TopMenuAndSearchSection(page);
        this.topNavigationSection = new TopNavigationSection(page);

    }

}
