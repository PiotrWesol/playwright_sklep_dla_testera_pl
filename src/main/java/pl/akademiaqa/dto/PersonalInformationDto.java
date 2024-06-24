package pl.akademiaqa.dto;

import lombok.Builder;
import lombok.Getter;
import pl.akademiaqa.utils.FakerUtils;

import static pl.akademiaqa.utils.FakerUtils.*;

@Builder
@Getter
public class PersonalInformationDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dob;

    public static PersonalInformationDto getPersonalInformationDto(){
        return PersonalInformationDto.builder()
                .firstName(FakerUtils.getFirstName())
                .lastName(FakerUtils.getLastName())
                .email(getRandomEmail())
                .password(FakerUtils.getRandomPassword())
                .dob(FakerUtils.getRandomDob())
                .build();
    }
}
