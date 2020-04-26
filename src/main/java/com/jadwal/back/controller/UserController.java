package com.jadwal.back.controller;

import com.jadwal.back.config.exception.EmptyListException;
import com.jadwal.back.config.exception.InvalidFormatException;
import com.jadwal.back.model.UserRequest;
import com.jadwal.back.model.UserResponse;
import com.jadwal.back.service.interfaces.UserService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
  public List<UserResponse> findAllUsers(HttpServletResponse servletResponse){
    List<UserResponse> response = userService.getAllUsers();
    if(response.isEmpty()){
      throw new EmptyListException("Lista vacía");
    }
    return response;
  }

  @RequestMapping(value = "/{idUser}", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public UserResponse getUserById(@PathVariable("idUser") String idUser){
    return userService.getUserById(idUser);
  }

}
