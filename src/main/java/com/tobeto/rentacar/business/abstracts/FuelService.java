package com.tobeto.rentacar.business.abstracts;

import com.tobeto.rentacar.business.dtos.requests.fuel.CreatedFuelRequest;
import com.tobeto.rentacar.business.dtos.requests.fuel.UpdateFuelRequest;
import com.tobeto.rentacar.business.dtos.responses.fuel.CreatedFuelResponse;
import com.tobeto.rentacar.business.dtos.responses.fuel.GetAllFuelResponse;
import com.tobeto.rentacar.business.dtos.responses.fuel.GetFuelByIdResponse;
import com.tobeto.rentacar.business.dtos.responses.fuel.UpdateFuelResponse;

import java.util.List;

public interface FuelService {
    CreatedFuelResponse add(CreatedFuelRequest createdFuelRequest);

    List<GetAllFuelResponse> getAll();

    GetFuelByIdResponse getFuelById(
            int id
    );

    UpdateFuelResponse updateFuelById(
            UpdateFuelRequest request,
            int id
    );
}
