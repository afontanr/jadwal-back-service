package com.jadwal.back.service.interfaces;

import com.jadwal.back.model.AvailabilityRequest;
import com.jadwal.back.model.AvailabilityResponse;
import java.util.List;

public interface AvailabilityService {

  List<AvailabilityResponse> findAll(String idQuestion);
  AvailabilityResponse findAvailability(String idAvailability, String idQuestion);
  AvailabilityResponse createAvailability(String idQuestion, AvailabilityRequest availabilityRequest);
  AvailabilityResponse modifyAvailability(String idAvailability, String idQuestion, AvailabilityRequest availabilityRequest);
  void deleteAvailability(String idAvailability, String idQuestion);

}
