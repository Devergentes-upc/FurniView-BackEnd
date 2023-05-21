package com.upc.devergentes.furniview.furnitureload.service;

import com.upc.devergentes.furniview.furnitureload.model.domain.Furniture;
import com.upc.devergentes.furniview.furnitureload.model.repository.FurnitureRepository;
import com.upc.devergentes.furniview.furnitureload.model.service.FurnitureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FurnitureServiceImpl implements FurnitureService {
    private final FurnitureRepository furnitureRepository;

    public FurnitureServiceImpl(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    @Override
    public Furniture createFurniture(Furniture furniture) {
        return furnitureRepository.save(furniture);
    }

    @Override
    public Furniture getFurnitureById(Long id) {
        Optional<Furniture> optionalFurniture = furnitureRepository.findById(id);
        return optionalFurniture.orElse(null);
    }

    @Override
    public List<Furniture> getAllFurniture() {
        return furnitureRepository.findAll();
    }

    @Override
    public Furniture updateFurniture(Furniture furniture) {
        return furnitureRepository.save(furniture);
    }

    @Override
    public void deleteFurniture(Long id) {
        furnitureRepository.deleteById(id);
    }
}
