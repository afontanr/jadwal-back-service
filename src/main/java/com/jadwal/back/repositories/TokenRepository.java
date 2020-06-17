package com.jadwal.back.repositories;


import com.jadwal.back.repositories.entities.TokenDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<TokenDto, String> {

  TokenDto save(TokenDto tokenDto);
  TokenDto findByIdTokenAndIdUser(String idToken, String idUser);
  Boolean existsByIdTokenAndIdUser(String idToken, String idUser);
  void deleteByIdTokenAndIdUser(String idToken, String idUser);

}
