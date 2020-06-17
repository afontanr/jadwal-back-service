package com.jadwal.back.model;

public class BookingResponse {

  private String idBooking;
  private String idAvailable;
  private String email;

  public BookingResponse() {
  }

  public BookingResponse(String idBooking, String idAvailable, String email) {
    this.idBooking = idBooking;
    this.idAvailable = idAvailable;
    this.email = email;
  }

  public String getIdBooking() {
    return idBooking;
  }

  public void setIdBooking(String idBooking) {
    this.idBooking = idBooking;
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
