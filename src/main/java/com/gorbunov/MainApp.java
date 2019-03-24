
package com.gorbunov;

import com.gorbunov.dao.dbcp.CreatorDataBase;
import com.gorbunov.dao.impl.ClientDaoImpl;
import com.gorbunov.dao.impl.OrderDaoImpl;
import com.gorbunov.dao.impl.ProductContainerDaoImpl;
import com.gorbunov.dao.impl.ProductDaoImpl;
import com.gorbunov.services.ClientService;
import com.gorbunov.services.OrderService;
import com.gorbunov.services.ProductContainerService;
import com.gorbunov.services.ProductService;
import com.gorbunov.services.impl.ClientServiceImpl;
import com.gorbunov.services.impl.OrderServiceImpl;
import com.gorbunov.services.impl.ProductContainerServiceImpl;
import com.gorbunov.services.impl.ProductServiceImpl;
import com.gorbunov.validator.BusinessException;
import com.gorbunov.validator.ValidationService;
import com.gorbunov.validator.ValidationServiceImpl;
import com.gorbunov.view.MainMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {
    public static void main(String[] args) throws IOException, BusinessException {
        new CreatorDataBase().createDataBaseStructure();
        ValidationService validationService = new ValidationServiceImpl();
        ClientService clientService = new ClientServiceImpl(ClientDaoImpl.getInstance(), validationService);
        ProductService productService = new ProductServiceImpl(ProductDaoImpl.getInstance());
        ProductContainerService productContainerService = new ProductContainerServiceImpl(ProductContainerDaoImpl.getInstance());
        OrderService orderService = new OrderServiceImpl(OrderDaoImpl.getInstance());
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        MainMenu mainMenu = new MainMenu(bf, clientService, productService, productContainerService, orderService);
        mainMenu.showMenu();
    }
}