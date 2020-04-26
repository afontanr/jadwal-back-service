package com.jadwal.back.service.interfaces;

import com.jadwal.back.model.UserRequest;
import com.jadwal.back.model.UserResponse;
import java.util.List;

public interface UserService {

  UserResponse saveUser(UserRequest userRequest);
  List<UserResponse> getAllUsers();
  UserResponse getUserById(String idUser);

}
