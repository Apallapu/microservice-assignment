package com.order.controller;

import com.order.model.OrderItemDTO;
import com.order.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/order-item")
    public OrderItemDTO createOrderItem(@RequestBody OrderItemDTO orderItemDTO) {

        return orderItemService.createOrderItem(orderItemDTO);

    }

    @PutMapping("/order-item/{id}")
    public OrderItemDTO updateOrderItem(@RequestBody OrderItemDTO orderItemDTO, @PathVariable Long id) {

        return orderItemService.updateOrderItem(orderItemDTO, id);

    }

    @GetMapping("/order-item/{id}")
    public OrderItemDTO getOrderItemById(@PathVariable Long id) {

        return orderItemService.getOrderItemById(id);

    }

    @GetMapping("/getOrderItems")
    public List<OrderItemDTO> getAllOrderItem() {

        return orderItemService.getAllOrderItem();

    }

    @DeleteMapping("/order-item/{id}")
    public void deleteOrderItemById(@PathVariable Long id) {

        orderItemService.deleteOrderItemById(id);

    }


}
