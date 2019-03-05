package com.gorbunov.dao.dbcp;

import java.sql.*;

public class DataBaseConnection {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/Workspace/ShopProject_Luxoft/src/main/resources/DB_Shop";
    private static final String USER = "sa";
    private static final String PASS = "";

    public Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: Class not found: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void sqlStatement(String strStatement) {
        Statement statement = null;
        try {
            if (statement == null) {
                statement = getConnection().createStatement();
            }
            statement.execute(strStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getResultSet(String sql) {
        try {
            Statement statement = null;
                if (statement == null) {
                    statement = getConnection().createStatement();
                }
                resultSet = statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;
        }

    public void sqlUpdate(String sql) {
        try {
            if (statement == null) {
                statement = getConnection().createStatement();
            }
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void closeDataBaseConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
