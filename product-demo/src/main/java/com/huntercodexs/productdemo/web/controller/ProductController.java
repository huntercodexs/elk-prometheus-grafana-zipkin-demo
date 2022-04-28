package com.huntercodexs.productdemo.web.controller;

import com.huntercodexs.productdemo.repository.ProductRepository;
import com.huntercodexs.productdemo.model.ProductEntity;
import com.huntercodexs.productdemo.web.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin("*")
@RequestMapping("${api.prefix}")
public class ProductController {

    private static final Logger LOG = Logger.getLogger(ProductController.class.getName());

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductEntity>> all() {

        LOG.info("GET Index Products in API is calling");

        try {

            List<ProductEntity> productEntities = productRepository.findAll();

            if(productEntities.isEmpty()) {
                throw new ProductNotFoundException("Products not found");
            }

            return ResponseEntity.ok().body(productEntities);

        } catch (ProductNotFoundException pe) {
            throw new ProductNotFoundException("Products not found");
        }
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Optional<ProductEntity>> one(@PathVariable int id) {

        LOG.info("GET id Index Products in API is calling");

        Optional<ProductEntity> product = productRepository.findById(id);

        if(!product.isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }

        return ResponseEntity.ok().body(product);

    }

}

