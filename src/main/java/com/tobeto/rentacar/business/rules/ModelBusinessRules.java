package com.tobeto.rentacar.business.rules;

import com.tobeto.rentacar.core.exceptions.types.BusinessException;
import com.tobeto.rentacar.dataAccess.abstracts.ModelRepository;
import com.tobeto.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ModelBusinessRules {
    ModelRepository modelRepository;

    public void ModelNameAndAttributesCanNotBeDuplicated(String name, int brandId, int fuelId, int transmissionId) {
        Optional<Model> model = modelRepository.findByNameAndBrandIdAndFuelIdAndTransmissionId(name, brandId, fuelId, transmissionId);
        if (model.isPresent()) {
            throw new BusinessException("Model with the same attributes already exists!");
        }
    }
}
