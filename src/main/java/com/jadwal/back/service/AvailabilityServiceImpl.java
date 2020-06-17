package com.jadwal.back.service;

import com.jadwal.back.model.AvailabilityRequest;
import com.jadwal.back.model.AvailabilityResponse;
import com.jadwal.back.repositories.AvailabilityRepository;
import com.jadwal.back.repositories.IntervalRepository;
import com.jadwal.back.repositories.entities.AvailabilityDto;
import com.jadwal.back.repositories.entities.IntervalDto;
import com.jadwal.back.service.interfaces.AvailabilityService;
import com.jadwal.back.utils.Mapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

  private AvailabilityRepository availabilityRepository;
  private IntervalRepository intervalRepository;

  @Autowired
  public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository,
      IntervalRepository intervalRepository) {
    this.availabilityRepository = availabilityRepository;
    this.intervalRepository = intervalRepository;
  }

  public List<AvailabilityResponse> findAll(String idQuestion){
    List<AvailabilityDto> availabilities = availabilityRepository.findAllByIdQuestion(idQuestion);
    List<IntervalDto> interval = intervalRepository.findAll();
    return availabilities.stream().map(it -> Mapper
        .mapToResponse(it, interval.stream()
            .filter(x -> x.getIdInterval().equals(it.getIdInterval()))
            .collect(Collectors.toList()).get(0).getDescription()) )
        .collect(Collectors.toList());
  }

  public AvailabilityResponse findAvailability(String idAvailability, String idQuestion){
    AvailabilityDto availability = availabilityRepository
        .findByIdAvailabilityAndIdQuestion(idAvailability, idQuestion);
    if(Objects.isNull(availability)){
      return null;
    }
    IntervalDto interval = intervalRepository.findByIdInterval(availability.getIdInterval());

    return Mapper.mapToResponse(availability, interval.getDescription());
  }

  public AvailabilityResponse createAvailability(String idQuestion,
      AvailabilityRequest availabilityRequest){
    AvailabilityDto availability = Mapper.mapToDto(idQuestion, availabilityRequest);
    availability = availabilityRepository.save(availability);
    IntervalDto interval = intervalRepository.findByIdInterval(availability.getIdInterval());
    return Mapper.mapToResponse(availability, interval.getDescription());
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
    IntervalDto interval = intervalRepository.findByIdInterval(availability.getIdInterval());
    return Mapper.mapToResponse(availability, interval.getDescription());
  }


  @Transactional
  public void deleteAvailability(String idAvailability, String idQuestion){
    availabilityRepository.deleteByIdAvailabilityAndIdQuestion(idAvailability, idQuestion);
  }
}
