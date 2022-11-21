package com.demoqa;

import org.junit.jupiter.api.Test;


public class RegistrationFormWithPageObjectsTests extends TestBase {

    @Test
    void practiceFormNewTest() {
        String firstName = "Egor",
                lastName = "Dobroskok",
                userEmail = "egor_dobroskok@mail.ru",
                gender = "Male",
                phone = "9379997103",
                birthDay = "21",
                birthMonth = "June",
                birthYear = "1994",
                subjects = "History",
                hobbies = "Music",
                fileName = "exampleFile.jpg",
                address = "Samara, Gagarina street, 35",
                state = "NCR",
                city = "Delhi";


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserPhone(phone)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setFiles(fileName)
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
                .verifyTable("Picture", fileName)
                .verifyTable("Address", address)
                .verifyTable("State and City", state + " " + city);

    }
}
