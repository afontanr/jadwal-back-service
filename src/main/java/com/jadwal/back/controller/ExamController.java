package com.jadwal.back.controller;

import com.jadwal.back.config.exception.EmptyListException;
import com.jadwal.back.config.exception.NotFoundException;
import com.jadwal.back.model.ExamRequest;
import com.jadwal.back.model.ExamResponse;
import com.jadwal.back.service.interfaces.ExamService;
import com.jadwal.back.utils.Constants;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v0/exams")
public class ExamController {

  private ExamService examService;

  @Autowired
  public ExamController(ExamService examService) {
    this.examService = examService;
  }

  @RequestMapping(method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<ExamResponse> findAllExams(){
    List<ExamResponse> response = examService.findAll();
    if(response.isEmpty()){
      throw new EmptyListException(Constants.EMPTY_LIST);
    }
    return response;
  }

  @RequestMapping(value = "/{idExam}", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public ExamResponse findExam(@PathVariable("idExam") String idExam){
    ExamResponse response = examService.findExam(idExam);
    if(Objects.isNull(response)){
      throw new NotFoundException(Constants.NOT_FOUND);
    }
    return response;
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public ExamResponse createExam(@RequestBody ExamRequest examRequest){
    return examService.createExam(examRequest);
  }

  @RequestMapping(value = "/{idExam}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public ExamResponse modifyExam(@PathVariable("idExam") String idExam, @RequestBody ExamRequest examRequest){
    ExamResponse response = examService.modifyExam(idExam, examRequest);
    if(Objects.isNull(response)){
      throw new NotFoundException(Constants.NOT_FOUND);
    }
    return response;
  }

  @RequestMapping(value = "/{idExam}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteExam(@PathVariable("idExam") String idExam){
    examService.deleteExam(idExam);
  }

}
