package com.order.client;

import com.order.model.OrderItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ORDER-ITEM-SERVICE",fallback=OrderItemServiceClient.OrderItemServiceClientFallback.class)
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

    @Component
    public static class OrderItemServiceClientFallback implements OrderItemServiceClient {

        @Override
        public OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO) {
            OrderItemDTO orderItemDTO1=new OrderItemDTO();
            orderItemDTO1.setId(1l);
            orderItemDTO1.setQuantity("Good");
            orderItemDTO1.setProductName("AUDI");
            orderItemDTO1.setProductCode("AUDI CAR DUMMY");
            return orderItemDTO1;
        }

        @Override
        public OrderItemDTO updateOrderItem(OrderItemDTO orderItemDTO, Long id) {
            OrderItemDTO orderItemDTO1=new OrderItemDTO();
            orderItemDTO1.setId(id);
            orderItemDTO1.setQuantity("Good");
            orderItemDTO1.setProductName("AUDI");
            orderItemDTO1.setProductCode("AUDI CAR DUMMY");
            return orderItemDTO1;
        }

        @Override
        public OrderItemDTO getOrderItemById(Long id) {
            OrderItemDTO orderItemDTO1=new OrderItemDTO();
            orderItemDTO1.setId(id);
            orderItemDTO1.setQuantity("Good");
            orderItemDTO1.setProductName("AUDI");
            orderItemDTO1.setProductCode("AUDI CAR DUMMY");
            return orderItemDTO1;
        }

        @Override
        public List<OrderItemDTO> getAllOrderItem() {
            return null;
        }

        @Override
        public void deleteOrderItemById(Long id) {

        }
    }

    }

