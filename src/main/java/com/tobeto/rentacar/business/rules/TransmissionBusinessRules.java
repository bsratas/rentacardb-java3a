package com.tobeto.rentacar.business.rules;

import com.tobeto.rentacar.core.exceptions.types.BusinessException;
import com.tobeto.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.tobeto.rentacar.entities.concretes.Model;
import com.tobeto.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TransmissionBusinessRules {
    TransmissionRepository transmissionRepository;

    public void TransmissionNameCanNotBeDuplicated(String name) {
        Optional<Transmission> transmission = transmissionRepository.findByNameIgnoreCase(name);
        if (transmission.isPresent()) {
            throw new BusinessException("Transmission Exists!");
        }
    }
}
