package pl.akademiaqa.utils;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class FakerUtils {
    public static String getRandomEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getFirstName() {
        return new Faker().name().firstName();
    }

    public static String getLastName() {
        return new Faker().name().lastName();
    }

    public static String getRandomPassword() {
        return new Faker().internet().password();
    }

    public static String getRandomDob() {
        return new Faker().date().birthday(18, 80).toString();
    }

    public static String getStreetName() {
        return new Faker().address().streetAddress();
    }

    public static String getRandomZipCode() {
        return new Faker().address().zipCode();
    }

    public static String getRandomCity() {
        return new Faker().address().city();
    }
}
