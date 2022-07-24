package utils;

import java.util.Random;

public class RandomGenerator {
    public static String randomGender() {

        String[] gender = {"Other", "Male", "Female"};
        String random = (gender[new Random().nextInt(gender.length)]);
        return random;
    }

    public static String randomHobby() {

        String[] hobby = {"Sports", "Reading", "Music"};
        String random = (hobby[new Random().nextInt(hobby.length)]);
        return random;
    }

    public static String randomMonths() {

        String[] month = {"December", "October", "January", "June", "July", "September", "November", "February"};
        String random = (month[new Random().nextInt(month.length)]);
        return random;
    }

    public static String randomSubject() {

        String[] subj = {"English", "German", "Biology", "Hindi", "Chemistry", "Civics", "Maths"};
        String random = (subj[new Random().nextInt(subj.length)]);
        return random;
    }

    public static String randomFile() {

        String[] file = {"1.png", "2.png", "3.png"};
        String random = (file[new Random().nextInt(file.length)]);
        return random;
    }
}