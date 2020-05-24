package com.jadwal.back.service.interfaces;

import com.jadwal.back.model.IntervalRequest;
import com.jadwal.back.model.IntervalResponse;
import java.util.List;

public interface IntervalService {

  List<IntervalResponse> findAll();
  IntervalResponse findInterval(String idInterval);
  IntervalResponse createInterval(IntervalRequest intervalRequest);
  IntervalResponse modifyInterval(String idInterval, IntervalRequest intervalRequest);
  void deleteInterval(String idInterval);

}
