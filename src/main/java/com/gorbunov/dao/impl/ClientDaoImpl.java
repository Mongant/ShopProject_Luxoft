package com.gorbunov.dao.impl;

import com.gorbunov.dao.ClientDao;
import com.gorbunov.dao.dbcp.DataBaseConnection;
import com.gorbunov.domain.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDaoImpl implements ClientDao {

    private long clientId;
    private String clientName;
    private String clientSurname;
    private int clientAge;
    private String clientPhone;
    private String clientEmail;

    DataBaseConnection dbConnection = new DataBaseConnection();
    private Map<Long, Client> clients = new HashMap<>();
    private static ClientDao clientDao = new ClientDaoImpl();

    private ClientDaoImpl() {
    }

    public static ClientDao getInstance() {
        if (clientDao == null) {
            clientDao = new ClientDaoImpl();
        }
        return clientDao;
    }

    @Override
    public void addClient(Client client) {
            String sql = "insert into SHOP.CLIENT(NAME, SURNAME, AGE, PHONE_NUM, EMAIL) " +
                        "values ('" + client.getName() + "', '" + client.getSurname() + "', " + client.getAge() + ", '" + client.getPhone() + "', '" + client.getEmail() + "');" ;
            dbConnection.sqlStatement(sql);
            dbConnection.closeDataBaseConnection();
    }

    @Override
    public Client getClient(long id) {
        Client client = null;
        try {
            String sql = "select ID, NAME, SURNAME, AGE, PHONE_NUM, EMAIL\n" +
                    "from SHOP.CLIENT\n" +
                    "where ID = " + id + ";";
            ResultSet resultSet = dbConnection.getResultSet(sql);
            while (resultSet.next()) {
                clientId = resultSet.getInt(1);
                clientName = resultSet.getString(2);
                clientSurname = resultSet.getString(3);
                clientAge = resultSet.getInt(4);
                clientPhone = resultSet.getString(5);
                clientEmail = resultSet.getString(6);
                client = new Client(clientId, clientName, clientSurname, clientAge, clientPhone, clientEmail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public List<Client> clientList() {
        List<Client> clientsList = new ArrayList<>();

        try {
            String sql = "select * from SHOP.CLIENT";
            ResultSet resultSet = dbConnection.getResultSet(sql);
            while(resultSet.next()) {
                clientId = resultSet.getLong(1);
                clientName = resultSet.getString(2);
                clientSurname = resultSet.getString(3);
                clientAge = resultSet.getInt(4);
                clientPhone = resultSet.getString(5);
                clientEmail = resultSet.getString(6);

                Client client = new Client(clientId, clientName, clientSurname, clientAge, clientPhone, clientEmail);
                clientsList.add(client);
            }
//            dbConnection.closeDataBaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientsList;
    }

    @Override
    public void updateClient(long id, Client client) {
        String sql = "update SHOP.CLIENT" +
                     "\nset NAME = '" + client.getName() + "', SURNAME = '" + client.getSurname() + "', AGE = " + client.getAge() + ", PHONE_NUM = '" + client.getPhone() + "', EMAIL = '" + client.getEmail() +
                     "' \nwhere ID = " + id + ";";
        dbConnection.sqlUpdate(sql);
        dbConnection.closeDataBaseConnection();
    }

    @Override
    public void deleteClient(long id) {
        String sql = "delete from SHOP.CLIENT where ID = " + id + ";";
        dbConnection.sqlStatement(sql);
    }

    @Override
    public boolean duplicatePhone(String phone) {
        boolean duplicatePhone = false;
        for(Map.Entry<Long, Client> pair : clients.entrySet()) {
            if(phone.equals(pair.getValue().getPhone())) {
                duplicatePhone = true;
                break;
            } else {
                duplicatePhone = false;
            }
        }
        return duplicatePhone;
    }
}