package com.gorbunov.services.impl;

import com.gorbunov.dao.ClientDao;
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
    public Client createClient(String name, String surname, String phone, int age, String email) throws BusinessException {
        Client client = null;
        if(!clientDao.duplicatePhone(phone)) {
            validationService.validateAge(age);
            validationService.validatePhoneNum(phone);
            validationService.validateEmail(email);
            client = new Client(name, surname, phone, age, email);
            clientDao.addClient(client);
            System.out.println("Client was created successfully!");
        } else {
            System.err.println("Phone number is not unique!");
        }
        return client;
    }

    @Override
    public Client getClient(long id) throws NullPointerException{
        return clientDao.getClient(id);
    }

    @Override
    public void modifyClient(long id, String name, String surname, String phone, int age, String email) throws BusinessException {
        validationService.validateAge(age);
        validationService.validatePhoneNum(phone);
        validationService.validateEmail(email);
        Client client = new Client(name, surname, phone, age, email);
        clientDao.updateClient(id, client);
    }

    @Override
    public void deleteClient(long id) {
        clientDao.deleteClient(id);
    }

    @Override
    public List<Client> listClients() throws NullPointerException{
        List<Client> clients = clientDao.clientList();
        if(!clients.isEmpty()){
            return clients;
        }
        return null;
    }
}