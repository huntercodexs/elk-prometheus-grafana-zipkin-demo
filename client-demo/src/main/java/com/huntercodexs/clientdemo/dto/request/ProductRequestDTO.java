package com.huntercodexs.clientdemo.dto.request;

import lombok.Data;

@Data
public class ProductRequestDTO {
    private int id;
    private String title;
    private String description;
    private Double cost;
}
