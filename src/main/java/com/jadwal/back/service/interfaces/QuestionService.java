package com.jadwal.back.service.interfaces;

import com.jadwal.back.model.QuestionRequest;
import com.jadwal.back.model.QuestionResponse;
import java.util.List;

public interface QuestionService {

  List<QuestionResponse> findAllQuestions(String idExam);
  List<QuestionResponse> findAllQuestionsFromUser(String idExam, String idUser);
  QuestionResponse findQuestion(String idQuestion, String idExam);
  QuestionResponse createQuestion(String idExam, QuestionRequest questionRequest);
  QuestionResponse modifyQuestion(String idQuestion, String idExam, QuestionRequest questionRequest);
  void deleteQuestion(String idQuestion, String idExam);

}
