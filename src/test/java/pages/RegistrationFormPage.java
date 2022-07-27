package pages;

import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    public CalendarComponent calendarComponent=new CalendarComponent();
    public ResultTableComponent resultTableComponent=new ResultTableComponent();

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
    public RegistrationFormPage setFirstName(String value){
        $("#firstName").setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName (String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail (String value){
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrationFormPage setTel (String value){
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationFormPage setSubjects (String value){
        $("#subjectsInput").sendKeys(value);
        $("#subjectsInput").pressEnter();
        return this;
    }

    public RegistrationFormPage setAdress(String value){
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value){
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setHobbie(String value){
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setState(String value){
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value){
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.SetDate(day, month, year);
        return this;
    }
    public RegistrationFormPage setFilename(String value){
        $("#uploadPicture").uploadFromClasspath("img/src/test/resources/img/1.png/");
        return this;
    }
    public RegistrationFormPage checkResult (String key, String value) {
        resultTableComponent.checkResult(key,value);
        return this;
    }
    public RegistrationFormPage clickSubmit () {
        $("#submit").click();
        return this;
    }
    public RegistrationFormPage checkSubmitting (){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }
}