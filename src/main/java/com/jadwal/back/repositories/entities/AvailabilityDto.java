package com.jadwal.back.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "availabilities")
public class AvailabilityDto {

  @Id
  private String idAvailability;
  private String idQuestion;
  private String idInterval;
  private String day;
  private Integer capacity;
  private Integer counter;

  public AvailabilityDto() {
  }

  public AvailabilityDto(String idAvailability, String idQuestion, String idInterval,
      String day, Integer capacity, Integer counter) {
    this.idAvailability = idAvailability;
    this.idQuestion = idQuestion;
    this.idInterval = idInterval;
    this.day = day;
    this.capacity = capacity;
    this.counter = counter;
  }

  public String getIdAvailability() {
    return idAvailability;
  }

  public void setIdAvailability(String idAvailability) {
    this.idAvailability = idAvailability;
  }

  public String getIdQuestion() {
    return idQuestion;
  }

  public void setIdQuestion(String idQuestion) {
    this.idQuestion = idQuestion;
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

  public Integer getCounter() {
    return counter;
  }

  public void setCounter(Integer counter) {
    this.counter = counter;
  }
}
