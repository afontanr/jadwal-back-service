package com.jadwal.back.model;

public class QuestionRequest {

  private String idUser;
  private String description;

  public QuestionRequest() {
  }

  public QuestionRequest(String idUser, String description) {
    this.idUser = idUser;
    this.description = description;
  }

  public String getIdUser() {
    return idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
