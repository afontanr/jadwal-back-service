package com.jadwal.back.model;

public class BookingRequest {

  private String idAvailable;
  private String email;

  public BookingRequest() {
  }

  public BookingRequest(String idAvailable, String email) {
    this.idAvailable = idAvailable;
    this.email = email;
  }

  public String getIdAvailable() {
    return idAvailable;
  }

  public void setIdAvailable(String idAvailable) {
    this.idAvailable = idAvailable;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

