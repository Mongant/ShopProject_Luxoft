package com.gorbunov.controller;

import com.gorbunov.domain.Client;
import com.gorbunov.services.ClientService;
import com.gorbunov.validator.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/client")
    public String showClients(ModelMap modelMap) {
        List<Client> clients = clientService.listClients();
        modelMap.addAttribute("clientList", clients);
        return "clientsList";
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public String showClient(@RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam int age,
                             @RequestParam String phone,
                             @RequestParam String email) throws BusinessException {
        clientService.createClient(name, surname, phone, age, email);
        return "adminClientOptions";
    }

    @RequestMapping(value = "/client", method = RequestMethod.PUT)
    public String updateClient(@RequestParam long id,
                               @RequestParam String name,
                               @RequestParam String surname,
                               @RequestParam int age,
                               @RequestParam String phone,
                               @RequestParam String email) throws BusinessException {
        clientService.modifyClient(id, name, surname, phone, age, email);
        return "updateClient";
    }

    @RequestMapping(value = "/client", method = RequestMethod.DELETE)
    public String deleteClient(@RequestParam long id) {
        clientService.deleteClient(id);
        return "deleteClient";
    }
}