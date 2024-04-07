package com.tobeto.rentacar.business.rules;

import com.tobeto.rentacar.core.exceptions.types.BusinessException;
import com.tobeto.rentacar.dataAccess.abstracts.FuelRepository;
import com.tobeto.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class FuelBusinessRules {

    private FuelRepository fuelRepository;

    public void fuelNameCanNotBeDuplicated(String name) {
        Optional<Fuel> fuel = fuelRepository.findByNameIgnoreCase(name);
        if (fuel.isPresent()) {
            throw new BusinessException("Fuel Exists!");
        }
    }
}
