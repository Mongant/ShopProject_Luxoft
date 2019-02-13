package com.gorbunov.dao;

import com.gorbunov.domain.Client;

import java.util.List;

public interface ClientDao {

    List<Client> clientsList(Client client);
    boolean modifyClient(long id);
    boolean deleteClient(long id);
}
