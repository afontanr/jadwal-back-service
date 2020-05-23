package com.jadwal.back.model;

public class UserResponse {

  private String idUser;
  private String name;
  private String surname;
  private String email;
  private String office;
  private Boolean isAdmin;

  public UserResponse() {  }

  public UserResponse(String idUser, String name, String surname, String email,
      String office, Boolean isAdmin) {
    this.idUser = idUser;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.office = office;
    this.isAdmin = isAdmin;
  }

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

  public String getIdUser() {
    return idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }

  public Boolean getAdmin() {
    return isAdmin;
  }

  public void setAdmin(Boolean admin) {
    isAdmin = admin;
  }
}

