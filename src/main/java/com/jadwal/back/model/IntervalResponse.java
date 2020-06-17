package com.jadwal.back.model;

public class IntervalResponse {

  private String idInterval;
  private String description;

  public IntervalResponse() {
  }

  public IntervalResponse(String idInterval, String description) {
    this.idInterval = idInterval;
    this.description = description;
  }

  public String getIdInterval() {
    return idInterval;
  }

  public void setIdInterval(String idInterval) {
    this.idInterval = idInterval;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
