package com.huntercodexs.orderdemo.web.controller;

import com.huntercodexs.orderdemo.model.OrderModel;
import com.huntercodexs.orderdemo.repository.OrderRepository;
import com.huntercodexs.orderdemo.web.exceptions.AddOrderException;
import com.huntercodexs.orderdemo.web.exceptions.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderRepository ordersRepository;

    @PostMapping (value = "/orders")
    public ResponseEntity<OrderModel> add(@RequestBody OrderModel order){
        try {
            OrderModel orderModel = ordersRepository.save(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(orderModel);
        } catch (AddOrderException ae) {
            throw new AddOrderException("Error on try add order");
        }
    }

    @GetMapping(value = "/orders/{id}")
    public Optional<OrderModel> one(@PathVariable int id){
        Optional<OrderModel> orderModel = ordersRepository.findById(id);
        if(!orderModel.isPresent()) throw new OrderNotFoundException("Order not found");
        return orderModel;
    }

    @GetMapping(value = "/orders")
    public List<OrderModel> all() {
        return ordersRepository.findAll();
    }

    @PutMapping(value = "/orders")
    public void update(@RequestBody OrderModel orderModel) {
        ordersRepository.save(orderModel);
    }

}
