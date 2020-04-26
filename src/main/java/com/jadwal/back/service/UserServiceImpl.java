package com.jadwal.back.service;

import com.jadwal.back.model.UserRequest;
import com.jadwal.back.model.UserResponse;
import com.jadwal.back.repositories.UserRepository;
import com.jadwal.back.repositories.entities.UserDto;
import com.jadwal.back.service.interfaces.UserService;
import com.jadwal.back.utils.Constants;
import com.jadwal.back.utils.UserMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;


  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserResponse saveUser(UserRequest userRequest) {
    UserDto userDto =  UserMapper.mapUserRequestToUserDto(userRequest, Constants.ID_STATE_STAND_BY);
    userDto = userRepository.save(userDto);
    return UserMapper.mapUserDtoToUserResponse(userDto);
  }

  public List<UserResponse> getAllUsers(){
    List<UserDto> listUsers = userRepository.findAll();
    return listUsers.stream().map(UserMapper::mapUserDtoToUserResponse)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public UserResponse getUserById(String idUser) {
    UserDto user = userRepository.findByIdUser(idUser);
    return UserMapper.mapUserDtoToUserResponse(user);
  }

}
