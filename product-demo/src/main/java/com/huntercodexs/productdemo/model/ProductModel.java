package com.huntercodexs.productdemo.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ProductModel {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    private Double cost;
}
