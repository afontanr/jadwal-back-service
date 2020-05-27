package com.jadwal.back.service;

import com.jadwal.back.model.AvailabilityRequest;
import com.jadwal.back.model.AvailabilityResponse;
import com.jadwal.back.repositories.AvailabilityRepository;
import com.jadwal.back.repositories.entities.AvailabilityDto;
import com.jadwal.back.service.interfaces.AvailabilityService;
import com.jadwal.back.utils.Mapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

  private AvailabilityRepository availabilityRepository;

  @Autowired
  public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository) {
    this.availabilityRepository = availabilityRepository;
  }

  public List<AvailabilityResponse> findAll(String idQuestion){
    List<AvailabilityDto> availabilities = availabilityRepository.findAllByIdQuestion(idQuestion);
    return availabilities.stream().map(Mapper::mapToResponse).collect(Collectors.toList());
  }

  public AvailabilityResponse findAvailability(String idAvailability, String idQuestion){
    AvailabilityDto availability = availabilityRepository
        .findByIdAvailabilityAndIdQuestion(idAvailability, idQuestion);
    if(Objects.isNull(availability)){
      return null;
    }
    return Mapper.mapToResponse(availability);
  }

  public AvailabilityResponse createAvailability(String idQuestion,
      AvailabilityRequest availabilityRequest){
    AvailabilityDto availability = Mapper.mapToDto(idQuestion, availabilityRequest);
    availability = availabilityRepository.save(availability);
    return Mapper.mapToResponse(availability);
  }

  public AvailabilityResponse modifyAvailability(String idAvailability, String idQuestion,
      AvailabilityRequest availabilityRequest){
    AvailabilityDto availability = availabilityRepository
        .findByIdAvailabilityAndIdQuestion(idAvailability, idQuestion);
    if(Objects.isNull(availability)){
      return null;
    }
    availability.setIdInterval(availabilityRequest.getIdInterval());
    availability.setCapacity(availabilityRequest.getCapacity());
    availability.setDay(availabilityRequest.getDay());

    availability = availabilityRepository.save(availability);

    return Mapper.mapToResponse(availability);
  }

  public void deleteAvailability(String idAvailability, String idQuestion){
    availabilityRepository.deleteByIdAvailabilityAndIdQuestion(idAvailability, idQuestion);
  }
}
