package com.jadwal.back.service.interfaces;

import com.jadwal.back.model.LoginRequest;
import com.jadwal.back.model.UserResponse;
import com.jadwal.back.repositories.entities.TokenDto;

public interface SessionService {

  UserResponse authenticate(LoginRequest loginRequest);
  TokenDto createToken(String email);
  UserResponse getLoggedUser(String idUser, String token);
  void removeToken(String idUser, String token);

}
