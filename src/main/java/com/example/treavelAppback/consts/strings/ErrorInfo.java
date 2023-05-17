package com.example.treavelAppback.consts.strings;

public class ErrorInfo {

    public final  static String idTaken = "Id is already taken";

    public  static String placeDoesNotExist(String s) {
        return "place with id " + s + " does not exist";

    }
    public static String userDoesNotExist(String s) {
        return "user with id " + s + " does not exist";

    }
}
