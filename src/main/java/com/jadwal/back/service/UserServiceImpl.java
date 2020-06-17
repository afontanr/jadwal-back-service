package com.jadwal.back.service;

import com.jadwal.back.model.PwdChange;
import com.jadwal.back.model.UserRequest;
import com.jadwal.back.model.UserResponse;
import com.jadwal.back.repositories.UserRepository;
import com.jadwal.back.repositories.entities.UserDto;
import com.jadwal.back.service.interfaces.UserService;
import com.jadwal.back.utils.Constants;
import com.jadwal.back.utils.Mapper;
import com.jadwal.back.utils.supplier.UserServiceSupplier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;


  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserResponse saveUser(UserRequest userRequest) {
    Boolean exists = userRepository.existsByEmail(userRequest.getEmail());
    if(exists){
      return null;
    }
    UserDto userDto =  Mapper.mapToDto(userRequest, Constants.ID_STATE_STAND_BY);
    userDto = userRepository.save(userDto);
    return Mapper.mapToResponse(userDto);
  }

  public List<UserResponse> getAllUsers(){
    List<UserDto> listUsers = userRepository.findAll();
    return listUsers.stream().map(Mapper::mapToResponse)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public UserResponse getUserById(String idUser) {
    UserDto user = userRepository.findByIdUser(idUser);
    return Mapper.mapToResponse(user);
  }

  public UserResponse modifyUserData(String idUser, UserRequest userRequest){
    UserDto userDto = userRepository.findByIdUser(idUser);

    if(userDto == null){
      return null;
    }
    userDto.setEmail(userRequest.getEmail());
    userDto.setName(userRequest.getName());
    userDto.setSurname(userRequest.getSurname());
    userDto.setOffice(userRequest.getOffice());

    userDto = userRepository.save(userDto);
    return Mapper.mapToResponse(userDto);
  }

  public UserResponse modifyUserPwd(String idUser, PwdChange pwdChange){
    UserDto userDto = userRepository.findByIdUser(idUser);
    UserResponse userResponse;

    if(Objects.isNull(userDto) || StringUtils.isBlank(pwdChange.getNewPassword()) ||
        !pwdChange.getNewPassword().equals(pwdChange.getRepeatPassword())){
      userResponse = null;
    }

    else if(userDto.getIdState().equals(Constants.ID_STATE_STAND_BY) ||
        (userDto.getIdState().equals(Constants.ID_STATE_ACTIVE) &&
        BCrypt.checkpw(pwdChange.getOldPassword(), userDto.getPassword()))){
      UserServiceSupplier.SET_PWD(pwdChange, userDto);
      userDto.setIdState(Constants.ID_STATE_ACTIVE);
      userRepository.save(userDto);
      userResponse = Mapper.mapToResponse(userDto);
    }
    else{
      userResponse = null;
    }

    return userResponse;
  }

  @Transactional
  public void deleteUser(String idUser){
    userRepository.deleteByIdUser(idUser);
  }



}
