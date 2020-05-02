package com.jadwal.back.controller;

import com.jadwal.back.config.exception.EmptyListException;
import com.jadwal.back.config.exception.NotFoundException;
import com.jadwal.back.config.exception.SomeErrorException;
import com.jadwal.back.model.PwdChange;
import com.jadwal.back.model.UserRequest;
import com.jadwal.back.model.UserResponse;
import com.jadwal.back.service.interfaces.UserService;
import com.jadwal.back.utils.Constants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v0/users")
public class UserController {

  UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public UserResponse saveUser(@Validated @RequestBody UserRequest userRequest){
     return userService.saveUser(userRequest);
  }

  @RequestMapping(method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<UserResponse> findAllUsers(){
    List<UserResponse> response = userService.getAllUsers();
    if(response.isEmpty()){
      throw new EmptyListException(Constants.EMPTY_LIST);
    }
    return response;
  }

  @RequestMapping(value = "/{idUser}", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public UserResponse getUserById(@PathVariable("idUser") String idUser){
    UserResponse userResponse = userService.getUserById(idUser);
    if(userResponse == null){
      throw new NotFoundException(Constants.USER_NOT_FOUND);
    }
    return userResponse;
  }

  @RequestMapping(value = "/{idUser}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.ACCEPTED)
  public UserResponse modifyUserData(@PathVariable("idUser") String idUser,
      @Validated @RequestBody UserRequest userRequest){
    UserResponse userResponse = userService.modifyUserData(idUser, userRequest);
    if(userResponse == null){
      throw new NotFoundException(Constants.USER_NOT_FOUND);
    }
    return userResponse;
  }

  @RequestMapping(value = "/{idUser}/password", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.ACCEPTED)
  public UserResponse modifyUserPwd(@PathVariable("idUser") String idUser,
      @RequestBody PwdChange pwdChange){
    UserResponse userResponse = userService.modifyUserPwd(idUser, pwdChange);
    if(userResponse == null){
      throw new SomeErrorException(Constants.SOME_ERROR);
    }
    return userResponse;
  }

  @RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteUser(@PathVariable("idUser") String idUser){
    userService.deleteUser(idUser);
  }

}
