package pl.akadaemiaqa.pages.sections.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TopNavigationSection {

    private Page page;
    private Locator languageSelector;
    private Locator english;

    private Locator selectedLanguage;

    public TopNavigationSection(Page page) {
        this.page = page;
        this.languageSelector = page.locator(".language-selector");
        this.english = page.locator("a[data-iso-code=en]");
        this.selectedLanguage = page.locator("span[class=expand-more]");
    }

    public void setPageLanguageToEn() {
        if (!selectedLanguage.innerText().equalsIgnoreCase("english")) {
            languageSelector.click();
            english.click();
        }

    }
}
