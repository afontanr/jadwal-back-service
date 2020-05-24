package com.jadwal.back.service;

import com.jadwal.back.model.IntervalRequest;
import com.jadwal.back.model.IntervalResponse;
import com.jadwal.back.repositories.IntervalRepository;
import com.jadwal.back.repositories.entities.IntervalDto;
import com.jadwal.back.service.interfaces.IntervalService;
import com.jadwal.back.utils.Mapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntervalServiceImpl implements IntervalService {

  private IntervalRepository intervalRepository;

  @Autowired
  public IntervalServiceImpl(IntervalRepository intervalRepository) {
    this.intervalRepository = intervalRepository;
  }

  public List<IntervalResponse> findAll(){
    List<IntervalDto> intervals = intervalRepository.findAll();
    return intervals.stream().map(Mapper::mapToResponse).collect(Collectors.toList());
  }

  public IntervalResponse findInterval(String idInterval){
    IntervalDto interval = intervalRepository.findByIdInterval(idInterval);
    if(Objects.isNull(interval)){
      return null;
    }
    return Mapper.mapToResponse(interval);
  }

  public IntervalResponse createInterval(IntervalRequest intervalRequest){
    IntervalDto interval = Mapper.mapToDto(intervalRequest);
    interval = intervalRepository.save(interval);
    return Mapper.mapToResponse(interval);
  }

  public IntervalResponse modifyInterval(String idInterval, IntervalRequest intervalRequest){
    IntervalDto interval = intervalRepository.findByIdInterval(idInterval);
    if(Objects.isNull(interval)){
      return null;
    }
    interval.setDescription(intervalRequest.getDescription());
    interval = intervalRepository.save(interval);
    return Mapper.mapToResponse(interval);
  }

  public void deleteInterval(String idInterval){
    intervalRepository.deleteByIdInterval(idInterval);
  }

}
