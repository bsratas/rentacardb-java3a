package com.tobeto.rentacar.business.abstracts;

import com.tobeto.rentacar.business.dtos.requests.model.CreatedModelRequest;
import com.tobeto.rentacar.business.dtos.requests.model.UpdateModelRequest;
import com.tobeto.rentacar.business.dtos.responses.model.CreatedModelResponse;
import com.tobeto.rentacar.business.dtos.responses.model.GetAllModelResponse;
import com.tobeto.rentacar.business.dtos.responses.model.GetModelByIdResponse;
import com.tobeto.rentacar.business.dtos.responses.model.UpdateModelResponse;

import java.util.List;

public interface ModelService {
    CreatedModelResponse add(CreatedModelRequest createdModelRequest);

    List<GetAllModelResponse> getAll();

    GetModelByIdResponse getModelById(
            int id
    );
    UpdateModelResponse updateModelById(
            UpdateModelRequest request,
            int id
    );
    void deleteModelById(
            int id
    );
}
