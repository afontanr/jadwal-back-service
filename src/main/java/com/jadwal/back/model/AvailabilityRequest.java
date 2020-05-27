package com.jadwal.back.model;

public class AvailabilityRequest {

  private String idInterval;
  private String day;
  private Integer capacity;

  public AvailabilityRequest() {
  }

  public AvailabilityRequest(String idInterval, String day, Integer capacity) {
    this.idInterval = idInterval;
    this.day = day;
    this.capacity = capacity;
  }

  public String getIdInterval() {
    return idInterval;
  }

  public void setIdInterval(String idInterval) {
    this.idInterval = idInterval;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }
}
