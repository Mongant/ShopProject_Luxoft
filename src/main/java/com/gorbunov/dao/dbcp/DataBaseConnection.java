package com.gorbunov.dao.dbcp;

import java.sql.*;

public class DataBaseConnection {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    boolean resultConnection;
    boolean resultStatement;

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/Workspace/ShopProject_Luxoft/src/main/resources/DB_Shop";
    private static final String USER = "sa";
    private static final String PASS = "";

    private Connection getConnection() {
        try {
            if(connection == null) {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            }
        } catch (ClassNotFoundException e) {
            System.err.println( "ERROR: Class not found: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private Statement getStatement() {
        try {
            if(statement == null) {
                statement = getConnection().createStatement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public void sqlStatement(String strStatement) {
        try {
            getStatement().execute(strStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getResultSet(String sql) {
        try {
            resultSet = getStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void sqlUpdate(String sql) {
        try {
            getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private boolean validConnection(Connection connection) {
        try {
            resultConnection = connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultConnection;
    }

    private void closeConnection(Connection connection) {
        try {
            if (validConnection(connection)) {
            } else {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean validStatement(Statement statement) {
        try {
            resultStatement = statement.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultStatement;
    }

    private void closeStatement(Statement statement) {
        if (validStatement(statement)) {
        } else {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeDataBaseConnection() {
        closeStatement(statement);
        closeConnection(connection);
    }
}
