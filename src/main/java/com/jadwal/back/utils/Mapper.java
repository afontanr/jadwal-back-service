package com.jadwal.back.utils;

import com.jadwal.back.model.AvailabilityRequest;
import com.jadwal.back.model.AvailabilityResponse;
import com.jadwal.back.model.ExamRequest;
import com.jadwal.back.model.ExamResponse;
import com.jadwal.back.model.IntervalRequest;
import com.jadwal.back.model.IntervalResponse;
import com.jadwal.back.model.QuestionRequest;
import com.jadwal.back.model.QuestionResponse;
import com.jadwal.back.model.UserRequest;
import com.jadwal.back.model.UserResponse;
import com.jadwal.back.repositories.entities.AvailabilityDto;
import com.jadwal.back.repositories.entities.ExamDto;
import com.jadwal.back.repositories.entities.IntervalDto;
import com.jadwal.back.repositories.entities.QuestionDto;
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

  public static QuestionDto mapToDto(String idExam, QuestionRequest questionRequest){
    return new QuestionDto(StringGenerator.generateId(), questionRequest.getIdUser(),
        idExam, questionRequest.getDescription());
  }

  public static AvailabilityDto mapToDto(String idQuestion, AvailabilityRequest availabilityRequest){
    return new AvailabilityDto(StringGenerator.generateId(), idQuestion,
        availabilityRequest.getIdInterval(), availabilityRequest.getDay(),
        availabilityRequest.getCapacity(), 0);
  }

  public static IntervalDto mapToDto(IntervalRequest intervalRequest){
    return new IntervalDto(StringGenerator.generateId(), intervalRequest.getDescription());
  }

  public static UserResponse mapToResponse(UserDto userDto){
    return new UserResponse(userDto.getIdUser(), userDto.getName(), userDto.getSurname(),
        userDto.getEmail(), userDto.getOffice(), SessionSupplier.isAdmin(userDto.getIdRol()));
  }

  public static ExamResponse mapToResponse(ExamDto examDto){
    return new ExamResponse(examDto.getIdExam(), examDto.getName(), examDto.getDate(),
        examDto.getDateStart(), examDto.getDateEnd());
  }

  public static QuestionResponse mapToResponse(QuestionDto questionDto){
    return new QuestionResponse(questionDto.getIdQuestion(), questionDto.getIdUser(),
        questionDto.getIdExam(), questionDto.getDescription());
  }

  public static IntervalResponse mapToResponse(IntervalDto intervalDto){
    return new IntervalResponse(intervalDto.getIdInterval(), intervalDto.getDescription());
  }

  public static AvailabilityResponse mapToResponse(AvailabilityDto availabilityDto){
    return new AvailabilityResponse(availabilityDto.getIdAvailability(),
        availabilityDto.getIdQuestion(), availabilityDto.getIdInterval(),
        availabilityDto.getDay(), availabilityDto.getCapacity(), availabilityDto.getCounter());
  }

}
