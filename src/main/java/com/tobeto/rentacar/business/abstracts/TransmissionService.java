package com.tobeto.rentacar.business.abstracts;

import com.tobeto.rentacar.business.dtos.requests.transmission.CreatedTransmissionRequest;
import com.tobeto.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import com.tobeto.rentacar.business.dtos.responses.transmission.GetAllTransmissionResponse;

import java.util.List;

public interface TransmissionService {
    CreatedTransmissionResponse add(CreatedTransmissionRequest createdTransmissionRequest);

    List<GetAllTransmissionResponse> getAll();

}
