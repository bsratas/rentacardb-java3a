package com.tobeto.rentacar.business.dtos.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedUserResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String companyName;
    private LocalDateTime createdDate;
}
