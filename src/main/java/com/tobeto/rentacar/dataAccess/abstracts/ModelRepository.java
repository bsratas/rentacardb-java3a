package com.tobeto.rentacar.dataAccess.abstracts;

import com.tobeto.rentacar.entities.concretes.Fuel;
import com.tobeto.rentacar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    Optional<Model> findByNameAndBrandIdAndFuelIdAndTransmissionId(String name, int brandId, int fuelId, int transmissionId);
}
