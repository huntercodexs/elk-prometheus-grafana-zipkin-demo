package com.huntercodexs.orderdemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private Integer productId;
    @Column
    private Date date;
    @Column
    private Integer quantity;
}

