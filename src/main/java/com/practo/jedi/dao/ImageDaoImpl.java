package com.practo.jedi.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.practo.jedi.entity.ImageEntity;

@Repository
public class ImageDaoImpl implements ImageDao {

  // @Autowired
  // private SessionFactory sessionFactory;

  @Autowired
  private HibernateTemplate template;

  @Transactional
  public ImageEntity getImage(int id) {
    ImageEntity res = template.load(ImageEntity.class, id);
    return res;
  }

  @Transactional
  public void addImage(ImageEntity image) {
    template.save(image);
  }

  @Transactional
  public void updateImage(ImageEntity image) {
    template.update(image);
  }

  @Transactional
  public void deleteImage(ImageEntity image) {
    template.delete(image);
  }

}
