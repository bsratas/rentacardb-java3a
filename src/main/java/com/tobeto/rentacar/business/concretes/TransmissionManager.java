package com.tobeto.rentacar.business.concretes;

import com.tobeto.rentacar.business.abstracts.TransmissionService;
import com.tobeto.rentacar.business.dtos.requests.transmission.CreatedTransmissionRequest;
import com.tobeto.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import com.tobeto.rentacar.business.dtos.responses.transmission.GetAllTransmissionResponse;
import com.tobeto.rentacar.business.rules.TransmissionBusinessRules;
import com.tobeto.rentacar.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.tobeto.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {
    private TransmissionRepository transmissionRepository;
    private ModelMapperService modelMapperService;
    private TransmissionBusinessRules transmissionBusinessRules;


    @Override
    public CreatedTransmissionResponse add(CreatedTransmissionRequest createdTransmissionRequest) {
        transmissionBusinessRules.TransmissionNameCanNotBeDuplicated(createdTransmissionRequest.getName());
        Transmission transmission =
                this.modelMapperService.forRequest().map(createdTransmissionRequest, Transmission.class);
        transmission.setCreatedDate(LocalDateTime.now());
        Transmission createdTransmission =
                this.transmissionRepository.save(transmission);
        CreatedTransmissionResponse createdTransmissionResponse =
                this.modelMapperService.forResponse().map(createdTransmission
                        , CreatedTransmissionResponse.class);
        return createdTransmissionResponse;
    }

    @Override
    public List<GetAllTransmissionResponse> getAll() {
        List<Transmission> transmissions = transmissionRepository.findAll();
        List<GetAllTransmissionResponse> response =
                transmissions.stream().map(transmission -> modelMapperService.forResponse().map(transmission, GetAllTransmissionResponse.class)).collect(Collectors.toList());
        return response;
    }
}
