package com.jadwal.back.model;

import com.jadwal.back.utils.Date;

public class ExamRequest {

  private String name;
  @Date private String date;
  @Date private String dateStart;
  @Date private String dateEnd;

  public ExamRequest() {
  }

  public ExamRequest(String name, String date, String dateStart, String dateEnd) {
    this.name = name;
    this.date = date;
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
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
