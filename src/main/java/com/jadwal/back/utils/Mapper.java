package com.jadwal.back.utils;

import com.jadwal.back.model.ExamRequest;
import com.jadwal.back.model.ExamResponse;
import com.jadwal.back.model.UserRequest;
import com.jadwal.back.model.UserResponse;
import com.jadwal.back.repositories.entities.ExamDto;
import com.jadwal.back.repositories.entities.TokenDto;
import com.jadwal.back.repositories.entities.UserDto;
import com.jadwal.back.utils.supplier.SessionSupplier;

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

  public static ExamDto mapToDto(ExamRequest examRequest){
    return new ExamDto(StringGenerator.generateId(), examRequest.getName(), examRequest.getDate(),
        examRequest.getDateStart(), examRequest.getDateEnd());
  }

  public static UserResponse mapToResponse(UserDto userDto){
    return new UserResponse(userDto.getIdUser(), userDto.getName(), userDto.getSurname(),
        userDto.getEmail(), userDto.getOffice(), SessionSupplier.isAdmin(userDto.getIdRol()));
  }

  public static ExamResponse mapToResponse(ExamDto examDto){
    return new ExamResponse(examDto.getIdExam(), examDto.getName(), examDto.getDate(),
        examDto.getDateStart(), examDto.getDateEnd());
  }

}
