package com.demoqa;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;

import static com.demoqa.utils.RandomUtils.*;
import static io.qameta.allure.Allure.step;


public class RegistrationFormWithPageObjectsTests extends TestBase {

    @Test
    void practiceFormNewTest() {
        Faker faker = new Faker(new Locale("en-US"));
        File file = new File("src/test/resources/exampleFile.jpg");

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                gender = getRandomFromArray(gendersArray),
                phone = faker.phoneNumber().subscriberNumber(10),
                birthDay = generateDate()[0],
                birthMonth = generateDate()[1],
                birthYear = generateDate()[2],
                subjects = getRandomFromArray(subjectsArray),
                hobbies = getRandomFromArray(hobbiesArray),
                address = faker.address().fullAddress(),
                state = resultStateAndCity[0],
                city = resultStateAndCity[1];

        step("Open Practice Form", () -> {
            registrationPage.openPage();
        });
        step("Enter first name and last name", () -> {
            registrationPage.setFirstName(firstName);
            registrationPage.setLastName(lastName);
        });
        step("Enter user email", () -> {
            registrationPage.setUserEmail(userEmail);
        });
        step("Choose gender", () -> {
            registrationPage.setGender(gender);
        });
        step("Enter user phone", () -> {
            registrationPage.setUserPhone(phone);
        });
        step("Enter birthday", () -> {
            registrationPage.setBirthDate(birthDay, birthMonth, birthYear);
        });
        step("Enter subjects", () -> {
            registrationPage.setSubjects(subjects);
        });
        step("Enter hobbies", () -> {
            registrationPage.setHobbies(hobbies);
        });
        step("Upload photo", () -> {
            registrationPage.setFiles(file.getName());
        });
        step("Enter address", () -> {
            registrationPage.setAddress(address);
        });
        step("Choose state and city", () -> {
            registrationPage.setState(state);
            registrationPage.setCity(city);
        });
        step("Click button Submit", () -> {
            registrationPage.clickButton();
        });

        step("Check result registration", () -> {
            registrationPage.verifyResultModalAppears()
                    .verifyTable("Student Name", firstName + " " + lastName)
                    .verifyTable("Student Email", userEmail)
                    .verifyTable("Gender", gender)
                    .verifyTable("Mobile", phone)
                    .verifyTable("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                    .verifyTable("Subjects", subjects)
                    .verifyTable("Hobbies", hobbies)
                    .verifyTable("Picture", file.getName())
                    .verifyTable("Address", address)
                    .verifyTable("State and City", state + " " + city);
        });

    }
}
