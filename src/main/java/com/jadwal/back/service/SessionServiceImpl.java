package com.jadwal.back.service;

import com.jadwal.back.model.LoginRequest;
import com.jadwal.back.model.UserResponse;
import com.jadwal.back.repositories.TokenRepository;
import com.jadwal.back.repositories.UserRepository;
import com.jadwal.back.repositories.entities.TokenDto;
import com.jadwal.back.repositories.entities.UserDto;
import com.jadwal.back.service.interfaces.SessionService;
import com.jadwal.back.utils.Mapper;
import com.jadwal.back.utils.StringGenerator;
import java.util.Objects;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

  private TokenRepository tokenRepository;
  private UserRepository userRepository;

  @Autowired
  public SessionServiceImpl(TokenRepository tokenRepository,
      UserRepository userRepository) {
    this.tokenRepository = tokenRepository;
    this.userRepository = userRepository;
  }

  public UserResponse authenticate(LoginRequest loginRequest){
    UserDto userDto = userRepository.findByEmail(loginRequest.getEmail());
    if(Objects.isNull(userDto)){
      return null;
    }
    return Mapper.mapToResponse(userDto);
  }

  public UserResponse getLoggedUser(String idUser, String token){
    Boolean match = tokenRepository.existsByIdTokenAndIdUser(token, idUser);
    if(!match){
      return null;
    }
    UserDto userDto = userRepository.findByIdUser(idUser);

    if(Objects.isNull(userDto)){
      return null;
    }

    return Mapper.mapToResponse(userDto);
  }

  public TokenDto createToken(String email){
    UserDto userDto = userRepository.findByEmail(email);
    if(Objects.isNull(userDto)){
      return null;
    }
    String token = StringGenerator.generateId();
    TokenDto tokenDto = Mapper.mapToDto(userDto,token);
    tokenRepository.save(tokenDto);

    return Mapper.mapToDto(userDto, token);
  }

  @Transactional
  public void removeToken(String idUser, String token){
    tokenRepository.deleteByIdTokenAndIdUser(token, idUser);
  }
}
