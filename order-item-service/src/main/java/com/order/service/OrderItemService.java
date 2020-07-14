package com.order.service;

import com.order.entity.OrderItem;
import com.order.exception.OrderItemIdNotFoundException;
import com.order.exception.OrderUpdateException;
import com.order.model.OrderItemDTO;
import com.order.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO) {
        OrderItem orderItem=new OrderItem();
        orderItem.setProductCode(orderItemDTO.getProductCode());
        orderItem.setProductName(orderItemDTO.getProductName());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        OrderItem orderItem1 = orderItemRepository.save(orderItem);
        orderItemDTO.setId(orderItem1.getId());
        orderItemDTO.setProductCode(orderItem1.getProductCode());
        orderItemDTO.setProductName(orderItem1.getProductName());
        orderItemDTO.setQuantity(orderItem1.getQuantity());
        return orderItemDTO;

    }

    public OrderItemDTO updateOrderItem(OrderItemDTO orderItemDTO, Long id) {
        OrderItemDTO order = new OrderItemDTO();
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new OrderUpdateException(HttpStatus.NOT_FOUND.value(), "Order Id Not Found for update the record"));
        orderItem.setProductCode(orderItemDTO.getProductCode());
        orderItem.setProductName(orderItemDTO.getProductName());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        OrderItem orderItem1 = orderItemRepository.save(orderItem);
        order.setProductCode(orderItem1.getProductCode());
        order.setProductName(orderItem1.getProductName());
        order.setQuantity(orderItem1.getQuantity());
        order.setId(orderItem1.getId());
        return order;

    }

    public OrderItemDTO getOrderItemById(Long id) {
        OrderItemDTO order = new OrderItemDTO();
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new OrderItemIdNotFoundException(HttpStatus.NOT_FOUND.value(), "Order Id Not Found"));
        order.setProductCode(orderItem.getProductCode());
        order.setProductName(orderItem.getProductName());
        order.setQuantity(orderItem.getQuantity());
        order.setId(orderItem.getId());
        return order;

    }

    public List<OrderItemDTO> getAllOrderItem() {
     return orderItemRepository.findAll().stream().map(this::populateOrderItems).collect(Collectors.toList());


    }

    private OrderItemDTO populateOrderItems(OrderItem orderItem) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setProductCode(orderItem.getProductCode());
        orderItemDTO.setProductName(orderItem.getProductName());
        orderItemDTO.setQuantity(orderItem.getQuantity());
        orderItemDTO.setId(orderItem.getId());
        return orderItemDTO;
    }

    public void deleteOrderItemById(Long id) {
        orderItemRepository.deleteById(id);
    }
}

