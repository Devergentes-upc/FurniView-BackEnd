package com.upc.devergentes.furniview.furnitureload.model.repository;

import com.upc.devergentes.furniview.furnitureload.model.domain.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
}
