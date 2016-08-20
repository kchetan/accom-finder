package com.practo.jedi.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practo.jedi.entity.UserEntity;

@Transactional
@Repository
public interface UserDao extends CrudRepository<UserEntity, Integer> {

  /**
   * This method will find an User instance in the database by its email. Note that this method is
   * not implemented and its working code will be automatically generated from its signature by
   * Spring Data JPA.
   */
  public UserEntity findByEmail(String email);

}
