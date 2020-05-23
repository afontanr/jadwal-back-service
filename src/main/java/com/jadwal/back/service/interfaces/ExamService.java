package com.jadwal.back.service.interfaces;

import com.jadwal.back.model.ExamRequest;
import com.jadwal.back.model.ExamResponse;
import java.util.List;

public interface ExamService {

  List<ExamResponse> findAll();
  ExamResponse findExam(String idExam);
  ExamResponse createExam(ExamRequest examRequest);
  ExamResponse modifyExam(String idExam, ExamRequest examRequest);
  void deleteExam(String idExam);

}
