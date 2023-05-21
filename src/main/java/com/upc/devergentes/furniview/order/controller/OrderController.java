package com.upc.devergentes.furniview.order.controller;

import com.upc.devergentes.furniview.order.model.domain.Order;
import com.upc.devergentes.furniview.order.model.service.OrderService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest request) {
        Order order = orderService.createOrder(request.getClientId(), request.getVendorId(), request.getFurnitureIds());
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Order>> getOrdersByClient(@PathVariable Long clientId) {
        List<Order> orders = orderService.getOrdersByClient(clientId);
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Void> updateOrder(@PathVariable Long orderId, @RequestBody UpdateOrderRequest request) {
        Order order = orderService.getOrderById(orderId);
        // Update the order properties based on the request
        orderService.updateOrder(order);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    @Getter
    @Setter
    public static class CreateOrderRequest {
        private Long clientId;
        private Long vendorId;
        private List<Long> furnitureIds;
        // Otros campos necesarios
    }

    @Getter
    @Setter
    public static class UpdateOrderRequest {
        private String status;
        // Otros campos necesarios
    }
}
