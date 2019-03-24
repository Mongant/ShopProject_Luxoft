package com.gorbunov.servlets;

import com.gorbunov.domain.Product;
import com.gorbunov.services.ProductService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProductServlet extends HttpServlet {

    ProductService productService;

    public ProductServlet(ProductService productService) {
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<Product> products = productService.productList();
        if(!products.isEmpty()) {
            out.println("<center><h1> Client list</h1></center>");
            for(Product product : products) {
                out.print("<h4> Product ID: " + product.getId() + "</h4>");
                out.print("<h4> Product name: " + product.getName() + "</h4>");
                out.print("<h4> Product description: " + product.getDescription() + "</h4>");
                out.print("<h4> Client age: " + product.getPrice() + "</h4>");
                out.print("------------------------------------------<br>");
            }
        } else {
            out.print("<center><h1>The product list is empty!</h1></center>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        String price = request.getParameter("price");
        try {
            productService.createProduct(productName, productDescription, Float.parseFloat(price));
            response.sendRedirect("http://localhost:8080/productList.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        String price = request.getParameter("price");
        try {
            productService.updateProduct(Long.parseLong(productId), productName, productDescription, Float.parseFloat(price));
            response.sendRedirect("http://localhost:8080/productList.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        productService.deleteProduct(Long.parseLong(id));
    }
}
