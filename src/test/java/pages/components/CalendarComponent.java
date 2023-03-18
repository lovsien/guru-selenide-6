package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement yearDatePicker = $(".react-datepicker__year-select");
    private final SelenideElement monthDatePicker = $(".react-datepicker__month-select");

    public void setDate(String year, String month, String day) {
        yearDatePicker.selectOptionByValue(year);
        monthDatePicker.selectOptionContainingText(month);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
    }
}
