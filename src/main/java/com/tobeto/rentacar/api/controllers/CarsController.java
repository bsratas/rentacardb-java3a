package com.tobeto.rentacar.api.controllers;

import com.tobeto.rentacar.business.abstracts.CarService;
import com.tobeto.rentacar.business.dtos.requests.car.CreatedCarRequest;
import com.tobeto.rentacar.business.dtos.responses.car.CreatedCarResponse;
import com.tobeto.rentacar.business.dtos.responses.car.GetAllCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cars")
public class CarsController {
        private CarService carService;

        @PostMapping()
        @ResponseStatus(HttpStatus.CREATED)
        public CreatedCarResponse add(@RequestBody @Valid CreatedCarRequest request) {
            return carService.add(request);
        }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<GetAllCarResponse> getAll(){
                return carService.getAll();
        }
}
