package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    static final String registrationHeader = "Student Registration Form";
    private final SelenideElement h5Header = $("div.practice-form-wrapper h5");
    private final SelenideElement firstNameField = $("#firstName");
    private final SelenideElement lastNameField = $("#lastName");
    private final SelenideElement emailField = $("#userEmail");
    private final SelenideElement phoneNumberField = $("#userNumber");

    public void openRegistrationPage() {
        String formURL = "/automation-practice-form";
        open(formURL);
        h5Header.shouldHave(text(registrationHeader));
    }

    public void setFirstName(String firstName) {
        firstNameField.setValue(firstName);
    }

    public void setLastName(String lastName) {
        lastNameField.setValue(lastName);
    }

    public void setEmail(String email) {
        emailField.setValue(email);
    }

    public void setPhoneNumberField(String phoneNumber) {
        phoneNumberField.setValue(phoneNumber);
    }

    public void setGenderField(String gender) {
        $(byText(gender)).click();
    }
}
