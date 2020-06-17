package com.jadwal.back.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class BookingDto {

  @Id
  private String idBooking;
  private String idAvailable;
  private String idState;
  private String email;
  private String createdAt;

  public BookingDto() {
  }

  public BookingDto(String idBooking, String idAvailable, String idState, String email,
      String createdAt) {
    this.idBooking = idBooking;
    this.idAvailable = idAvailable;
    this.idState = idState;
    this.email = email;
    this.createdAt = createdAt;
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

  public String getIdState() {
    return idState;
  }

  public void setIdState(String idState) {
    this.idState = idState;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }
}
