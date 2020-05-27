package com.jadwal.back.controller;

import com.jadwal.back.config.exception.EmptyListException;
import com.jadwal.back.config.exception.NotFoundException;
import com.jadwal.back.model.AvailabilityRequest;
import com.jadwal.back.model.AvailabilityResponse;
import com.jadwal.back.service.interfaces.AvailabilityService;
import com.jadwal.back.utils.Constants;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v0/exams/{idExam}/questions/{idQuestion}/availabilities")
public class AvailabilityController {

  private AvailabilityService availabilityService;

  @Autowired
  public AvailabilityController(AvailabilityService availabilityService) {
    this.availabilityService = availabilityService;
  }

  @RequestMapping(method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<AvailabilityResponse> findAll(@PathVariable("idQuestion") String idQuestion){
    List<AvailabilityResponse> availabilities = availabilityService.findAll(idQuestion);
    if(availabilities.isEmpty()){
      throw new EmptyListException(Constants.EMPTY_LIST);
    }
    return availabilities;
  }

  @RequestMapping(value = "/{idAvailability}", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public AvailabilityResponse findAvailability(@PathVariable("idQuestion") String idQuestion,
      @PathVariable("idAvailability") String idAvailability){
    AvailabilityResponse availability = availabilityService
        .findAvailability(idAvailability, idQuestion);
    if(Objects.isNull(availability)){
      throw new NotFoundException(Constants.NOT_FOUND);
    }
    return availability;
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public AvailabilityResponse createAvailability(@PathVariable("idQuestion") String idQuestion,
      @RequestBody AvailabilityRequest availabilityRequest){
    return availabilityService.createAvailability(idQuestion, availabilityRequest);
  }

  @RequestMapping(value = "/{idAvailability}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public AvailabilityResponse modifyAvailability(@PathVariable("idQuestion") String idQuestion,
      @PathVariable("idAvailability") String idAvailability,
      @RequestBody AvailabilityRequest availabilityRequest){
    AvailabilityResponse availability = availabilityService
        .modifyAvailability(idAvailability, idQuestion, availabilityRequest);
    if(Objects.isNull(availability)){
      throw new NotFoundException(Constants.NOT_FOUND);
    }
    return availability;
  }

  @RequestMapping(value = "/{idAvailability}", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAvailability(@PathVariable("idQuestion") String idQuestion,
      @PathVariable("idAvailability") String idAvailability){
    availabilityService.deleteAvailability(idAvailability, idQuestion);
  }

}
