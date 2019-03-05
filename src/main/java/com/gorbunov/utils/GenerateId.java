package com.gorbunov.utils;

import java.util.Date;

public class GenerateId {

    public static String generateId() {
        String result;
        result = Long.toHexString(new Date().getTime());
        return result;
    }
}
