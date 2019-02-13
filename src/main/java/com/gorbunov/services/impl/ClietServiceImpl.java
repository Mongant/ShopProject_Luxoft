package com.gorbunov.services.impl;

import com.gorbunov.dao.ClientDao;
import com.gorbunov.dao.impl.ClientDaoImpl;
import com.gorbunov.domain.Client;
import com.gorbunov.services.ClientService;

public class ClietServiceImpl implements ClientService {

    private ClientDao clientDao = new ClientDaoImpl();

    /**
     * Java doc
     * add documentation
     **/
    @Override
    public void createClient(String name, String phone, String surname) {
        Client client = new Client(name,surname, phone);
        clientDao.clientsList(client);
    }

    @Override
    public void modifyClient(long id) {
        if(clientDao.modifyClient(id)) {
            System.out.println("Add some changes in client");
        } else {
            System.out.println("Something was wrong!");
        }
    }

    @Override
    public void deleteClient(long id) {
        if(clientDao.deleteClient(id)) {
            System.out.println("Client on id: " + id + " was removed!");
        } else {
            System.out.println("Something was wrong!");
        }
    }
}
