package com.tobeto.rentacar.business.concretes;

import com.tobeto.rentacar.business.abstracts.ModelService;
import com.tobeto.rentacar.business.dtos.requests.model.CreatedModelRequest;
import com.tobeto.rentacar.business.dtos.requests.model.UpdateModelRequest;
import com.tobeto.rentacar.business.dtos.responses.model.CreatedModelResponse;
import com.tobeto.rentacar.business.dtos.responses.model.GetAllModelResponse;
import com.tobeto.rentacar.business.dtos.responses.model.GetModelByIdResponse;
import com.tobeto.rentacar.business.dtos.responses.model.UpdateModelResponse;
import com.tobeto.rentacar.business.rules.ModelBusinessRules;
import com.tobeto.rentacar.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacar.dataAccess.abstracts.ModelRepository;
import com.tobeto.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    private ModelBusinessRules modelBusinessRules;


    @Override
    public CreatedModelResponse add(CreatedModelRequest createdModelRequest) {
        modelBusinessRules.ModelNameAndAttributesCanNotBeDuplicated(createdModelRequest.getName(),
                createdModelRequest.getBrandId(),
                createdModelRequest.getFuelId(),
                createdModelRequest.getTransmissionId());
        Model model =
                this.modelMapperService.forRequest().map(createdModelRequest,
                        Model.class);
        model.setCreatedDate(LocalDateTime.now());
        Model createdModel = this.modelRepository.save(model);
        CreatedModelResponse createdModelResponse =
                this.modelMapperService.forResponse().map(createdModel,
                        CreatedModelResponse.class);
        return createdModelResponse;
    }

    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelResponse> response =
                models.stream().map(model -> modelMapperService.forResponse().map(model, GetAllModelResponse.class)).collect(Collectors.toList());
        return response;
    }

    @Override
    public GetModelByIdResponse getModelById(
            int id
    ) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no model for this ID."));

        GetModelByIdResponse response = modelMapperService.forResponse()
                .map(model, GetModelByIdResponse.class);

        return  response;
    }

    @Override
    public UpdateModelResponse updateModelById(
            UpdateModelRequest request,
            int id
    ) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no model for this id."));

        Model updatedModel = modelMapperService.forRequest()
                .map(request,Model.class);

        model.setId(id);
        model.setCreatedDate(LocalDateTime.now());

        model.setName(updatedModel.getName() != null ? updatedModel.getName() : model.getName());

        modelRepository.save(model);

        UpdateModelResponse response = modelMapperService.forResponse()
                .map(model,UpdateModelResponse.class);

        return response;

    }

    @Override
    public void deleteModelById(
            int id
    ) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no model for this id."));

        model.setDeletedDate(LocalDateTime.now());

        modelRepository.deleteById(id);
    }
}
