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

    /**
     * Get information about clients in database
     * */
    List<Client>clientList();

    /**
     * Modify data client by id in database
     * @param id customer unique identifier
     * @param client information about client
     * */
    boolean modifyClient(long id, Client client);

    /**
     * Delete data client by id in database
     * @param id customer unique identifier
     * */
    boolean deleteClient(long id);

    /**
     * Checks the number for repetitions in database
     * @param phone client phone number
     * */
    boolean duplicatePhone(String phone);

}
