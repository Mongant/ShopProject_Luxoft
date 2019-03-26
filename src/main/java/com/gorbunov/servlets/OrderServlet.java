package com.gorbunov.servlets;

import com.gorbunov.domain.Client;
import com.gorbunov.domain.Order;
import com.gorbunov.domain.Product;
import com.gorbunov.services.ClientService;
import com.gorbunov.services.OrderService;
import com.gorbunov.services.ProductContainerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class OrderServlet extends HttpServlet {

    OrderService orderService;
    ClientService clientService;
    ProductContainerService productContainerService;

    public OrderServlet(OrderService orderService, ClientService clientService, ProductContainerService productContainerService) {
        this.orderService = orderService;
        this.clientService = clientService;
        this.productContainerService = productContainerService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<Order> orders = orderService.listOrders();
        if(!orders.isEmpty()) {
            out.println("<center><h1> Order list</h1></center>");
            for(Order order : orders) {
                out.print("<h4>Order ID: " + order.getId() + "</h4>");
                out.print("<h4>Client information: </h4>");
                out.print("<h4>Client name: " + order.getClient().getName() + "</h4>");
                out.print("<h4>Client surname: " + order.getClient().getSurname() + "</h4>");
                out.print("<h4>Products list: </h4>");
                for(Product product : order.getProducts()) {
                    out.print("<h4>Product name: " + product.getName() + "</h4>");
                    out.print("<h4>Product description: " + product.getDescription() + "</h4>");
                    out.print("<h4> Price: " + product.getPrice() + "</h4>");
                }
                out.print("<h4>Amount: " + order.getAmount() + "</h4>");
                out.print("------------------------------------------<br>");
            }
        } else {
            out.print("<center><h1>The product list is empty!</h1></center>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String session = request.getSession().getId();
        List<Client> clients = clientService.listClients();
        List<Product> products = new ArrayList<>(productContainerService.showProductContainer(session).getProductsContainer().values());
        orderService.addOrder(clients.get(clientService.listClients().size() -1).getId(), session, products);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPut(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response);
    }
}
