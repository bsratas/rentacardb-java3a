package com.tobeto.rentacar.api.controllers;

import com.tobeto.rentacar.business.abstracts.ModelService;
import com.tobeto.rentacar.business.dtos.requests.model.CreatedModelRequest;
import com.tobeto.rentacar.business.dtos.requests.model.UpdateModelRequest;
import com.tobeto.rentacar.business.dtos.responses.model.CreatedModelResponse;
import com.tobeto.rentacar.business.dtos.responses.model.GetAllModelResponse;
import com.tobeto.rentacar.business.dtos.responses.model.GetModelByIdResponse;
import com.tobeto.rentacar.business.dtos.responses.model.UpdateModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/models")
public class ModelsController {
    private ModelService modelService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedModelResponse add(@RequestBody @Valid CreatedModelRequest request) {
        return modelService.add(request);
    }

    @GetMapping("getall")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllModelResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public GetModelByIdResponse getModelById(
            @PathVariable int id
    ){
        return modelService.getModelById(id);
    }
    @PutMapping("/{id}")
    public UpdateModelResponse updateModelById(
            @RequestBody UpdateModelRequest request,
            @PathVariable int id
    ) {
        return modelService.updateModelById(request,id);
    }
    @DeleteMapping("/{id}")
    public void deleteModelById(
            @PathVariable int id
    ){
        modelService.deleteModelById(id);
    }
}
