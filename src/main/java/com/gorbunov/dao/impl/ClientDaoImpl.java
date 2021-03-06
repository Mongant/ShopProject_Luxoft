package com.gorbunov.dao.impl;

import com.gorbunov.dao.ClientDao;
import com.gorbunov.domain.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    @Override
    public List<Client> clientsList(Client client) {
        List<Client> clients = new ArrayList<>();
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
