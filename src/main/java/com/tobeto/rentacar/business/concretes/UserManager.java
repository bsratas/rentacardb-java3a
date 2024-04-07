package com.tobeto.rentacar.business.concretes;

import com.tobeto.rentacar.business.abstracts.UserService;
import com.tobeto.rentacar.business.dtos.requests.user.CreatedUserRequest;
import com.tobeto.rentacar.business.dtos.responses.user.CreatedUserResponse;
import com.tobeto.rentacar.business.dtos.responses.user.GetAllUserResponse;
import com.tobeto.rentacar.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacar.dataAccess.abstracts.UserRepository;
import com.tobeto.rentacar.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserManager implements UserService {
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedUserResponse add(CreatedUserRequest request) {

        User user = this.modelMapperService.forRequest().map(request, User.class);
        user.setCreatedDate(LocalDateTime.now());
        User createdUser = this.userRepository.save(user);
        CreatedUserResponse createdUserResponse = this.modelMapperService.forResponse().map(createdUser, CreatedUserResponse.class);
        return createdUserResponse;

    }

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponse> response = users.stream().map(user -> modelMapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());
        return response;
    }
}
