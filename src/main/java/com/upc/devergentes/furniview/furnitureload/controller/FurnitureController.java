package com.upc.devergentes.furniview.furnitureload.controller;

import com.upc.devergentes.furniview.furnitureload.model.domain.Furniture;
import com.upc.devergentes.furniview.furnitureload.model.service.FurnitureService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/furniture")
public class FurnitureController {
    private final FurnitureService furnitureService;

    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @PostMapping
    public Furniture createFurniture(@RequestBody Furniture furniture) {
        return furnitureService.createFurniture(furniture);
    }

    @GetMapping("/{id}")
    public Furniture getFurnitureById(@PathVariable Long id) {
        return furnitureService.getFurnitureById(id);
    }

    @GetMapping
    public List<Furniture> getAllFurniture() {
        return furnitureService.getAllFurniture();
    }

    @PutMapping("/{id}")
    public Furniture updateFurniture(@PathVariable Long id, @RequestBody Furniture furniture) {
        furniture.setId(id);
        return furnitureService.updateFurniture(furniture);
    }

    @DeleteMapping("/{id}")
    public void deleteFurniture(@PathVariable Long id) {
        furnitureService.deleteFurniture(id);
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        // Procesar el archivo cargado aquí
        // Guardar el archivo en la ubicación configurada
        // Devolver la respuesta apropiada
        return "Archivo cargado exitosamente";
    }

}
