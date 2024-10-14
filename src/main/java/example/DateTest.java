package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateTest {
    public static void main(String[] args) {
//        printLocalDateTest();
//        printLocalDateNowTest();
        printLocalDateFormatTest();

        // get now
        // add dates / hours minutes
        // add / remove dates / hours minutes
        // compare dates
        // parse
        // since Epoch
        // UTC

    }

    private static void printLocalDateFormatTest() {
        String date = "2017:01:01:23:59:59";

        LocalDate lt = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm:ss"));

    }

    private static void printLocalDateNowTest() {

        // create an LocalDate object
        LocalDate lt
                = LocalDate.now();

        // print result
        System.out.println("LocalDate : "
                + lt);
    }

    private static void printLocalDateTest() {
        LocalDate lt = LocalDate.parse("2018-12-27");
        System.out.println("LocalDate : " + lt);
    }
}
