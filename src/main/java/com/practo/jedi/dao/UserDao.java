package com.practo.jedi.dao;


import com.practo.jedi.entity.UserEntity;

/**
 * This is the data access object interface for User table.
 * 
 * @author chetan
 *
 */
public interface UserDao {

  public UserEntity getUser(int id);

  public UserEntity getUserByEmail(String email);

  public void addUser(UserEntity user);

  public void updateUser(UserEntity user);

//  public void deleteUser(UserEntity user);

  // public List<UserEntity> getUsers();

}
