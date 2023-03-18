package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class ModalWindowComponent {
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


    public void checkStudentNameFieldContainsSetValue(String firstName, String lastName) {
        studentNameField.shouldHave(text(firstName + " " + lastName));
    }

    public void checkStudentEmailFieldContainsSetValue(String email) {
        studentEmailField.shouldHave(text(email));
    }

    public void checkStudentGenderFieldContainsSetValue(String gender) {
        studentGenderField.shouldHave(text(gender));
    }

    public void checkStudentNumberFieldContainsSetValue(String userNumber) {
        studentMobileField.shouldHave(text(userNumber));
    }

    public void checkStudentBirthDateFieldContainsSetValue(String day, String month, String year) {
        studentBirthDateField.shouldHave(text(day + " " + month + "," + year));
    }

    public void checkStudentSubjectsFieldContainsSetValue(String subject) {
        studentSubjectsField.shouldHave(text(subject));
    }

    public void checkStudentHobbiesFieldContainsSetValue(String hobby) {
        studentHobbiesField.shouldHave(text(hobby));
    }

    public void checkStudentPictureNameFieldContainsSetValue(String photoName) {
        studentPictureNameField.shouldHave(text(photoName));
    }

    public void checkStudentCurrentAddressFieldContainsSetValue(String currentAddress) {
        studentAddressField.shouldHave(text(currentAddress));
    }

    public void checkStudentCurrentAddressFieldContainsSetValue(String state, String city) {
        studentStateAndCityField.shouldHave(text(state + " " + city));
    }
}
