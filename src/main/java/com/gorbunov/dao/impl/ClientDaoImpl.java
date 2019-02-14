package com.gorbunov.dao.impl;

import com.gorbunov.dao.ClientDao;
import com.gorbunov.domain.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    static List<Client> clients = new ArrayList<>();

    @Override
    public List<Client> clientsList(Client client) {
        clients.add(client);
        return clients;
    }

    @Override
    public boolean modifyClient(long id) {
        return true;
    }

    @Override
    public boolean deleteClient(long id) {
        return true;
    }
}