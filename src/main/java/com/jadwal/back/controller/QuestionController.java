package com.jadwal.back.controller;

import com.jadwal.back.config.exception.EmptyListException;
import com.jadwal.back.config.exception.NotFoundException;
import com.jadwal.back.model.QuestionRequest;
import com.jadwal.back.model.QuestionResponse;
import com.jadwal.back.service.interfaces.QuestionService;
import com.jadwal.back.utils.Constants;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v0/exams/{idExam}/questions")
public class QuestionController {

  private QuestionService questionService;

  @Autowired
  public QuestionController(QuestionService questionService) {
    this.questionService = questionService;
  }

  @RequestMapping(method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<QuestionResponse> findAll(@PathVariable("idExam") String idExam,
      @RequestParam(value = "idUser", required = false) String idUser){
    List<QuestionResponse> questions;

    if(Objects.isNull(idUser)){
      questions = questionService.findAllQuestions(idExam);
    } else {
      questions = questionService.findAllQuestionsFromUser(idExam, idUser);
    }
    if(questions.isEmpty()){
      throw new EmptyListException(Constants.EMPTY_LIST);
    }
    return questions;
  }
/*
  @RequestMapping(method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<QuestionResponse> findAllFromUser(@PathVariable("idExam") String idExam,
      @RequestParam(value = "idUser", required = true) String idUser){
    List<QuestionResponse> questions = questionService.findAllQuestionsFromUser(idExam, idUser);
    if(questions.isEmpty()){
      throw new EmptyListException(Constants.EMPTY_LIST);
    }
    return questions;
  }

 */

  @RequestMapping(value = "/{idQuestion}", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public QuestionResponse findQuestion(@PathVariable("idQuestion") String idQuestion,
      @PathVariable("idExam") String idExam){
    QuestionResponse question = questionService.findQuestion(idQuestion, idExam);
    if(Objects.isNull(question)){
      throw new NotFoundException(Constants.NOT_FOUND);
    }
    return question;
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public QuestionResponse createQuestion(@PathVariable("idExam") String idExam,
      @RequestBody QuestionRequest questionRequest){
    return questionService.createQuestion(idExam, questionRequest);
  }

  @RequestMapping(value = "/{idQuestion}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public QuestionResponse modifyQuestion(@PathVariable("idQuestion") String idQuestion,
      @PathVariable("idExam") String idExam, @RequestBody QuestionRequest questionRequest){
    QuestionResponse question = questionService.modifyQuestion(idQuestion, idExam, questionRequest);
    if(Objects.isNull(question)){
      throw new NotFoundException(Constants.NOT_FOUND);
    }
    return question;
  }

  @RequestMapping(value = "/{idQuestion}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteQuestion(@PathVariable("idQuestion") String idQuestion,
      @PathVariable("idExam") String idExam){
    questionService.deleteQuestion(idQuestion, idExam);
  }
}
