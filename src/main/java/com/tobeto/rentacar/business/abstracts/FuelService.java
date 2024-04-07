package com.tobeto.rentacar.business.abstracts;

import com.tobeto.rentacar.business.dtos.requests.fuel.CreatedFuelRequest;
import com.tobeto.rentacar.business.dtos.responses.fuel.CreatedFuelResponse;
import com.tobeto.rentacar.business.dtos.responses.fuel.GetAllFuelResponse;

import java.util.List;

public interface FuelService {
    CreatedFuelResponse add(CreatedFuelRequest createdFuelRequest);

    List<GetAllFuelResponse> getAll();
}
