package com.huntercodexs.clientdemo.controller;

import com.huntercodexs.clientdemo.dto.request.OrderRequestDTO;
import com.huntercodexs.clientdemo.dto.response.OrderResponseDTO;
import com.huntercodexs.clientdemo.dto.response.ProductResponseDTO;
import com.huntercodexs.clientdemo.proxies.MicroserviceOrderProxy;
import com.huntercodexs.clientdemo.proxies.MicroserviceProductsProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("${api.prefix}")
public class ClientDemoController {

    @Autowired
    MicroserviceOrderProxy microserviceOrderProxy;

    @Autowired
    MicroserviceProductsProxy microserviceProductsProxy;

    @PostMapping(value = "/orders")
    public OrderResponseDTO order(@RequestBody OrderRequestDTO orderRequestDTO) {
        log.info("Orders in API is calling");
        log.info(String.valueOf(orderRequestDTO));
        return microserviceOrderProxy.addOrder(orderRequestDTO);
    }

    @GetMapping("/products")
    public List<ProductResponseDTO> all() {
        log.info("All Product in API is calling");
        return this.microserviceProductsProxy.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductResponseDTO one(@PathVariable int id) {
        log.info("One Product in API is calling");
        return microserviceProductsProxy.findById(id);
    }

}
