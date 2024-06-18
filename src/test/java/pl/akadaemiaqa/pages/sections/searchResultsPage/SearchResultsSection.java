package pl.akadaemiaqa.pages.sections.searchResultsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akadaemiaqa.pages.ProductDetailsPage;
import pl.akademiaqa.dto.ProductDto;
import pl.akademiaqa.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SearchResultsSection {

    private Page page;

    private List<Locator> products;

    public SearchResultsSection(Page page) {

        this.page = page;
        this.products = page.locator(".js-product").all();
    }

    public ProductDetailsPage viewProductDetails(String productName) {
        ProductDto productDto = productsToDto().stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Can not find product with name: " + productName));

        productDto.getThumbnail().click();

        return new ProductDetailsPage(page);
    }

    public List<ProductDto> productsToDto() {

        return products.stream()
                .map(p -> ProductDto.builder()
                        .thumbnail(p.locator(".thumbnail-top"))
                        .name(p.locator("product-title").innerText())
                        .price(Double.parseDouble(p.locator(".price").innerText().replaceAll(StringUtils.toUTF8("zł"),"")))
                        .build())
                .collect(Collectors.toList());

    }

}
