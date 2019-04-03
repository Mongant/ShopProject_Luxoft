package com.gorbunov.controller;

import com.gorbunov.domain.Client;
import com.gorbunov.domain.Order;
import com.gorbunov.domain.Product;
import com.gorbunov.services.ClientService;
import com.gorbunov.services.OrderService;
import com.gorbunov.services.ProductContainerService;
import com.gorbunov.utils.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    ProductContainerService productContainerService;

    @Autowired
    ClientService clientService;

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/order")
    public String showListOrders(Model model) {
        List<Order> orders = orderService.listOrders();
        model.addAttribute("orders", orders);
        return "allOrdersList";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String addOrder(Model model) {
        String sessionId = GenerateId.getResult();
        List<Client> clients = clientService.listClients();
        List<Product> products = productContainerService.showProductContainer(sessionId).getProducts();
        orderService.addOrder(clients.get(clientService.listClients().size() -1).getId(), sessionId, products);
        Order order = orderService.showOrder(sessionId);
        model.addAttribute("order", order);
        return "orderList";
    }

    @RequestMapping(value = "/order", method = RequestMethod.DELETE)
    public String deleteOrder(@RequestParam long id) {
        orderService.deleteOrder(id);
        return "deleteOrder";
    }
}
