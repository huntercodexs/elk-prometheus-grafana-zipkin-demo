package com.huntercodexs.productdemo.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ProductEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Double cost;
}
