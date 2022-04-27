package com.huntercodexs.orderdemo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "order")
public class OrderModel {
    @Id
    @GeneratedValue
    private int id;
    private Integer productId;
    private Date date;
    private Integer quantity;
}

