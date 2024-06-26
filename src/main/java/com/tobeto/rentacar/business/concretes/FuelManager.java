package com.tobeto.rentacar.business.concretes;

import com.tobeto.rentacar.business.abstracts.FuelService;
import com.tobeto.rentacar.business.dtos.requests.fuel.CreatedFuelRequest;
import com.tobeto.rentacar.business.dtos.responses.fuel.CreatedFuelResponse;
import com.tobeto.rentacar.business.dtos.responses.fuel.GetAllFuelResponse;
import com.tobeto.rentacar.business.rules.FuelBusinessRules;
import com.tobeto.rentacar.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacar.dataAccess.abstracts.FuelRepository;
import com.tobeto.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    private FuelRepository fuelRepository;
    private ModelMapperService modelMapperService;
    private FuelBusinessRules fuelBusinessRules;


    @Override
    public CreatedFuelResponse add(CreatedFuelRequest createdFuelRequest) {
        fuelBusinessRules.fuelNameCanNotBeDuplicated(createdFuelRequest.getName());
        Fuel fuel = this.modelMapperService.forRequest().map(createdFuelRequest, Fuel.class);
        fuel.setCreatedDate(LocalDateTime.now());
        Fuel createdFuel = this.fuelRepository.save(fuel);
        CreatedFuelResponse createdFuelResponse =
                this.modelMapperService.forResponse().map(createdFuel,
                        CreatedFuelResponse.class);
        return createdFuelResponse;
    }

    @Override
    public List<GetAllFuelResponse> getAll() {
        List<Fuel> fuels = fuelRepository.findAll();
        List<GetAllFuelResponse> response =
                fuels.stream().map(fuel -> modelMapperService.forResponse().map(fuel, GetAllFuelResponse.class)).collect(Collectors.toList());
        return response;
    }
}
