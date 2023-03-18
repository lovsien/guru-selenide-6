package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    static final String registrationHeader = "Student Registration Form";
    static final String submittingFormText = "Thanks for submitting the form";
    private final SelenideElement h5Header = $("div.practice-form-wrapper h5");
    private final SelenideElement titleModalWindow = $("#example-modal-sizes-title-lg");
    private final SelenideElement firstNameField = $("#firstName");
    private final SelenideElement lastNameField = $("#lastName");
    private final SelenideElement emailField = $("#userEmail");
    private final SelenideElement phoneNumberField = $("#userNumber");
    private final SelenideElement datePicker = $("#dateOfBirthInput");
    private final SelenideElement yearDatePicker = $(".react-datepicker__year-select");
    private final SelenideElement monthDatePicker = $(".react-datepicker__month-select");
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
        yearDatePicker.selectOptionByValue(year);
        monthDatePicker.selectOptionContainingText(month);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

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

    public RegistrationPage checkStudentNameFieldContainsSetValue(String firstName, String lastName) {
        studentNameField.shouldHave(text(firstName + " " + lastName));
        return this;
    }

    public RegistrationPage checkStudentEmailFieldContainsSetValue(String email) {
        studentEmailField.shouldHave(text(email));
        return this;
    }

    public RegistrationPage checkStudentGenderFieldContainsSetValue(String gender) {
        studentGenderField.shouldHave(text(gender));
        return this;
    }

    public RegistrationPage checkStudentNumberFieldContainsSetValue(String userNumber) {
        studentMobileField.shouldHave(text(userNumber));
        return this;
    }

    public RegistrationPage checkStudentBirthDateFieldContainsSetValue(String day, String month, String year) {
        studentBirthDateField.shouldHave(text(day + " " + month + "," + year));
        return this;
    }

    public RegistrationPage checkStudentSubjectsFieldContainsSetValue(String subject) {
        studentSubjectsField.shouldHave(text(subject));
        return this;
    }

    public RegistrationPage checkStudentHobbiesFieldContainsSetValue(String hobby) {
        studentHobbiesField.shouldHave(text(hobby));
        return this;
    }

    public RegistrationPage checkStudentPictureNameFieldContainsSetValue(String photoName) {
        studentPictureNameField.shouldHave(text(photoName));
        return this;
    }

    public RegistrationPage checkStudentCurrentAddressFieldContainsSetValue(String currentAddress) {
        studentAddressField.shouldHave(text(currentAddress));
        return this;
    }

    public RegistrationPage checkStudentCurrentAddressFieldContainsSetValue(String state, String city) {
        studentStateAndCityField.shouldHave(text(state + " " + city));
        return this;
    }

    public RegistrationPage checkStudentDataWithSetValue(String firstName, String lastName, String email, String userNumber,
                                             String gender, String day, String month, String year, String subject,
                                             String hobby, String photoName, String currentAddress, String state,
                                             String city) {
        checkStudentNameFieldContainsSetValue(firstName, lastName);
        checkStudentEmailFieldContainsSetValue(email);
        checkStudentGenderFieldContainsSetValue(gender);
        checkStudentNumberFieldContainsSetValue(userNumber);
        checkStudentBirthDateFieldContainsSetValue(day, month, year);
        checkStudentSubjectsFieldContainsSetValue(subject);
        checkStudentHobbiesFieldContainsSetValue(hobby);
        checkStudentPictureNameFieldContainsSetValue(photoName);
        checkStudentCurrentAddressFieldContainsSetValue(currentAddress);
        checkStudentCurrentAddressFieldContainsSetValue(state, city);

        return this;
    }

    public RegistrationPage closeBan() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
}
