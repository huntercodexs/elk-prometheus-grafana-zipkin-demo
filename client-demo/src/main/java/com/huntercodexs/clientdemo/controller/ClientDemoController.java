package com.huntercodexs.clientdemo.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.huntercodexs.clientdemo.dto.request.OrderRequestDTO;
import com.huntercodexs.clientdemo.dto.response.OrderResponseDTO;
import com.huntercodexs.clientdemo.dto.response.ProductResponseDTO;
import com.huntercodexs.clientdemo.proxies.MicroserviceOrderProxy;
import com.huntercodexs.clientdemo.proxies.MicroserviceProductsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("${api.prefix}")
public class ClientDemoController {

    private static final Logger LOG = Logger.getLogger(ClientDemoController.class.getName());

    @Autowired
    MicroserviceProductsProxy microserviceProductsProxy;

    @Autowired
    MicroserviceOrderProxy microserviceOrderProxy;

    @GetMapping("/products")
    public List<ProductResponseDTO> all() {
        LOG.info("Index Product in API is calling");
        return this.microserviceProductsProxy.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductResponseDTO one(@PathVariable int id){ return microserviceProductsProxy.findById(id); }

    @PostMapping(value = "/orders")
    public OrderResponseDTO order(@RequestBody OrderRequestDTO orderRequestDTO) {
        return microserviceOrderProxy.addOrder(orderRequestDTO);
    }

}
