package com.zlesc.login;

import com.zlesc.user.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
class LoginController {

  private final LoginRepository repository;

  LoginController(LoginRepository repository) {
    this.repository = repository;
  }

  @PostMapping("/login")
  public ResponseEntity<User> login(@RequestBody Login login) {

    User user = new User();

    if (isPhone(login.getUsername_email_phone())) {
      user = repository.findUserByPhone(login.getUsername_email_phone());
    } else if (isEmail(login.getUsername_email_phone())) {
      user = repository.findUserByEmail(login.getUsername_email_phone());
    } else if (isUsername(login.getUsername_email_phone())) {
      user = repository.findUserByName(login.getUsername_email_phone());
    } else {
      System.out.println("Invalid username/email/phone");
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    if (user == null) {
      System.out.println("User not found");
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    if (user.getPassword().equals(login.getPassword())) {
      System.out.println("Login success");
      return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
      System.out.println("Wrong password");
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  static boolean isUsername(String username) {
    String regex = "^[a-zA-Z0-9]{4,16}$";
    return username.matches(regex);
  }

  static boolean isEmail(String email) {
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    return email.matches(regex);
  }

  static boolean isPhone(String phone) {
    String regex = "^[1][3,4,5,7,8][0-9]{9}$";
    return phone.matches(regex);
  }
}
