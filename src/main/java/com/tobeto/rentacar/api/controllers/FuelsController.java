package com.tobeto.rentacar.api.controllers;

import com.tobeto.rentacar.business.abstracts.FuelService;
import com.tobeto.rentacar.business.dtos.requests.fuel.CreatedFuelRequest;
import com.tobeto.rentacar.business.dtos.responses.fuel.CreatedFuelResponse;
import com.tobeto.rentacar.business.dtos.responses.fuel.GetAllFuelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fuels")
public class FuelsController {
        private FuelService fuelService;

        @PostMapping()
        @ResponseStatus(HttpStatus.CREATED)
        public CreatedFuelResponse add(@RequestBody @Valid CreatedFuelRequest request) {
            return fuelService.add(request);
        }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<GetAllFuelResponse> getAll(){
            return fuelService.getAll();
        }
}
