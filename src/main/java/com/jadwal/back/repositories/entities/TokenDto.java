package com.jadwal.back.repositories.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tokens")
public class TokenDto {

  @Id
  private String idToken;
  private String idUser;
  private String idRol;

  public TokenDto() {
  }

  public TokenDto(String idToken, String idUser, String idRol) {
    this.idToken = idToken;
    this.idUser = idUser;
    this.idRol = idRol;
  }

  public String getIdToken() {
    return idToken;
  }

  public void setIdToken(String idToken) {
    this.idToken = idToken;
  }

  public String getIdUser() {
    return idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }

  public String getIdRol() {
    return idRol;
  }

  public void setIdRol(String idRol) {
    this.idRol = idRol;
  }
}
