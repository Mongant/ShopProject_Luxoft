package com.gorbunov.controller;

import com.gorbunov.domain.Product;
import com.gorbunov.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/product")
    public String showProduct(ModelMap modelMap) {
        List<Product> products = productService.productList();
        modelMap.addAttribute("productList", products);
        return "productList";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String addProduct(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam float price) {
        productService.addProduct(name, description, price);
        return "productList";
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public String updateProduct(@RequestParam long id,
                                @RequestParam String name,
                                @RequestParam String description,
                                @RequestParam float price) {
        productService.updateProduct(id, name, description, price);
        return "productList";
    }

    @RequestMapping(value = "/product", method = RequestMethod.DELETE)
    public String deleteProduct(@RequestParam long id) {
        productService.deleteProduct(id);
        return "productList";
    }
}