package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.dao.ProductsDao;

@Controller
public class ProductController {

    @Autowired
    private ProductsDao productsDao;

    @GetMapping(path = "/products")
    public String getProductsPage(){
        return "products";
    }

    @PostMapping(path = "/products")
    public String findProducts(ModelMap model){
        if(productsDao.findProduct()) {
            model.addAttribute("products", productsDao.getAll());
        }
        return "redirect:products";
    }
}
