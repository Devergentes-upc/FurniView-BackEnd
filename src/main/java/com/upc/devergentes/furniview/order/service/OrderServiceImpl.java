package com.upc.devergentes.furniview.order.service;

import com.upc.devergentes.furniview.account.model.domain.UserSystem;
import com.upc.devergentes.furniview.account.model.service.UserSystemService;
import com.upc.devergentes.furniview.furnitureload.model.domain.Furniture;
import com.upc.devergentes.furniview.furnitureload.model.service.FurnitureService;
import com.upc.devergentes.furniview.order.exception.OrderNotFoundException;
import com.upc.devergentes.furniview.order.model.domain.Order;
import com.upc.devergentes.furniview.order.model.repository.OrderRepository;
import com.upc.devergentes.furniview.order.model.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserSystemService userSystemService;
    private final FurnitureService furnitureService;

    public OrderServiceImpl(OrderRepository orderRepository, UserSystemService userSystemService, FurnitureService furnitureService) {
        this.orderRepository = orderRepository;
        this.userSystemService = userSystemService;
        this.furnitureService = furnitureService;
    }

    @Override
    public Order createOrder(Long clientId, Long vendorId, List<Long> furnitureIds) {
        UserSystem client = userSystemService.getUserSystemById(clientId);
        UserSystem vendor = userSystemService.getUserSystemById(vendorId);

        List<Furniture> furnitureList = new ArrayList<>();
        for (Long furnitureId : furnitureIds) {
            Furniture furniture = furnitureService.getFurnitureById(furnitureId);
            furnitureList.add(furniture);
        }

        Order order = new Order();
        order.setClient(client);
        order.setVendor(vendor);
        order.setFurnitureList(furnitureList);
        // TODO, agregar otras propiedades de order si fuese necesario en el futuro

        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + orderId));
    }

    @Override
    public List<Order> getOrdersByClient(Long clientId) {
        return orderRepository.findByClientId(clientId);
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long orderId) {
        Order order = getOrderById(orderId);
        orderRepository.delete(order);
    }
}
