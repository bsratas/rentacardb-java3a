package com.tobeto.rentacar.api.controllers;

import com.tobeto.rentacar.business.abstracts.TransmissionService;
import com.tobeto.rentacar.business.dtos.requests.transmission.CreatedTransmissionRequest;
import com.tobeto.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import com.tobeto.rentacar.business.dtos.responses.transmission.GetAllTransmissionResponse;
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

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<GetAllTransmissionResponse> getAll(){
            return transmissionService.getAll();
        }
}
