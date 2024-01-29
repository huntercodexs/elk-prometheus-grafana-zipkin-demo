package com.huntercodexs.orderdemo.web.controller;

import com.huntercodexs.orderdemo.model.OrderEntity;
import com.huntercodexs.orderdemo.repository.OrderRepository;
import com.huntercodexs.orderdemo.web.exceptions.AddOrderException;
import com.huntercodexs.orderdemo.web.exceptions.OrderNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("${api.prefix}")
public class OrderController {

    @Autowired
    OrderRepository ordersRepository;

    @PostMapping (value = "/orders")
    public ResponseEntity<OrderEntity> add(@RequestBody OrderEntity order) {
        log.info("POST add orders in API is calling");
        try {
            OrderEntity orderEntity = ordersRepository.save(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(orderEntity);
        } catch (AddOrderException ae) {
            throw new AddOrderException("Error on try add order");
        }
    }

    @GetMapping(value = "/orders/{id}")
    public Optional<OrderEntity> one(@PathVariable int id) {
        log.info("GET id one orders in API is calling");
        Optional<OrderEntity> orderModel = ordersRepository.findById(id);
        if(!orderModel.isPresent()) throw new OrderNotFoundException("Order not found");
        return orderModel;
    }

    @GetMapping(value = "/orders")
    public List<OrderEntity> all() {
        log.info("GET all Orders in API is calling");
        return ordersRepository.findAll();
    }

    @PutMapping(value = "/orders")
    public void update(@RequestBody OrderEntity orderEntity) {
        log.info("PUT update orders in API is calling");
        ordersRepository.save(orderEntity);
    }

}
