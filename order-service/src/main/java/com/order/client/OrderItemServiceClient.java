package com.order.client;

import com.order.model.OrderItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ORDER-ITEM-SERVICE")
public interface OrderItemServiceClient {

    @PostMapping("/order-item")
    OrderItemDTO createOrderItem(@RequestBody OrderItemDTO orderItemDTO);

    @PutMapping("/order-item/{id}")
     OrderItemDTO updateOrderItem(@RequestBody OrderItemDTO orderItemDTO, @PathVariable Long id) ;

    @GetMapping("/order-item/{id}")
     OrderItemDTO getOrderItemById(@PathVariable Long id) ;

    @GetMapping("/getOrderItems")
    List<OrderItemDTO> getAllOrderItem() ;

    @DeleteMapping("/order-item/{id}")
    void deleteOrderItemById(@PathVariable Long id) ;

    }

