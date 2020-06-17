package com.jadwal.back.controller;

import com.jadwal.back.config.exception.EmptyListException;
import com.jadwal.back.config.exception.SomeErrorException;
import com.jadwal.back.model.BookingRequest;
import com.jadwal.back.model.BookingResponse;
import com.jadwal.back.service.interfaces.BookingService;
import com.jadwal.back.utils.Constants;
import java.util.List;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v0/questions/{idQuestion}/availabilities/{idAvailability}/bookings")
public class BookingController {

  private BookingService bookingService;

  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @RequestMapping(method = RequestMethod.GET)
  @ResponseStatus(value = HttpStatus.OK)
  public List<BookingResponse> findAlL(@PathVariable("idAvailability") String idAvailability){
    List<BookingResponse> response = bookingService.findAll(idAvailability);
    if(response.isEmpty()){
      throw new EmptyListException(Constants.EMPTY_LIST);
    }
    return response;
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  public BookingResponse createAvailability(@PathVariable("idQuestion") String idQuestion,
      @RequestBody BookingRequest bookingRequest){
    BookingResponse bookingResponse = bookingService.createBooking(idQuestion, bookingRequest);
    if(Objects.isNull(bookingResponse)){
      throw new SomeErrorException(Constants.SOME_ERROR);
    }
    return bookingResponse;
  }

  @RequestMapping(value = "/{idBooking}", method = RequestMethod.DELETE)
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void deleteAvailability(@PathVariable("idQuestion") String idQuestion,
      @PathVariable("idAvailability") String idAvailability,
      @PathVariable("idBooking") String idBooking){
    bookingService.deleteBooking(idQuestion, idAvailability, idBooking);
  }
}
