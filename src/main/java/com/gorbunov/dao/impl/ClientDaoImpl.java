package com.gorbunov.dao.impl;

import com.gorbunov.dao.ClientDao;
import com.gorbunov.domain.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDaoImpl implements ClientDao {

    private Map<Long, Client> clients = new HashMap<>();
    private static long generatorId = 0;
    private static ClientDao clientDao = new ClientDaoImpl();

    private ClientDaoImpl() {
    }

    public static ClientDao getInstance() {
        if(clientDao == null) {
            clientDao = new ClientDaoImpl();
        }
        return clientDao;
    }

    @Override
    public void addClient(Client client) {
        client.setId(generatorId++);
        clients.put(client.getId(), client);
    }

    @Override
    public List<Client> clientList() {
        return new ArrayList<>(clients.values());
    }

    @Override
    public boolean modifyClient(long id) {
        return true;
    }

    @Override
    public void deleteClient(long id) {
        clients.remove(id);
    }
}