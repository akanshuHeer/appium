package com.fitsetappium.serenity.cucumber.features.utils;

public class TestDataSetup {
    public static String getCredits() {
        return credits;
    }

    public static void setCredits(String credits) {
        TestDataSetup.credits = credits;
    }

    private static String credits;
    private static String studioName;
    private static int classLen;
    public static int getClassLen() {
        return classLen;
    }

    public static void setClassLen(int classLen) {
        TestDataSetup.classLen = classLen;
    }

    public static String getStudioName() {
        return studioName;
    }

    public static void setStudioName(String studioName) {
        TestDataSetup.studioName = studioName;
    }

}
