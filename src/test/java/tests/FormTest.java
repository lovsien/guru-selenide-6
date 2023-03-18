package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

public class FormTest {
    String firstName = "Tanya";
    String lastName = "Garbaruk";
    String email = "test@email.com";
    String userNumber = "1234567890";
    String gender = "Female";
    String yearValue = "2001";
    String monthValue = "May";
    String dayValue = "04";
    String subject = "English";
    String hobby = "Reading";
    File photo = new File("src/test/resources/profile_photo.jpg");
    String photoName = "profile_photo.jpg";
    String currentAddress = "2134 Willison Street";
    String state = "NCR";
    String city = "Delhi";

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void submitCompletedFormSuccessfullyTest() {
        registrationPage.openRegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGenderField(gender)
                .setPhoneNumberField(userNumber)
                .setBirthDate(yearValue, monthValue, dayValue)
                .setSubjectField(subject)
                .setHobbyField(hobby)
                .uploadProfilePicture(photo)

                .closeBan()
                .setAddressField(currentAddress, state, city)

                .clickSubmitButton()

                .checkModalWindowAppears()
                .checkStudentDataWithSetValue(firstName, lastName, email, userNumber, gender, dayValue,
                        monthValue, yearValue, subject, hobby, photoName, currentAddress, state, city);
    }
}
