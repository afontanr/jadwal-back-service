package com.jadwal.back.repositories;


import com.jadwal.back.repositories.entities.IntervalDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervalRepository extends JpaRepository<IntervalDto, String> {

  List<IntervalDto> findAll();
  IntervalDto findByIdInterval(String idInterval);
  IntervalDto save(IntervalDto intervalDto);
  void deleteByIdInterval(String idInterval);

}
