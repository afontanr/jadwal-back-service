package com.jadwal.back.repositories;

import com.jadwal.back.repositories.entities.BookingDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingDto, String> {

  List<BookingDto> findAllByIdAvailable(String idAvailable);
  BookingDto findByEmail(String email);
  BookingDto findByIdBooking(String idBooking);
  BookingDto save(BookingDto bookingDto);
  void deleteByIdBooking(String idBooking);

}
