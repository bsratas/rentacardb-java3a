package com.tobeto.rentacar.business.abstracts;

import com.tobeto.rentacar.business.dtos.requests.car.CreatedCarRequest;
import com.tobeto.rentacar.business.dtos.responses.car.GetAllCarResponse;
import com.tobeto.rentacar.business.dtos.responses.car.CreatedCarResponse;

import java.util.List;

public interface CarService {
    CreatedCarResponse add(CreatedCarRequest createdCarRequest);

    List<GetAllCarResponse> getAll();
}
