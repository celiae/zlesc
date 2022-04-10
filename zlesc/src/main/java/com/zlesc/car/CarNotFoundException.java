package com.zlesc.car;

public class CarNotFoundException extends RuntimeException {
  CarNotFoundException(Long id) {
    super("Cound not find Car " + id);
  }
}
