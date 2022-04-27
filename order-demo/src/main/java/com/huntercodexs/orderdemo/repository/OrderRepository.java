package com.huntercodexs.orderdemo.repository;


import com.huntercodexs.orderdemo.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Integer> {}
