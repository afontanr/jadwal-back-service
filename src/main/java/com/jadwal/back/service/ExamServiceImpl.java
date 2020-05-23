package com.jadwal.back.service;

import com.jadwal.back.model.ExamRequest;
import com.jadwal.back.model.ExamResponse;
import com.jadwal.back.repositories.ExamRepository;
import com.jadwal.back.repositories.entities.ExamDto;
import com.jadwal.back.service.interfaces.ExamService;
import com.jadwal.back.utils.Mapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

  private ExamRepository examRepository;

  @Autowired
  public ExamServiceImpl(ExamRepository examRepository) {
    this.examRepository = examRepository;
  }

  public List<ExamResponse> findAll(){
    return examRepository.findAll()
        .stream()
        .map(Mapper::mapToResponse)
        .collect(Collectors.toList());
  }

  public ExamResponse findExam(String idExam){
    ExamDto examDto = examRepository.findByIdExam(idExam);
    return Mapper.mapToResponse(examDto);
  }

  public ExamResponse createExam(ExamRequest examRequest){
    ExamDto examDto = examRepository.save(Mapper.mapToDto(examRequest));

    if(Objects.isNull(examDto)){
      return null;
    }

    return Mapper.mapToResponse(examDto);
  }

  public ExamResponse modifyExam(String idExam, ExamRequest examRequest){
    ExamDto examDto = examRepository.findByIdExam(idExam);

    if(Objects.isNull(examDto)){
      return null;
    }

    examDto.setName(examRequest.getName());
    examDto.setDate(examRequest.getDate());
    examDto.setDateStart(examRequest.getDateStart());
    examDto.setDateEnd(examRequest.getDateEnd());

    examDto = examRepository.save(examDto);

    return Mapper.mapToResponse(examDto);
  }

  public void deleteExam(String idExam){
    examRepository.deleteByIdExam(idExam);
  }


}
