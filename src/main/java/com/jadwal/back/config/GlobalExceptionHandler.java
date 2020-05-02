package com.jadwal.back.config;

import com.jadwal.back.config.exception.EmptyListException;
import com.jadwal.back.config.exception.InvalidFormatException;
import com.jadwal.back.config.exception.NotFoundException;
import com.jadwal.back.config.exception.SomeErrorException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(EmptyListException.class)
  public void noContentHandler(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.NO_CONTENT.value());
  }

  @ExceptionHandler(NotFoundException.class)
  public void notFoundHandler(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.NOT_FOUND.value());
  }

  @ExceptionHandler({SomeErrorException.class, InvalidFormatException.class, Exception.class})
  public void badRequestHandler(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.BAD_REQUEST.value());
  }

}
