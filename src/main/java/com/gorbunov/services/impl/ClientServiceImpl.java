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
    public void createClient(String name, String surname, String phone, int age, String email) throws BusinessException {
            validationService.validateAge(age);
            Client client = new Client(name, surname, phone, age, email);
            clientDao.addClient(client);
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
            System.out.println("Client by ID: " + id + " was successfully deleted!");
        } else {
            System.out.print("Client by ID: " + id + " was not found!");
        }
    }

    @Override
    public List<Client> listClients() {
        return clientDao.clientList();
    }
}