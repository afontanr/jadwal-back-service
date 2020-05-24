package com.jadwal.back.repositories.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class QuestionDto {

  @Id
  private String idQuestion;
  private String idUser;
  private String idExam;
  private String description;

  public QuestionDto() {
  }

  public QuestionDto(String idQuestion, String idUser, String idExam, String description) {
    this.idQuestion = idQuestion;
    this.idUser = idUser;
    this.idExam = idExam;
    this.description = description;
  }

  public String getIdQuestion() {
    return idQuestion;
  }

  public void setIdQuestion(String idQuestion) {
    this.idQuestion = idQuestion;
  }

  public String getIdUser() {
    return idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }

  public String getIdExam() {
    return idExam;
  }

  public void setIdExam(String idExam) {
    this.idExam = idExam;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
