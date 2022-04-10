package com.zlesc.login;

import com.zlesc.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {
  @Query(value = "select * from user where username = :username", nativeQuery = true)
  User findUserByName(@Param("username") String username);

  @Query(value = "select * from user where email = :email", nativeQuery = true)
  User findUserByEmail(@Param("email") String email);

  @Query(value = "select * from user where phonenumber = :phonenumber", nativeQuery = true)
  User findUserByPhone(@Param("phonenumber") String phonenumber);

}
