package com.tobeto.rentacar.business.abstracts;

import com.tobeto.rentacar.business.dtos.requests.transmission.CreatedTransmissionRequest;
import com.tobeto.rentacar.business.dtos.requests.transmission.UpdateTransmissionRequest;
import com.tobeto.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import com.tobeto.rentacar.business.dtos.responses.transmission.GetAllTransmissionResponse;
import com.tobeto.rentacar.business.dtos.responses.transmission.GetTransmissionByIdResponse;
import com.tobeto.rentacar.business.dtos.responses.transmission.UpdateTransmissionResponse;

import java.util.List;

public interface TransmissionService {
    CreatedTransmissionResponse add(CreatedTransmissionRequest createdTransmissionRequest);

    List<GetAllTransmissionResponse> getAll();

    GetTransmissionByIdResponse getTransmissionById(
            int id
    );
    UpdateTransmissionResponse updateTransmissionById(
            UpdateTransmissionRequest request,
            int id
    );
}
