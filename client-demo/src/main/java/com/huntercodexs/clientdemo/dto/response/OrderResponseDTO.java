package com.huntercodexs.clientdemo.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class OrderResponseDTO {
    private int id;
    private Integer productId;
    private Date date;
    private Integer quantity;
}
