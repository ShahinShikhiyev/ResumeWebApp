package com.mycompany.resumewebapp.util;

public class ParamUtil {

    public static String get(String value) {
        if (value != null && !value.trim().isEmpty()) {
            return value.trim();
        }
        return null;
    }

    public static Integer parseInt(String value) {
        if (value != null && !value.trim().isEmpty()) {
            try {
                return Integer.parseInt(value.trim());
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }
}