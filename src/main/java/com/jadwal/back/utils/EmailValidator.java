package com.jadwal.back.utils;

import com.mysql.cj.util.StringUtils;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {

  final private Pattern emailPattern = Pattern
      .compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\."
          + "[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");

  @Override
  public void initialize(final Email constraintAnnotation) {
    //for interface
  }
  @Override
  public boolean isValid(final String value, final ConstraintValidatorContext context) {
    return !StringUtils.isNullOrEmpty(value) && emailPattern.matcher(value).matches() && value.contains("upm");
    }
}
