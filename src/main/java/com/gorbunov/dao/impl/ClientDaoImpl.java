package com.gorbunov.dao.impl;

import com.gorbunov.dao.ClientDao;
import com.gorbunov.dao.dbcp.DataBaseConnection;
import com.gorbunov.domain.Client;
import com.gorbunov.utils.ReaderIniFile;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDaoImpl implements ClientDao {

    private DataBaseConnection dbConnection = new DataBaseConnection();
    private Map<Long, Client> clients = new HashMap<>();

    private ClientDaoImpl() {
    }

    @Override
    public void addClient(Client client) {
        String sql = ReaderIniFile.iniReader("Client operations", "ADD_NEW_CLIENT");

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setInt(3, client.getAge());
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.setString(5, client.getEmail());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Client getClient(long id) {
        long clientId;
        String clientName;
        String clientSurname;
        int clientAge;
        String clientPhone;
        String clientEmail;

        Client client = null;
        String sql = ReaderIniFile.iniReader("Client operations", "GET_CLIENT");

        try(Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                clientId = resultSet.getInt(1);
                clientName = resultSet.getString(2);
                clientSurname = resultSet.getString(3);
                clientAge = resultSet.getInt(4);
                clientPhone = resultSet.getString(5);
                clientEmail = resultSet.getString(6);
                client = new Client(clientId, clientName, clientSurname, clientAge, clientPhone, clientEmail);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public List<Client> clientList() {
        long clientId;
        String clientName;
        String clientSurname;
        int clientAge;
        String clientPhone;
        String clientEmail;

        List<Client> clientsList = new ArrayList<>();
        String sql = ReaderIniFile.iniReader("Client operations", "CLIENTS_LIST");

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
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
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return clientsList;
    }

    @Override
    public void updateClient(long id, Client client) {
        String sql = ReaderIniFile.iniReader("Client operations", "UPDATE_CLIENT");

        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setInt(3, client.getAge());
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.setString(5, client.getEmail());
            preparedStatement.setLong(6, id);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClient(long id) {
        String sql = ReaderIniFile.iniReader("Client operations", "DELETE_CLIENT");

        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
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