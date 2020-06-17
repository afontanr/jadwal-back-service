package com.jadwal.back.repositories;

import com.jadwal.back.repositories.entities.ExamDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<ExamDto, String> {

  List<ExamDto> findAll();
  ExamDto findByIdExam(String idExam);
  ExamDto save(ExamDto examDto);
  void deleteAll();
  void deleteByIdExam(String idExam);

}
