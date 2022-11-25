package com.demoqa.utils;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String[][] stateAndCity = {{"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
            {"Delhi", "Gurgaon", "Noida"},
            {"Agra", "Lucknow", "Merrut"},
            {"Karnal", "Panipat"},
            {"Jaipur", "Jaiselmer"}};
    public static String[] gendersArray = {"Male", "Female", "Other"},
            hobbiesArray = {"Sports", "Reading", "Music"},
            subjectsArray = {"Maths", "Accounting", "Arts", "Social Studies", "Biology", "Physics",
                    "Chemistry", "Computer Science", "Commerce", "Economics", "Civics",
                    "Hindi", "English", "History",},
            resultStateAndCity = getRandomFromTwiceArray(stateAndCity);

    public static void main(String[] args) {
        System.out.println(resultStateAndCity[0] + " " + resultStateAndCity[1]);
    }

    public static String patternDate = "dd MMMM yyyy";

    public static String getRandomFromArray(String[] array) {
        return array[(int) (Math.random() * (array.length - 1))];
    }

    public static String[] getRandomFromTwiceArray(String[][] array) {
        String state = array[0][(int) (Math.random() * (array.length - 1))];
        String city = array[Arrays.asList(array[0]).indexOf(state) + 1]
                [(int) (Math.random() * (array[Arrays.asList(array[0]).indexOf(state) + 1].length - 1))];
        String[] result = {state, city};
        return result;
    }


    public static String[] generateDate() {
        int day = ThreadLocalRandom.current().nextInt(1, 32);
        int month = ThreadLocalRandom.current().nextInt(1, 12);
        int year = ThreadLocalRandom.current().nextInt(1900, 2022);
        return new SimpleDateFormat(patternDate, Locale.ENGLISH)
                .format(new GregorianCalendar(year, month, day).getTime()).split("\\s");
    }
}
