package com.upc.devergentes.furniview.order.model.service;

import com.upc.devergentes.furniview.order.model.domain.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Long clientId, Long vendorId, List<Long> furnitureIds);

    Order getOrderById(Long orderId);

    List<Order> getOrdersByClient(Long clientId);

    void updateOrder(Order order);

    void deleteOrder(Long orderId);
}
