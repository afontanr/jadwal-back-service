package com.jadwal.back.service.interfaces;

import com.jadwal.back.model.PwdChange;
import com.jadwal.back.model.UserRequest;
import com.jadwal.back.model.UserResponse;
import java.util.List;

public interface UserService {

  UserResponse saveUser(UserRequest userRequest);
  List<UserResponse> getAllUsers();
  UserResponse getUserById(String idUser);
  UserResponse modifyUserData(String idUser, UserRequest userRequest);
  UserResponse modifyUserPwd(String idUser, PwdChange pwdChange);
  void deleteUser(String idUser);

}
