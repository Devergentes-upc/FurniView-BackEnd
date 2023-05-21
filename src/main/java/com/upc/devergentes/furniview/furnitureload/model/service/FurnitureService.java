package com.upc.devergentes.furniview.furnitureload.model.service;

import com.upc.devergentes.furniview.furnitureload.model.domain.Furniture;

import java.util.List;

public interface FurnitureService {
    Furniture createFurniture(Furniture furniture);

    Furniture getFurnitureById(Long id);

    List<Furniture> getAllFurniture();

    Furniture updateFurniture(Furniture furniture);

    void deleteFurniture(Long id);
}
