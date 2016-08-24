package com.practo.jedi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.practo.jedi.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {
  
  // @Autowired
  // private SessionFactory sessionFactory;

  @Autowired
  private HibernateTemplate template;

  @Transactional
  public UserEntity getUser(int id) {
    UserEntity res = template.load(UserEntity.class, id);
    //System.out.println(res.getEmail());
    return res;
  }
  
  @Transactional
  public void addUser(UserEntity user){
    template.save(user);
  }

  @Transactional
  public void updateUser(UserEntity user){
    template.update(user);
  }

  @Transactional
  public void deleteUser(UserEntity user){
    template.delete(user);
  }

  @Transactional
  public List<UserEntity> getUsers(){
    return template.loadAll(UserEntity.class);
  }

  @Transactional
  public List<UserEntity> list() {
    return template.loadAll(UserEntity.class);
  }

}