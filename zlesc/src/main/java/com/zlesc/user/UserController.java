package com.zlesc.user;

import java.lang.reflect.Array;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
class UserController {

  private final UserRepository repository;

  UserController(UserRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/user")
  List<User> all() {
    return repository.findAll();
  }

  @PostMapping("/user")
  User newUser(@RequestBody User newUser) {

    // List<User> users = repository.findAll();
    // for (User user : users) {
    // if (user.getUsername().equals(newUser.getUsername())
    // || user.getEmail().equals(newUser.getEmail())
    // || user.getPhonenumber().equals(newUser.getPhonenumber())) {
    // return null;
    // }
    // }

    return repository.save(newUser);
  }

  @GetMapping("/user/{id}")
  User one(@PathVariable Long id) {

    return repository.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));
  }

  @PutMapping("/user/{id}")
  User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

    return repository.findById(id)
        .map(User -> {
          User.setEmail(newUser.getEmail());
          User.setUsername(newUser.getUsername());
          User.setNickname(newUser.getNickname());
          User.setPhonenumber(newUser.getPhonenumber());
          User.setDescription(newUser.getDescription());
          User.setPassword(newUser.getPassword());
          User.setRegTime(newUser.getRegTime());
          User.setRole(newUser.getRole());
          User.setEnabled(newUser.isEnabled());
          return repository.save(User);
        })
        .orElseGet(() -> {
          newUser.setId(id);
          return repository.save(newUser);
        });
  }

  @DeleteMapping("/user/{id}")
  void deleteUser(@PathVariable Long id) {
    repository.deleteById(id);
  }

}
