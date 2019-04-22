package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.dao.ManufacturersDao;
import ru.itis.dao.ProductsDao;
import ru.itis.models.Manufacturer;
import ru.itis.models.Product;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "/search")
public class SearchController {

    @Autowired
    private ProductsDao productsDao;

    @Autowired
    private ManufacturersDao manufacturersDao;

    @GetMapping
    public String getSearchPage() {
        return "search";
    }

    @PostMapping
    public String findProducts(ModelMap model, HttpSession session, @RequestParam(name = "name") String name, @RequestParam(name = "price") String price,
                               @RequestParam(name = "manufacturer") String manufacturerName) {
        List<Manufacturer> manufacturers = manufacturersDao.find(manufacturerName);
        if (!manufacturers.isEmpty()) {
            Manufacturer manufacturer = manufacturers.get(0);
            if (productsDao.findProduct(name, price, manufacturer) != null) {
                Product product = Product.builder()
                        .name(name)
                        .price(price)
                        .manufacturer(manufacturer.getId())
                        .build();
                session.setAttribute("product", product);
                session.setAttribute("manufacturer", manufacturer);
                return "redirect:products";
            }
        } else {
            productsDao.save(name, price, manufacturerName);
            return "redirect:search";
        }
        return "redirect:search";

    }

}
