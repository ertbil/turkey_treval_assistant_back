package com.example.treavelAppback.consts.strings;

public class Paths {
    public static final String mainPath = "/api/v1";
    public static final String authPath = mainPath + "/auth";
    public static final String placesPath = mainPath + "/places";
    public static final String placeID = "{placeId}";
    public static final String registerPath = authPath + "/register";
    public static final String authenticatePath = authPath + "/authenticate";

    public static final String[] whiteListedRoutes = new String[]{
            placesPath + "/**",
            registerPath,
            authenticatePath
    };

}
