package com.jadwal.back.service;

import com.jadwal.back.model.BookingRequest;
import com.jadwal.back.model.BookingResponse;
import com.jadwal.back.repositories.AvailabilityRepository;
import com.jadwal.back.repositories.BookingRepository;
import com.jadwal.back.repositories.entities.AvailabilityDto;
import com.jadwal.back.repositories.entities.BookingDto;
import com.jadwal.back.service.interfaces.BookingService;
import com.jadwal.back.utils.Mapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {


  private BookingRepository bookingRepository;
  private AvailabilityRepository availabilityRepository;

  @Autowired
  public BookingServiceImpl(BookingRepository bookingRepository,
      AvailabilityRepository availabilityRepository) {
    this.bookingRepository = bookingRepository;
    this.availabilityRepository = availabilityRepository;
  }

  public List<BookingResponse> findAll(String idAvailability){
    return bookingRepository.findAllByIdAvailable(idAvailability)
        .stream().map(it -> Mapper.mapToResponse(it)).collect(Collectors.toList());
  }

  public BookingResponse findBooking(String email){
    BookingDto booking = bookingRepository.findByEmail(email);
    if(Objects.isNull(booking)){
      return null;
    }
    return Mapper.mapToResponse(booking);
  }

  public BookingResponse createBooking(String idQuestion, BookingRequest bookingRequest){
    BookingDto booking = bookingRepository.findByEmail(bookingRequest.getEmail());
    AvailabilityDto availabilityDto = availabilityRepository
        .findByIdAvailabilityAndIdQuestion(bookingRequest.getIdAvailable(), idQuestion);
    System.out.println(bookingRequest.getIdAvailable());
    System.out.println(idQuestion);
    if(Objects.nonNull(booking) || Objects.isNull(availabilityDto)){
      return null;
    }
    availabilityDto.setCounter(availabilityDto.getCounter() + 1);
    availabilityRepository.save(availabilityDto);

    booking = Mapper.mapToDto(bookingRequest);
    booking = bookingRepository.save(booking);

    return Mapper.mapToResponse(booking);
  }

  @Transactional
  public void deleteBooking(String idQuestion, String idAvailability, String idBooking){
    BookingDto booking = bookingRepository.findByIdBooking(idBooking);
    AvailabilityDto availabilityDto = availabilityRepository
        .findByIdAvailabilityAndIdQuestion(idAvailability, idQuestion);
    if(Objects.isNull(booking) || Objects.isNull(availabilityDto)){
      return;
    }
    availabilityDto.setCounter(availabilityDto.getCounter() - 1);
    bookingRepository.deleteByIdBooking(idBooking);
    availabilityRepository.save(availabilityDto);
  }
}
