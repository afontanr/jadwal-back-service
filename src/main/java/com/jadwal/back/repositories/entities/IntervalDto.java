package com.jadwal.back.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "interval")
public class IntervalDto {

  @Id
  private String idInterval;
  private String description;

  public IntervalDto() {
  }

  public IntervalDto(String idInterval, String description) {
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
