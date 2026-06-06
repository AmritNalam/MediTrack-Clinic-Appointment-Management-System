package com.airtribe.meditrack.util;

public class Validator {

    public static boolean isValidName(String name){
        return name != null && !name.isEmpty();
    }
}