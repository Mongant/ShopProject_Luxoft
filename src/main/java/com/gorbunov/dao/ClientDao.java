package com.gorbunov.dao;

import com.gorbunov.domain.Client;

import java.util.List;

public interface ClientDao {

    void addClient(Client client);
    Client getClient(long id);
    List<Client>clientList();
    boolean modifyClient(long id, Client client);
    boolean deleteClient(long id);
    boolean duplicatePhone(String phone);

}
