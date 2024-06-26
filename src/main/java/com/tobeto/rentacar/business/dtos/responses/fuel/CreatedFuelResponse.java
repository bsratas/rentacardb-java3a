package com.tobeto.rentacar.business.dtos.responses.fuel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedFuelResponse {
    int id;
    private String name;
    private LocalDateTime createdDate;
}
