package com.jadwal.back.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<Date, String> {

  @Override
  public void initialize(Date constraintAnnotation) {

  }

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    java.util.Date date = null;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);
      date = sdf.parse(s);
      if (!s.equals(sdf.format(date))) {
        date = null;
      }
    } catch (ParseException ex) {
      ex.printStackTrace();
    }
    return date != null;
  }

}
