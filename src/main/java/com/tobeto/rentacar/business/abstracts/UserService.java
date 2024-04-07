package com.tobeto.rentacar.business.abstracts;

import com.tobeto.rentacar.business.dtos.requests.user.CreatedUserRequest;
import com.tobeto.rentacar.business.dtos.responses.user.CreatedUserResponse;
import com.tobeto.rentacar.business.dtos.responses.user.GetAllUserResponse;

import java.util.List;

public interface UserService {
    CreatedUserResponse add(CreatedUserRequest request);

    List<GetAllUserResponse> getAll();
}
