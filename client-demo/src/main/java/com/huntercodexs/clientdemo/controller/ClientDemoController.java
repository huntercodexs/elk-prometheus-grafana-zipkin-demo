package com.huntercodexs.clientdemo.controller;

import com.huntercodexs.clientdemo.dto.request.OrderRequestDTO;
import com.huntercodexs.clientdemo.dto.response.OrderResponseDTO;
import com.huntercodexs.clientdemo.dto.response.ProductResponseDTO;
import com.huntercodexs.clientdemo.proxies.MicroserviceOrderProxy;
import com.huntercodexs.clientdemo.proxies.MicroserviceProductsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("${api.prefix}")
public class ClientDemoController {

    @Autowired
    private MicroserviceProductsProxy productsProxy;

    @Autowired
    private MicroserviceOrderProxy OrdersProxy;

    @GetMapping("/products")
    public List<ProductResponseDTO> all() { return productsProxy.findAll(); }

    @GetMapping("/products/{id}")
    public ProductResponseDTO one(@PathVariable int id){ return productsProxy.findById(id); }

    @PostMapping(value = "/orders")
    public OrderResponseDTO order(@RequestBody OrderRequestDTO orderRequestDTO) {
        return OrdersProxy.addOrder(orderRequestDTO);
    }

}
