package com.upc.devergentes.furniview.order.model.domain;

import com.upc.devergentes.furniview.account.model.domain.UserSystem;
import com.upc.devergentes.furniview.furnitureload.model.domain.Furniture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserSystem client;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private UserSystem vendor;

    @ManyToMany
    @JoinTable(
            name = "order_furniture",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "furniture_id")
    )
    private List<Furniture> furnitureList;
}
