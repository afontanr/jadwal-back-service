package com.jadwal.back.utils;

import com.jadwal.back.model.UserRequest;
import com.jadwal.back.model.UserResponse;
import com.jadwal.back.repositories.entities.UserDto;

public class UserMapper {

  private UserMapper() {  }

  public static UserDto mapUserRequestToUserDto(UserRequest userRequest, String idState){
    return new UserDto(StringGenerator.generateId(), userRequest.getIdRol(), idState,
        userRequest.getName(), userRequest.getSurname(), userRequest.getEmail(),
        userRequest.getOffice(), userRequest.getNewPassword());
  }

  public static UserResponse mapUserDtoToUserResponse(UserDto userDto){
    return new UserResponse(userDto.getIdUser(), userDto.getName(), userDto.getSurname(),
        userDto.getEmail(), userDto.getOffice());
  }

}
