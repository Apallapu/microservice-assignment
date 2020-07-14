package com.order.model;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long id;
    private String productName;
    private  String productCode;
    private  String quantity;
}
