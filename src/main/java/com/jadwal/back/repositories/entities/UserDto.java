package com.jadwal.back.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserDto {

  @Id
  private String idUser;
  private String idRol;
  private String idState;
  private String name;
  private String surname;
  private String email;
  private String office;
  private String password;

  public UserDto() {  }

  public UserDto(String idUser, String idRol, String idState, String name, String surname,
      String email, String office, String password){
    this.idUser = idUser;
    this.idRol = idRol;
    this.idState = idState;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.office = office;
    this.password = password;
  }

  public String getIdRol() {
    return idRol;
  }

  public void setIdRol(String idRol) {
    this.idRol = idRol;
  }

  public String getIdState() {
    return idState;
  }

  public void setIdState(String idState) {
    this.idState = idState;
  }

  public String getIdUser() {
    return idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
