package com.gorbunov.dao;

import com.gorbunov.domain.Client;

import java.util.List;

public interface ClientDao {

    void addClient(Client client);
    List<Client>clientList();
    boolean modifyClient(long id);
    void deleteClient(long id);
}
