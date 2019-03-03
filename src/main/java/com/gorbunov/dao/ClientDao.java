package com.gorbunov.dao;

import com.gorbunov.domain.Client;

import java.util.List;

public interface ClientDao {

    void addClient(Client client);
    Client getClient(long id);
    List<Client> clientList();
    void updateClient(long id, Client client);
    void deleteClient(long id);
    boolean duplicatePhone(String phone);

}
