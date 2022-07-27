package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {



    @Test
    @Tag("test6")
    void someTest6() {
            String browser = System.getProperty("browser", "chrome");
            String version = System.getProperty("version", "101");
            String resolution = System.getProperty("browserSize", "1920x1080");
        }
//        System.out.println(browser); //
//        System.out.println(version); //
//        System.out.println(browserSize); //

        /*
            From idea
                chrome
                101
                1920x1080

            gradle clean properties_test6
                chrome
                101
                1920x1080

            gradle clean properties_test6 -Dbrowser=opera
                opera
                101
                1920x1080

            gradle clean properties_test6 -Dbrowser=opera -Dversion=102
                opera
                102
                1920x1080
         */
    }
//
//    @Test
//    @Tag("hello")
//    void someTest7() {
//        System.out.println("Hello " + System.getProperty("anyText"));

        // gradle clean hello_test -DanyText=world!
        //     Hello world!

