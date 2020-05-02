package com.jadwal.back.utils;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;

public class StringGenerator {

  private StringGenerator() {  }

  public static String generateId(){
    return RandomStringUtils.randomAlphanumeric(Constants.ID_SIZE);
  }
}
