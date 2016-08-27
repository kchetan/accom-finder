package com.practo.jedi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.practo.jedi.entity.ListingEntity;
import com.practo.jedi.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

  // @Autowired
  // private SessionFactory sessionFactory;

  @Autowired
  private HibernateTemplate template;

  @Transactional
  public UserEntity getUserByEmail(String email) {
    DetachedCriteria criteria = DetachedCriteria.forClass(UserEntity.class);
    Iterable<UserEntity> res = (Iterable<UserEntity>) template
        .findByCriteria(criteria.add(Restrictions.eq("email", email)));
    // System.out.println(res.getEmail());
    for (UserEntity iter : res) {
      return iter;
    }
    return null;
  }

  @Transactional
  public UserEntity getUser(int id) {
    DetachedCriteria criteria = DetachedCriteria.forClass(UserEntity.class);
    criteria = criteria.add(Restrictions.eq("deleted", false));
    criteria = criteria.add(Restrictions.eq("id", id));
    Iterable<UserEntity> result = (Iterable<UserEntity>) template.findByCriteria(criteria);
    for (UserEntity iter : result){
      return iter;
    }
    return null;
  }

  @Transactional
  public void addUser(UserEntity user) {
    template.save(user);
  }

  @Transactional
  public void updateUser(UserEntity user) {
    template.update(user);
  }

  @Transactional
  public void deleteUser(UserEntity user) {
    template.update(user);
  }

  @Transactional
  public List<UserEntity> getUsers() {
    return template.loadAll(UserEntity.class);
  }

  @Transactional
  public List<UserEntity> list() {
    return template.loadAll(UserEntity.class);
  }

}
