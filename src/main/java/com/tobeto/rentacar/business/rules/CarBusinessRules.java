package com.tobeto.rentacar.business.rules;

import com.tobeto.rentacar.core.exceptions.types.BusinessException;
import com.tobeto.rentacar.dataAccess.abstracts.CarRepository;
import com.tobeto.rentacar.entities.concretes.Brand;
import com.tobeto.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CarBusinessRules {
    private CarRepository carRepository;

    public void carPlateCanNotBeDuplicated(String plate){
        Optional<Car> car = carRepository.findByPlateIgnoreCase(plate);
        if(car.isPresent()){
            throw new BusinessException("Plate Exists!");
        }
    }
}
