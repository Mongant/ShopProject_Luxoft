package com.gorbunov.dao.dbcp;

import java.sql.*;

public class DataBaseConnection {

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/Workspace/ShopProject_Luxoft/src/main/resources/DB_Shop";
    private static final String USER = "sa";
    private static final String PASS = "";

    public Connection getConnection() {
        Connection connection = null;
        try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: Class not found: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Statement getStatement(Connection connection) {
        Statement statement = null;
        try {
                statement = connection.createStatement();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
