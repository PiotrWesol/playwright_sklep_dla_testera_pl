package pl.akademiaqa.dto;

import lombok.Builder;
import lombok.Getter;
import pl.akademiaqa.utils.FakerUtils;

@Builder
@Getter
public class AddressDto {

    private String streetName;
    private String zipCode;
    private String city;

    public static AddressDto getAddressDto() {
        return AddressDto.builder()
                .streetName(FakerUtils.getStreetName())
                .zipCode(FakerUtils.getRandomZipCode())
                .city(FakerUtils.getRandomCity())
                .build();
    }
}
