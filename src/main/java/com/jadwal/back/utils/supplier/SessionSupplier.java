package com.jadwal.back.utils.supplier;

import com.jadwal.back.repositories.TokenRepository;
import com.jadwal.back.repositories.entities.TokenDto;
import com.jadwal.back.utils.Constants;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


public class SessionSupplier {


  private static TokenRepository tokenRepository;

  public SessionSupplier(TokenRepository tokenRepository) {
    this.tokenRepository = tokenRepository;
  }

  public static boolean isAdmin(Map<String, String> cookies){
    TokenDto tokenDto = tokenRepository
        .findByIdTokenAndIdUser(cookies.get(Constants.TOKEN_NAME), cookies.get(Constants.ID_USER_NAME));
    return Objects.nonNull(tokenDto) && tokenDto.getIdRol().equals(Constants.ID_ADMIN_ROL);
  }

  public static Map<String, String> getTokenAndUserFromCookies(HttpServletRequest servletRequest){
    String token = "";
    String idUser = "";
    List<Cookie> tokenList = Arrays.stream(servletRequest.getCookies()).filter(
        cookie -> cookie.getName().equals(Constants.TOKEN_NAME)
    ).collect(Collectors.toList());
    List<Cookie> idUserList = Arrays.stream(servletRequest.getCookies()).filter(
        cookie -> cookie.getName().equals(Constants.ID_USER_NAME)
    ).collect(Collectors.toList());
    if(!tokenList.isEmpty() && !idUserList.isEmpty()){
      token = tokenList.get(0).getValue();
      idUser = idUserList.get(0).getValue();
    }
    Map<String, String> mapResponse = Collections.EMPTY_MAP;
    mapResponse.put(Constants.TOKEN_NAME, token);
    mapResponse.put(Constants.ID_USER_NAME, idUser);
    return mapResponse;
  }
}
