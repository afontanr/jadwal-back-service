package com.jadwal.back.repositories;

import com.jadwal.back.repositories.entities.UserDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto, String> {

  UserDto save(UserDto userDto);
  List<UserDto> findAll();
  UserDto findByIdUser(String idUser);
  void deleteByIdUser(String idUser);
  UserDto findByEmail(String email);
  Boolean existsByEmail(String email);

}
