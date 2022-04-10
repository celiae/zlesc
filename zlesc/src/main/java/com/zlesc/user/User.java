package com.zlesc.user;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

  @Id
  @GeneratedValue
  private long id;

  private String email;

  private String username;

  private String nickname;

  private String phonenumber;

  private String description;

  private String password;

  private LocalDateTime regTime;

  private int role;

  private boolean enabled;
}
