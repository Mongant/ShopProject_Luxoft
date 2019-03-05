package com.gorbunov.dao;

import com.gorbunov.domain.Client;

import java.util.List;

public interface ClientDao {

    /**
     * Add client to database
     * @param client information about client
     * */
    void addClient(Client client);

    /**
     * Get client information by id in database
     * @param id customer unique identifier
     * */
    Client getClient(long id);
    List<Client> clientList();
    void updateClient(long id, Client client);
    void deleteClient(long id);
    boolean duplicatePhone(String phone);

}
