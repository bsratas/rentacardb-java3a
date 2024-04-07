package com.tobeto.rentacar.business.concretes;

import com.tobeto.rentacar.business.abstracts.CarService;
import com.tobeto.rentacar.business.dtos.requests.car.CreatedCarRequest;
import com.tobeto.rentacar.business.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentacar.business.dtos.responses.car.CreatedCarResponse;
import com.tobeto.rentacar.business.dtos.responses.car.GetAllCarResponse;
import com.tobeto.rentacar.business.dtos.responses.car.GetCarByIdResponse;
import com.tobeto.rentacar.business.dtos.responses.car.UpdateCarResponse;
import com.tobeto.rentacar.business.rules.CarBusinessRules;
import com.tobeto.rentacar.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacar.dataAccess.abstracts.CarRepository;
import com.tobeto.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private CarBusinessRules carBusinessRules;


    @Override
    public CreatedCarResponse add(CreatedCarRequest createdCarRequest) {
        carBusinessRules.carPlateCanNotBeDuplicated(createdCarRequest.getPlate());
        Car car = this.modelMapperService.forRequest().map(createdCarRequest, Car.class);
        car.setCreatedDate(LocalDateTime.now());
        Car createdCar = this.carRepository.save(car);
        CreatedCarResponse createdCarResponse = this.modelMapperService.forResponse().map(createdCar, CreatedCarResponse.class);
        return createdCarResponse;
    }

    @Override
    public List<GetAllCarResponse> getAll() {
        List<Car>  cars = carRepository.findAll();
        List<GetAllCarResponse> response = cars.stream().map(car -> modelMapperService.forResponse().map(car, GetAllCarResponse.class)).collect(Collectors.toList());
        return response;
    }

    @Override
    public GetCarByIdResponse getCarById(
            int id
    ) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There no car for this ID."));

        GetCarByIdResponse response = modelMapperService.forResponse()
                .map(car,GetCarByIdResponse.class);

        return response;
    }

    @Override
    public UpdateCarResponse updateCarById(
            UpdateCarRequest request,
            int id
    ) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no car for this ID."));

        Car updatedCar = modelMapperService.forRequest()
                .map(request, Car.class);

        car.setId(id);
        car.setUpdatedDate(LocalDateTime.now());

        car.setPlate(updatedCar.getPlate());
        car.setState(updatedCar.getState());
        car.setDailyPrice(updatedCar.getDailyPrice());

        carRepository.save(car);

        UpdateCarResponse response = modelMapperService.forResponse()
                .map(car, UpdateCarResponse.class);

        return response;
    }
}
