package pl.akademiaqa.dto;

import com.microsoft.playwright.Locator;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    private Locator thumbnail;
    private String name;
    private double price;

}
