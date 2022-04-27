package com.huntercodexs.clientdemo.dto.response;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private int id;
    private String title;
    private String description;
    private Double cost;
}
