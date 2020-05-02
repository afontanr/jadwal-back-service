package com.jadwal.back.utils.supplier;

import com.jadwal.back.model.PwdChange;
import com.jadwal.back.repositories.entities.UserDto;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class UserServiceSupplier {

  private UserServiceSupplier(){}

  public static void SET_PWD(PwdChange pwdChange, UserDto userDto){
      String newPwd = BCrypt.hashpw(pwdChange.getNewPassword(), BCrypt.gensalt());
      userDto.setPassword(newPwd);
  }



}
