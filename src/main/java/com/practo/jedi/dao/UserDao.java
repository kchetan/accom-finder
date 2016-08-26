package com.practo.jedi.dao;

import java.util.List;

import com.practo.jedi.entity.UserEntity;

public interface UserDao {

  public UserEntity getUser(int id);
  
  public UserEntity getUserByEmail(String email);

  public void addUser(UserEntity user);

  public void updateUser(UserEntity user);

  public void deleteUser(UserEntity user);

  public List<UserEntity> getUsers();

}
