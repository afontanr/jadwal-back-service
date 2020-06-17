package com.jadwal.back.repositories;

import com.jadwal.back.repositories.entities.QuestionDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionDto, String> {

  List<QuestionDto> findAllByIdExam(String idExam);
  List<QuestionDto> findAllByIdExamAndIdUser(String idExam, String idUser);
  QuestionDto findByIdQuestionAndIdExam(String idQuestion, String idExam);
  QuestionDto save(QuestionDto questionDto);
  void deleteByIdQuestionAndIdExam(String idQuestion, String idExam);

}
