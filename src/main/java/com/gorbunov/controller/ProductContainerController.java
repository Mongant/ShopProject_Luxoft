package com.gorbunov.controller;

import com.gorbunov.domain.ProductContainer;
import com.gorbunov.services.ProductContainerService;
import com.gorbunov.utils.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductContainerController {

    @Autowired
    ProductContainerService productContainerService;

    @GetMapping(value = "/product_container")
    public String showProductContainer(Model model) {
        ProductContainer productContainer = productContainerService.showProductContainer(GenerateId.getResult());
        model.addAttribute("productContainer", productContainer);
        return "productContainerList";
    }

    @RequestMapping(value = "/product_container", method = RequestMethod.POST)
    public String addProductContainer(@RequestParam long productId) {
        productContainerService.addProductContainer(productId, GenerateId.getResult());
        return "productContainerList";
    }

    @RequestMapping(value = "/product_container", method = RequestMethod.DELETE)
    public String deleteProductContainer(@RequestParam long productId,
                                         @RequestParam String refId) {
        productContainerService.deleteProductContainer(productId, refId);
        return "productContainerList";
    }
}
