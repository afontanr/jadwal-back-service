package com.jadwal.back.config;

import com.jadwal.back.config.exception.EmptyListException;
import com.jadwal.back.config.exception.InvalidFormatException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(InvalidFormatException.class)
  public void invalidFormatHandler(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.BAD_REQUEST.value());
  }

  @ExceptionHandler(EmptyListException.class)
  public void emptyListHandler(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.NO_CONTENT.value());
  }

  @ExceptionHandler(Exception.class)
  public void exceptionHandler(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.BAD_REQUEST.value());
  }


}
