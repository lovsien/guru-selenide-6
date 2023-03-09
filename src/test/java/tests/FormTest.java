package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Tanya";
    String lastName = "Garbaruk";
    String email = "test@email.com";
    String userNumber = "1234567890";
    String gender = "Female";
    String yearValue = "2000";
    String monthValue = "May";
    String dayValue = "04";
    String subject = "English";
    String hobby = "Reading";
    File photo = new File("src/test/resources/profile_photo.jpg");
    String photoName = "profile_photo.jpg";
    String currentAddress = "2134 Willison Street";
    String state = "NCR";
    String city = "Delhi";

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void submitCompletedFormSuccessfullyTest() {
        registrationPage.openRegistrationPage();

        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.setGenderField(gender);
        registrationPage.setPhoneNumberField(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue(yearValue);
        $(".react-datepicker__month-select").selectOptionContainingText(monthValue);
        $(".react-datepicker__day--0" + dayValue + ":not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText(hobby)).click();
        $("#uploadPicture").uploadFile(photo);

        $("#currentAddress").setValue(currentAddress);
        $("#state").scrollTo();
        $(byText("Select State")).click();
        $(byText(state)).click();

        $(byText("Select City")).click();
        $(byText(city)).click();

//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('footer').remove()");

        $("#submit").shouldBe(visible).click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']/following-sibling::*").shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']/following-sibling::*").shouldHave(text(email));
        $x("//td[text()='Gender']/following-sibling::*").shouldHave(text(gender));
        $x("//td[text()='Mobile']/following-sibling::*").shouldHave(text(userNumber));
        $x("//td[text()='Date of Birth']/following-sibling::*").shouldHave(text(dayValue + " " + monthValue + "," + yearValue));
        $x("//td[text()='Subjects']/following-sibling::*").shouldHave(text(subject));
        $x("//td[text()='Hobbies']/following-sibling::*").shouldHave(text(hobby));
        $x("//td[text()='Picture']/following-sibling::*").shouldHave(text(photoName));
        $x("//td[text()='Address']/following-sibling::*").shouldHave(text(currentAddress));
        $x("//td[text()='State and City']/following-sibling::*").shouldHave(text(state + " " + city));
    }
}
