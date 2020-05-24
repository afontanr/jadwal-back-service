package com.jadwal.back.service;

import com.jadwal.back.model.QuestionRequest;
import com.jadwal.back.model.QuestionResponse;
import com.jadwal.back.repositories.QuestionRepository;
import com.jadwal.back.repositories.entities.QuestionDto;
import com.jadwal.back.service.interfaces.QuestionService;
import com.jadwal.back.utils.Mapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

  private QuestionRepository questionRepository;

  @Autowired
  public QuestionServiceImpl(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }

  public List<QuestionResponse> findAllQuestions(String idExam){
    List<QuestionDto> questions = questionRepository.findAllByIdExam(idExam);
    return questions.stream().map(Mapper::mapToResponse).collect(Collectors.toList());
  }

  public List<QuestionResponse> findAllQuestionsFromUser(String idExam, String idUser){
    List<QuestionDto> questions = questionRepository.findAllByIdExamAndIdUser(idExam, idUser);
    return questions.stream().map(Mapper::mapToResponse).collect(Collectors.toList());
  }

  public QuestionResponse findQuestion(String idQuestion, String idExam){
    QuestionDto question = questionRepository.findByIdQuestionAndIdExam(idQuestion, idExam);
    if(Objects.isNull(question)){
      return null;
    }
    return Mapper.mapToResponse(question);
  }

  public QuestionResponse createQuestion(String idExam, QuestionRequest questionRequest){
    QuestionDto question = Mapper.mapToDto(idExam, questionRequest);
    question = questionRepository.save(question);
    return Mapper.mapToResponse(question);
  }

  public QuestionResponse modifyQuestion(String idQuestion, String idExam,
      QuestionRequest questionRequest){
    QuestionDto question = questionRepository.findByIdQuestionAndIdExam(idQuestion, idExam);

    if(Objects.isNull(question)){
      return null;
    }

    question.setIdUser(questionRequest.getIdUser());
    question.setDescription(questionRequest.getDescription());
    question = questionRepository.save(question);

    return Mapper.mapToResponse(question);
  }

  public void deleteQuestion(String idQuestion, String idExam){
    questionRepository.deleteByIdQuestionAndIdExam(idQuestion, idExam);
  }

}
