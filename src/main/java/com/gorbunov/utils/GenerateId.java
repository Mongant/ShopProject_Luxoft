package com.gorbunov.utils;

import java.util.Date;

public class GenerateId {

    private static String result;

    public static String generateId() {
        result = Long.toHexString(new Date().getTime());
        return result;
    }

    public static String getResult() {
        return result;
    }
}
