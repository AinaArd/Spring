package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.dao.ProductsDao;
import ru.itis.models.Manufacturer;
import ru.itis.models.Product;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductsDao productsDao;

    @GetMapping(path = "/products")
    public String getProductsPage(ModelMap model, HttpSession session) {
//        String name = (String) session.getAttribute("name");
//        String price = (String) session.getAttribute("price");
//        Manufacturer manufacturer = (Manufacturer) session.getAttribute("manufacturer");
//        List<Product> products = productsDao.findProduct(name, price, manufacturer);
        Product product = (Product) session.getAttribute("product");
        Manufacturer manufacturer = (Manufacturer) session.getAttribute("manufacturer");
        model.addAttribute("products", Arrays.asList(product));
        model.addAttribute("manufacturer", manufacturer);
        return "products";
    }

}
