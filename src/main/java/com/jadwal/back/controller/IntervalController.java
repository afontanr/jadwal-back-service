package com.jadwal.back.controller;

import com.jadwal.back.config.exception.EmptyListException;
import com.jadwal.back.config.exception.NotFoundException;
import com.jadwal.back.model.IntervalRequest;
import com.jadwal.back.model.IntervalResponse;
import com.jadwal.back.service.interfaces.IntervalService;
import com.jadwal.back.utils.Constants;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v0/intervals")
public class IntervalController {

  private IntervalService intervalService;

  @Autowired
  public IntervalController(IntervalService intervalService) {
    this.intervalService = intervalService;
  }

  @RequestMapping(method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<IntervalResponse> findAll(){
    List<IntervalResponse> intervals = intervalService.findAll();
    if(intervals.isEmpty()){
      throw new EmptyListException(Constants.EMPTY_LIST);
    }
    return intervals;
  }

  @RequestMapping(value = "/{idInterval}", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public IntervalResponse findInterval(@PathVariable("idInterval") String idInterval){
    IntervalResponse interval = intervalService.findInterval(idInterval);
    if(Objects.isNull(interval)){
      throw new NotFoundException(Constants.NOT_FOUND);
    }
    return interval;
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public IntervalResponse createInterval(IntervalRequest intervalRequest){
    return intervalService.createInterval(intervalRequest);
  }

  @RequestMapping(value = "/{idInterval}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public IntervalResponse modifyInterval(@PathVariable("idInterval") String idInterval,
      IntervalRequest intervalRequest){
    IntervalResponse interval = intervalService.modifyInterval(idInterval, intervalRequest);
    if(Objects.isNull(interval)){
      throw new NotFoundException(Constants.NOT_FOUND);
    }
    return interval;
  }

  @RequestMapping(value = "/{idInterval}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteInterval(@PathVariable("idInterval") String idInterval){
    intervalService.deleteInterval(idInterval);
  }

}
