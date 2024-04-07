package com.tobeto.rentacar.api.controllers;

import com.tobeto.rentacar.business.abstracts.UserService;
import com.tobeto.rentacar.business.dtos.requests.user.CreatedUserRequest;
import com.tobeto.rentacar.business.dtos.responses.user.CreatedUserResponse;
import com.tobeto.rentacar.business.dtos.responses.user.GetAllUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedUserResponse add(@Valid @RequestBody CreatedUserRequest request){
        return userService.add(request);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllUserResponse> getAll(){
        return userService.getAll();
    }
}
