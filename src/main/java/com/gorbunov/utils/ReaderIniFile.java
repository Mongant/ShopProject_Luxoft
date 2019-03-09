package com.gorbunov.utils;

import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;

public class ReaderIniFile {

    private static final String INI_FILE_PATH = "src/main/resources/SQL.ini";

    public static String iniReader(String category, String operation) {
        String sql = "";
        try {
            Ini ini = new Ini(new File(INI_FILE_PATH));
            sql = ini.get(category, operation);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sql;
    }
}


