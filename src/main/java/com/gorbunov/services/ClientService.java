package com.gorbunov.services;

public interface ClientService {

    void createClient(String name, String surname, String phone);
    void modifyClient(long id);
    void deleteClient(long id);
}
