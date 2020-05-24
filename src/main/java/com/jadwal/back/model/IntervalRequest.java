package com.jadwal.back.model;

public class IntervalRequest {

  private String description;

  public IntervalRequest() {
  }

  public IntervalRequest(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
