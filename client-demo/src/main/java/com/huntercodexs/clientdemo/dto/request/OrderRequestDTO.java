package com.huntercodexs.clientdemo.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class OrderRequestDTO {
    private int id;
    private Integer productId;
    private Date date;
    private Integer quantity;

}
