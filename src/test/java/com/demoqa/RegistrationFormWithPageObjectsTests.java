package com.demoqa;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;

import static com.demoqa.utils.RandomUtils.*;


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


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserPhone(phone)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setFiles(file.getName())
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickButton();

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

    }
}
