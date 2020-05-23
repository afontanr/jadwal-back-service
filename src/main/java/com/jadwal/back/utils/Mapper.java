package com.jadwal.back.utils;

import com.jadwal.back.model.UserRequest;
import com.jadwal.back.model.UserResponse;
import com.jadwal.back.repositories.entities.TokenDto;
import com.jadwal.back.repositories.entities.UserDto;

public class Mapper {

  private Mapper() {  }

  public static UserDto mapToDto(UserRequest userRequest, String idState){
    return new UserDto(StringGenerator.generateId(), userRequest.getIdRol(), idState,
        userRequest.getName(), userRequest.getSurname(), userRequest.getEmail(),
        userRequest.getOffice(), Constants.EMPTY);
  }
  public static TokenDto mapToDto(UserDto userDto, String token){
    return new TokenDto(token, userDto.getIdUser(), userDto.getIdRol());
  }

  public static UserResponse mapToResponse(UserDto userDto){
    return new UserResponse(userDto.getIdUser(), userDto.getName(), userDto.getSurname(),
        userDto.getEmail(), userDto.getOffice(), isAdmin(userDto.getIdRol()));
  }

  public static Boolean isAdmin(String idRol){
    return Constants.ID_ADMIN_ROL.equals(idRol);
  }



}
