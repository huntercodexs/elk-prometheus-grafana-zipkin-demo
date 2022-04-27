package com.huntercodexs.productdemo.web.controller;

import com.huntercodexs.productdemo.repository.ProductRepository;
import com.huntercodexs.productdemo.model.ProductModel;
import com.huntercodexs.productdemo.web.exceptions.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductModel>> all(){
        try {

            List<ProductModel> productModels = productRepository.findAll();

            if(productModels.isEmpty()) {
                throw new ProductNotFoundException("Products not found");
            }

            log.info("Products list are been listed");

            return ResponseEntity.ok().body(productModels);

        } catch (ProductNotFoundException pe) {
            throw new ProductNotFoundException("Products not found");
        }
    }

    @GetMapping( value = "/products/{id}")
    public ResponseEntity<Optional<ProductModel>> one(@PathVariable int id) {

        Optional<ProductModel> product = productRepository.findById(id);

        if(!product.isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }

        return ResponseEntity.ok().body(product);

    }

}

