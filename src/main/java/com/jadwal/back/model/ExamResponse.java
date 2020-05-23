package com.jadwal.back.model;

public class ExamResponse {

  private String idExam;
  private String name;
  private String date;
  private String dateStart;
  private String dateEnd;

  public ExamResponse() {
  }

  public ExamResponse(String idExam, String name, String date, String dateStart,
      String dateEnd) {
    this.idExam = idExam;
    this.name = name;
    this.date = date;
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
  }

  public String getIdExam() {
    return idExam;
  }

  public void setIdExam(String idExam) {
    this.idExam = idExam;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDateStart() {
    return dateStart;
  }

  public void setDateStart(String dateStart) {
    this.dateStart = dateStart;
  }

  public String getDateEnd() {
    return dateEnd;
  }

  public void setDateEnd(String dateEnd) {
    this.dateEnd = dateEnd;
  }
}
