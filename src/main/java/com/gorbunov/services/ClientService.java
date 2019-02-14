package com.gorbunov.services;

public interface ClientService {

    /**
     * Method to create data client
     * */
    void createClient(String name, String surname, String phone);

    /**
     * Method for modify data client by id
     * */
    void modifyClient(long id);

    /**
     * Method for delete data client by id
     * */
    void deleteClient(long id);
}
