package com.zlesc.user;

public class UserNotFoundException extends RuntimeException {
  UserNotFoundException(Long id) {
    super("Cound not find user " + id);
  }
}
