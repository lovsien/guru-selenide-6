package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalWindowComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    ModalWindowComponent modalComponent = new ModalWindowComponent();
    static final String registrationHeader = "Student Registration Form";
    static final String submittingFormText = "Thanks for submitting the form";
    private final SelenideElement h5Header = $("div.practice-form-wrapper h5");
    private final SelenideElement titleModalWindow = $("#example-modal-sizes-title-lg");
    private final SelenideElement firstNameField = $("#firstName");
    private final SelenideElement lastNameField = $("#lastName");
    private final SelenideElement emailField = $("#userEmail");
    private final SelenideElement phoneNumberField = $("#userNumber");
    private final SelenideElement datePicker = $("#dateOfBirthInput");
    private final SelenideElement subjectField = $("#subjectsInput");
    private final SelenideElement uploadPictureButton = $("#uploadPicture");
    private final SelenideElement currentAddressField = $("#currentAddress");
    private final SelenideElement stateField = $(byText("Select State"));
    private final SelenideElement cityField = $(byText("Select City"));
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement modalWindow = $(".modal-dialog");
    private final SelenideElement studentNameField = $x("//td[text()='Student Name']/following-sibling::*");
    private final SelenideElement studentEmailField = $x("//td[text()='Student Email']/following-sibling::*");
    private final SelenideElement studentGenderField = $x("//td[text()='Gender']/following-sibling::*");
    private final SelenideElement studentMobileField = $x("//td[text()='Mobile']/following-sibling::*");
    private final SelenideElement studentBirthDateField = $x("//td[text()='Date of Birth']/following-sibling::*");
    private final SelenideElement studentSubjectsField = $x("//td[text()='Subjects']/following-sibling::*");
    private final SelenideElement studentHobbiesField = $x("//td[text()='Hobbies']/following-sibling::*");
    private final SelenideElement studentPictureNameField = $x("//td[text()='Picture']/following-sibling::*");
    private final SelenideElement studentAddressField = $x("//td[text()='Address']/following-sibling::*");
    private final SelenideElement studentStateAndCityField = $x("//td[text()='State and City']/following-sibling::*");

    public RegistrationPage openRegistrationPage() {
        open("/automation-practice-form");
        h5Header.shouldHave(text(registrationHeader));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameField.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameField.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    public RegistrationPage setPhoneNumberField(String phoneNumber) {
        phoneNumberField.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage setGenderField(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationPage setBirthDate(String year, String month, String day) {
        datePicker.click();
        calendarComponent.setDate(year, month, day);
        return this;
    }

    public RegistrationPage setSubjectField(String subject) {
        subjectField.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbyField(String hobby) {
        $(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadProfilePicture(File photo) {
        uploadPictureButton.uploadFile(photo);
        return this;
    }

    public RegistrationPage setAddressField(String addressField, String state, String city) {
        currentAddressField.setValue(addressField);

        stateField.click();
        $(byText(state)).click();

        cityField.click();
        $(byText(city)).click();

        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.shouldBe(visible).click();
        return this;
    }

    public RegistrationPage checkModalWindowAppears() {
        modalWindow.should(appear);
        titleModalWindow.shouldHave(text(submittingFormText));
        return this;
    }

    public RegistrationPage checkStudentDataWithSetValue(String firstName, String lastName, String email, String userNumber,
                                                         String gender, String day, String month, String year, String subject,
                                                         String hobby, String photoName, String currentAddress, String state,
                                                         String city) {
        modalComponent.checkStudentNameFieldContainsSetValue(firstName, lastName);
        modalComponent.checkStudentEmailFieldContainsSetValue(email);
        modalComponent.checkStudentGenderFieldContainsSetValue(gender);
        modalComponent.checkStudentNumberFieldContainsSetValue(userNumber);
        modalComponent.checkStudentBirthDateFieldContainsSetValue(day, month, year);
        modalComponent.checkStudentSubjectsFieldContainsSetValue(subject);
        modalComponent.checkStudentHobbiesFieldContainsSetValue(hobby);
        modalComponent.checkStudentPictureNameFieldContainsSetValue(photoName);
        modalComponent.checkStudentCurrentAddressFieldContainsSetValue(currentAddress);
        modalComponent.checkStudentCurrentAddressFieldContainsSetValue(state, city);

        return this;
    }

    public RegistrationPage closeBan() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
}
