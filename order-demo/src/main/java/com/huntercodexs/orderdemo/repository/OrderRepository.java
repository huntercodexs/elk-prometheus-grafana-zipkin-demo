package com.huntercodexs.orderdemo.repository;


import com.huntercodexs.orderdemo.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {}
