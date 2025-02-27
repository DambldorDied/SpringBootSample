package com.cko.sampleSpringProject.controller.rest;

import com.cko.sampleSpringProject.dao.ProductDAO;
import com.cko.sampleSpringProject.dao.UserDAO;
import com.cko.sampleSpringProject.model.Product;
import com.cko.sampleSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    ProductDAO productDAO;

    @PostMapping("/add")
    public void addUser(@RequestBody Product product){
        productDAO.save(product);

    }
    @PostMapping("/edit")
    public void editUser(@RequestBody Product product){
        productDAO.save(product);

    }
    @GetMapping("/get")
    public Product getProductById(@RequestParam long id){
        return productDAO.findProductById(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProduct(){
        List<Product> productList;
        return productDAO.findAll();
    }


}