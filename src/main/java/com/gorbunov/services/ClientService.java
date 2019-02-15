package com.gorbunov.services;

import com.gorbunov.domain.Client;

import java.util.List;

public interface ClientService {

    /**
     * Method to create data client
     * @param name sets the client name
     * @param surname sets the client surname
     * @param phone sets the client phone
     * */
    void createClient(String name, String surname, String phone);

    /**
     * Method for modify data client by id
     * @param id customer unique identifier
     * */
    void modifyClient(long id);

    /**
     * Method for delete data client by id
     * @param id customer unique identifier
     * */
    void deleteClient(long id);

    /**
     * Method return clients list
     * */
    List<Client> listClients();
}
