package com.tobeto.rentacar.business.dtos.requests.model;

import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedModelRequest {
    @NotNull
    @Size(min=3, max=30)
    private String name;

    @NotNull
    private int brandId;

    @NotNull
    private int fuelId;

    @NotNull
    private int transmissionId;
}
