package tests.demoQA;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static tests.demoQA.TestData.*;

public class RegistrationFormTest extends TestBase {

    @Test
    @Tag("owner")
    void successfulTest() {

        step("Open registrations form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill form", () -> {
            registrationFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setTel(tel)
                    .setSubjects(subject)
                    .setAdress(adress)
                    .setGender(gender)
                    .setState(state)
                    .setCity(city)
                    .setDateOfBirth(date, month, year)
                    .setFilename(fileName)
                    .setHobbie(hobbie)
                    .clickSubmit();
        });

        step("Check results", () -> {
            registrationFormPage
                    .checkSubmitting()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Mobile", tel)
                    .checkResult("Gender", gender)
                    .checkResult("Date of Birth", date + " " + month + "," + year)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobbie)
                    .checkResult("Picture", fileName)
                    .checkResult("Address", adress)
                    .checkResult("State and City", state + " " + city);

        });
    }
}