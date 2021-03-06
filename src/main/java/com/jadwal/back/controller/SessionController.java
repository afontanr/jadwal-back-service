package com.jadwal.back.controller;

import com.jadwal.back.config.exception.EmptyListException;
import com.jadwal.back.config.exception.SomeErrorException;
import com.jadwal.back.model.LoginRequest;
import com.jadwal.back.model.UserResponse;
import com.jadwal.back.repositories.entities.TokenDto;
import com.jadwal.back.service.interfaces.SessionService;
import com.jadwal.back.utils.Constants;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v0/users")
public class SessionController {

  private SessionService sessionService;

  @Autowired
  public SessionController(SessionService sessionService) {
    this.sessionService = sessionService;
  }

  @RequestMapping(value = "/login",method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.OK)
  public UserResponse login(HttpServletRequest servletRequest,
      @RequestBody LoginRequest loginRequest){
   UserResponse userResponse = sessionService.authenticate(loginRequest);
   if(Objects.isNull(userResponse)){
     throw new SomeErrorException(Constants.AUTH_ERROR);
   }
    TokenDto token = sessionService.createToken(loginRequest.getEmail());
    if(Objects.isNull(token)){
      throw new SomeErrorException(Constants.SOME_ERROR);
    }
    HttpSession session = servletRequest.getSession(true);
    session.setAttribute(Constants.TOKEN_NAME, token.getIdToken());
    session.setAttribute(Constants.ID_USER_NAME, token.getIdUser());
    return userResponse;
  }

  @RequestMapping(value = "/userLogged",method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public UserResponse getLoggedUser(HttpServletRequest servletRequest){
    HttpSession session = servletRequest.getSession(false);
    if(Objects.isNull(session)){
      throw new EmptyListException(Constants.EMPTY);
    }
    String idUser = (String) session.getAttribute(Constants.ID_USER_NAME);
    String token = (String) session.getAttribute(Constants.TOKEN_NAME);

    UserResponse userResponse = sessionService.getLoggedUser(idUser, token);

    if(Objects.isNull(userResponse)){
      throw new EmptyListException(Constants.EMPTY);
    }

    return userResponse;
  }

  @RequestMapping(value = "/logout", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void logout(HttpServletRequest servletRequest){
    HttpSession session = servletRequest.getSession(false);
    String idUser = (String) session.getAttribute(Constants.ID_USER_NAME);
    String token = (String) session.getAttribute(Constants.TOKEN_NAME);
    sessionService.removeToken(idUser, token);
    session.removeAttribute(Constants.TOKEN_NAME);
    session.removeAttribute(Constants.ID_USER_NAME);
    servletRequest.getSession().invalidate();
  }
}
