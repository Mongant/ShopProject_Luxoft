package com.gorbunov.dao.dbcp;

import com.gorbunov.utils.ReaderIniFile;

public class CreatorDataBase {

    DataBaseConnection dataBaseConnection = new DataBaseConnection();

    public void createDataBaseStructure() {
        dataBaseConnection.sqlExecute(ReaderIniFile.iniReader("Schema", "CREATE_SCHEMA"));
        dataBaseConnection.sqlExecute(ReaderIniFile.iniReader("Table", "CREATE_CLIENT_TABLE"));
        dataBaseConnection.sqlExecute(ReaderIniFile.iniReader("Table", "CREATE_PRODUCT_TABLE"));
        dataBaseConnection.sqlExecute(ReaderIniFile.iniReader("Table", "CREATE_PRODUCT_CONTAINER_TABLE"));
        dataBaseConnection.sqlExecute(ReaderIniFile.iniReader("Table", "CREATE_ORDER_TABLE"));
    }
}
