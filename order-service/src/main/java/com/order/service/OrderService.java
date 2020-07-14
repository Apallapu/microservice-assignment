package com.order.service;

import com.order.client.OrderItemServiceClient;
import com.order.entity.Order;
import com.order.exception.OrderIdNotFoundException;
import com.order.exception.OrderUpdateException;
import com.order.model.OrderDTO;
import com.order.model.OrderItemDTO;
import com.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    OrderItemServiceClient orderItemServiceClient;

    public OrderDTO createOrder(OrderDTO orderDTO) throws ParseException {
        Order order=new Order();
        order.setCustomerName(orderDTO.getCustomerName());
        order.setShippingAddress(orderDTO.getShippingAddress());
        order.setTotal(String.valueOf(orderDTO.getTotal()));
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        order.setOrderDate(dateFormat.parse(orderDTO.getOrderDate()));
        orderItemServiceClient.createOrderItem(orderDTO.getOrderItemDTO());
        Order newOrder = orderRepository.save(order);

        orderDTO.setCustomerName(newOrder.getCustomerName());
        orderDTO.setId(newOrder.getId());
        orderDTO.setShippingAddress(newOrder.getShippingAddress());
        orderDTO.setTotal(Integer.valueOf(newOrder.getTotal()));
        return orderDTO;

    }

    public OrderDTO updateOrder(OrderDTO orderDTO, Long id) throws ParseException {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderUpdateException(HttpStatus.NOT_FOUND.value(), "Order Id Not Found for update the record"));
        order.setCustomerName(orderDTO.getCustomerName());
        order.setShippingAddress(orderDTO.getShippingAddress());
        order.setTotal(String.valueOf(orderDTO.getTotal()));
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        order.setOrderDate(dateFormat.parse(orderDTO.getOrderDate()));
        orderItemServiceClient.updateOrderItem(orderDTO.getOrderItemDTO(),id);
        Order newOrder = orderRepository.save(order);

        orderDTO.setCustomerName(newOrder.getCustomerName());
        orderDTO.setId(newOrder.getId());
        orderDTO.setShippingAddress(newOrder.getShippingAddress());
        orderDTO.setTotal(Integer.valueOf(newOrder.getTotal()));
        orderDTO.setOrderDate(dateFormat.format(newOrder.getOrderDate()));
        return orderDTO;

    }

    public OrderDTO getOrderById(Long id) {
        OrderDTO orderDTO = new OrderDTO();
        Order newOrder = orderRepository.findById(id).orElseThrow(() -> new OrderIdNotFoundException(HttpStatus.NOT_FOUND.value(), "Order Id Not Found"));
        orderDTO.setCustomerName(newOrder.getCustomerName());
        orderDTO.setId(newOrder.getId());
        orderDTO.setShippingAddress(newOrder.getShippingAddress());
        orderDTO.setTotal(Integer.valueOf(newOrder.getTotal()));
        OrderItemDTO orderItemDTO=orderItemServiceClient.getOrderItemById(id);
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        orderDTO.setOrderItemDTO(orderItemDTO);
        orderDTO.setOrderDate(dateFormat.format(newOrder.getOrderDate()));
        return orderDTO;

    }

    public List<OrderDTO> getAllOrders() {
     return orderRepository.findAll().stream().map(this::populateOrderItems).collect(Collectors.toList());


    }

    private OrderDTO populateOrderItems(Order orderItem) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerName(orderItem.getCustomerName());
        orderDTO.setId(orderItem.getId());
        orderDTO.setShippingAddress(orderItem.getShippingAddress());
        orderDTO.setTotal(Integer.valueOf(orderItem.getTotal()));
        List<OrderItemDTO> orderItemDTO=orderItemServiceClient.getAllOrderItem();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        orderDTO.setOrderItemDTO(orderItemDTO.get(0));
        orderDTO.setOrderDate(dateFormat.format(orderItem.getOrderDate()));
        return orderDTO;
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}

