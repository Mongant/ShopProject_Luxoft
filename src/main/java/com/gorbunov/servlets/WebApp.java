package com.gorbunov.servlets;

import com.gorbunov.dao.ClientDao;
import com.gorbunov.dao.OrderDao;
import com.gorbunov.dao.ProductContainerDao;
import com.gorbunov.dao.ProductDao;
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
import com.gorbunov.validator.ValidationService;
import com.gorbunov.validator.ValidationServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebApp implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ClientDao clientDao = ClientDaoImpl.getInstance();
        ProductDao productDao = ProductDaoImpl.getInstance();
        OrderDao orderDao = OrderDaoImpl.getInstance();
        ProductContainerDao productContainerDao = ProductContainerDaoImpl.getInstance();

        ValidationService validationService = new ValidationServiceImpl();
        ClientService clientService = new ClientServiceImpl(clientDao, validationService);
        ProductService productService = new ProductServiceImpl(productDao);
        OrderService orderService = new OrderServiceImpl(orderDao);
        ProductContainerService productContainerService = new ProductContainerServiceImpl(productContainerDao);

        ServletContext servletContext = sce.getServletContext();
        servletContext.addServlet("ClientServlet", new ClientServlet(clientService)).addMapping("/client");
        servletContext.addServlet("ProductServlet", new ProductServlet(productService)).addMapping("/product");
        servletContext.addServlet("OrderServlet", new OrderServlet(orderService)).addMapping("/order");
        servletContext.addServlet("ProductContainerServlet", new ProductContainerServlet(productContainerService)).addMapping("/product_container");
    }
}
