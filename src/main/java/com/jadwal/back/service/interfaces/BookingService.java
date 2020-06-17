package com.jadwal.back.service.interfaces;


import com.jadwal.back.model.BookingRequest;
import com.jadwal.back.model.BookingResponse;
import java.util.List;

public interface BookingService {

  List<BookingResponse> findAll(String idAvailability);
  BookingResponse findBooking(String email);
  BookingResponse createBooking(String idQuestion, BookingRequest bookingRequest);
  void deleteBooking(String idQuestion, String idAvailability, String idBooking);

}
