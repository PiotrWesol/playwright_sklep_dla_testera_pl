package pl.akadaemiaqa.pages.sections.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static pl.akademiaqa.utils.StringUtils.toUTF8;

public class ProductsSection {

    private Page page;
    private List<Locator> products;

    public ProductsSection(Page page) {
        this.page = page;
        this.products = page.locator(".js-product").all();

    }

    private List<String> getProductsPricesText() {
        return page.locator(".js-product .price").allInnerTexts();
    }

    public int getNumberOfProducts() {

        return page.locator(".js-product").count();
    }

    public List<Double> getProductsPrices() {
        return getProductsPricesText().stream()
                .map(p -> p.replaceAll(toUTF8("zł"), ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    public int extractNumberOfProductsFromText() {

        String text = page.locator("#js-product-list-top").textContent();

        // Extract the number using a regular expression
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            throw new IllegalStateException("Could not find the number of products in the text: " + text);
        }
    }
}
