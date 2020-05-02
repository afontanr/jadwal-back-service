package com.jadwal.back.model;

import com.jadwal.back.utils.Email;

public class UserRequest {

  private String name;
  private String idRol;
  private String surname;
  private String office;

  @Email
  private String email;


  public UserRequest() {  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getOffice() {
    return office;
  }

  public void setOffice(String office) {
    this.office = office;
  }

  public String getIdRol() {
    return idRol;
  }

  public void setIdRol(String idRol) {
    this.idRol = idRol;
  }

}
