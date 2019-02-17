package com.gorbunov.services.impl;

import com.gorbunov.dao.ClientDao;
import com.gorbunov.dao.impl.ClientDaoImpl;
import com.gorbunov.domain.Client;
import com.gorbunov.services.ClientService;
import com.gorbunov.validator.BusinessException;
import com.gorbunov.validator.ValidationService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;
    private ValidationService validationService;

    public ClientServiceImpl(ClientDao clientDao, ValidationService validationService) {
        this.clientDao = clientDao;
        this.validationService = validationService;
    }

    @Override
    public void createClient(String name, String phone, String surname) {

            Client client = new Client(name,surname, phone);
            clientDao.addClient(client);


    }

    @Override
    public void createClient(String name, String surname, String phone, int age, String email) {
        try {
        Client client = new Client(name, surname, phone, age, email);
        validationService.validateAge(age);
        clientDao.addClient(client);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyClient(long id) {
        if(clientDao.modifyClient(id)) {
            System.out.println("Add some changes in client");
        } else {
            System.out.println("Something was wrong with modify client by id: " + id);
        }
    }

    @Override
    public void deleteClient(long id) {
        if(clientDao.deleteClient(id)) {
            System.out.println("Client on id: " + id + " was removed!");
        } else {
            System.out.println("Something was wrong with delete client by id:" + id);
        }
    }

    @Override
    public List<Client> listClients() {
        return clientDao.clientList();
    }
}
