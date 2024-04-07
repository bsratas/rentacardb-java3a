package com.tobeto.rentacar.business.dtos.requests.car;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedCarRequest {

    @NotNull
    @Min(value = 2000)
    private int modelYear;

    @NotNull
    @Size(min=3, max= 15)
    private String plate;

    @NotNull
    private int state;

    @NotNull
    private double dailyPrice;

    @NotNull
    private int modelId;
}
