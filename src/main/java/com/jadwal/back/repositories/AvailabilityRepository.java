package com.jadwal.back.repositories;

import com.jadwal.back.repositories.entities.AvailabilityDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailabilityRepository extends JpaRepository<AvailabilityDto, String> {

  List<AvailabilityDto> findAllByIdQuestion(String idQuestion);
  AvailabilityDto findByIdAvailabilityAndIdQuestion(String idAvailability, String idQuestion);
  AvailabilityDto save(AvailabilityDto availabilityDto);
  void deleteByIdAvailabilityAndIdQuestion(String idAvailability, String idQuestion);




}
