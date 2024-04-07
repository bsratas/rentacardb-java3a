package com.tobeto.rentacar.api.controllers;

import com.tobeto.rentacar.business.abstracts.TransmissionService;
import com.tobeto.rentacar.business.dtos.requests.transmission.CreatedTransmissionRequest;
import com.tobeto.rentacar.business.dtos.requests.transmission.UpdateTransmissionRequest;
import com.tobeto.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import com.tobeto.rentacar.business.dtos.responses.transmission.GetAllTransmissionResponse;
import com.tobeto.rentacar.business.dtos.responses.transmission.GetTransmissionByIdResponse;
import com.tobeto.rentacar.business.dtos.responses.transmission.UpdateTransmissionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/transmissions")
public class TransmissionsController {
        private TransmissionService transmissionService;

        @PostMapping()
        @ResponseStatus(HttpStatus.CREATED)
        public CreatedTransmissionResponse add(@RequestBody @Valid CreatedTransmissionRequest request) {
            return transmissionService.add(request);
        }

        @GetMapping("getall")
        @ResponseStatus(HttpStatus.OK)
        public List<GetAllTransmissionResponse> getAll(){
            return transmissionService.getAll();
        }

        @GetMapping("/{id}")
        public GetTransmissionByIdResponse getTransmissionById(
                @PathVariable int id
        ) {
                return transmissionService.getTransmissionById(id);
        }

        @PutMapping("/{id}")
        public UpdateTransmissionResponse updateTransmissionById(
                @RequestBody UpdateTransmissionRequest request,
                @PathVariable int id
        ) {
                return transmissionService.updateTransmissionById(request,id);
        }
}
