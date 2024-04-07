package com.tobeto.rentacar.business.abstracts;

import com.tobeto.rentacar.business.dtos.requests.model.CreatedModelRequest;
import com.tobeto.rentacar.business.dtos.responses.model.CreatedModelResponse;
import com.tobeto.rentacar.business.dtos.responses.model.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    CreatedModelResponse add(CreatedModelRequest createdModelRequest);

    List<GetAllModelResponse> getAll();

}
