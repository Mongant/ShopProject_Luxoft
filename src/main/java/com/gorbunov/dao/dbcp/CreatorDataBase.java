package com.gorbunov.dao.dbcp;

import com.gorbunov.utils.ReaderIniFile;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatorDataBase {

    DataBaseConnection dataBaseConnection = new DataBaseConnection();

    public void createDataBaseStructure() {
        try(Connection connection = dataBaseConnection.getConnection();
            Statement statement = dataBaseConnection.getStatement(connection)) {
            statement.execute(ReaderIniFile.iniReader("Schema", "CREATE_SCHEMA"));
            statement.execute(ReaderIniFile.iniReader("Table", "CREATE_CLIENT_TABLE"));
            statement.execute(ReaderIniFile.iniReader("Table", "CREATE_PRODUCT_TABLE"));
            statement.execute(ReaderIniFile.iniReader("Table", "CREATE_PRODUCT_CONTAINER_TABLE"));
            statement.execute(ReaderIniFile.iniReader("Table", "CREATE_ORDER_TABLE"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
