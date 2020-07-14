package com.order.controller;

import com.order.model.OrderDTO;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) throws ParseException {

        return orderService.createOrder(orderDTO);

    }

    @PutMapping("/order/{id}")
    public OrderDTO updateOrder(@RequestBody OrderDTO orderItemDTO, @PathVariable Long id) throws ParseException {

        return orderService.updateOrder(orderItemDTO, id);

    }

    @GetMapping("/order/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {

        return orderService.getOrderById(id);

    }

    @GetMapping("/getOrders")
    public List<OrderDTO> getAllOrders() {

        return orderService.getAllOrders();

    }

    @DeleteMapping("/order/{id}")
    public void deleteOrderById(@PathVariable Long id) {

        orderService.deleteOrderById(id);

    }


}
