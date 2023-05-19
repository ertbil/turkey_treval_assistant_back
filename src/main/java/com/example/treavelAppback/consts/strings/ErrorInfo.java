package com.example.treavelAppback.consts.strings;

public class ErrorInfo {

    public final  static String idTaken = "Id is already taken";

    public final static String userNotFound = "User not found";

    public  final static String tokenExpired = "Token expired";

    public final static String inValidToken = "Invalid token";

    public  static String placeDoesNotExist(String s) {
        return "place with id " + s + " does not exist";

    }
    public static String userDoesNotExist(String s) {
        return "user with id " + s + " does not exist";

    }
}
