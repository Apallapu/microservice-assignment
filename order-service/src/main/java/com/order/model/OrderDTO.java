package com.order.model;

import lombok.Data;

@Data
public class OrderDTO {
    private Long id;
    private String customerName;
    private String shippingAddress;
    private String orderDate;
    private OrderItemDTO orderItemDTO;
    private int total;
}
