package com.tobeto.rentacar.business.concretes;

import com.tobeto.rentacar.business.abstracts.ModelService;
import com.tobeto.rentacar.business.dtos.requests.model.CreatedModelRequest;
import com.tobeto.rentacar.business.dtos.responses.model.CreatedModelResponse;
import com.tobeto.rentacar.business.dtos.responses.model.GetAllModelResponse;
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
    public CreatedModelResponse add(CreatedModelRequest createModelRequest) {

        modelBusinessRules.modelNameCanNotBeDuplicated(createModelRequest.getName());
        modelBusinessRules.checkIfBrandExists(createModelRequest.getBrandId());
        modelBusinessRules.checkIfFuelExists(createModelRequest.getFuelId());
        modelBusinessRules.checkIfTransmissionExists(createModelRequest.getTransmissionId());

        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        model.setCreatedDate(LocalDateTime.now());
        Model createdModel = this.modelRepository.save(model);
        CreatedModelResponse createdModelResponse = this.modelMapperService.forResponse().map(createdModel, CreatedModelResponse.class);
        return createdModelResponse;
    }

    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelResponse> response = models.stream().map(model -> modelMapperService.forResponse().map(model, GetAllModelResponse.class)).collect(Collectors.toList());
        return response;
    }
}
