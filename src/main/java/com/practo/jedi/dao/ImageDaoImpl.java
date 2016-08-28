package com.practo.jedi.dao;

import com.practo.jedi.entity.ImageEntity;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class ImageDaoImpl implements ImageDao {

  // @Autowired
  // private SessionFactory sessionFactory;

  @Autowired
  private HibernateTemplate template;

  
  /**
   * Get image object based on id.
   * @param id {@link Integer}
   * @return {@link ImageEntity}
   */
  @Transactional
  public ImageEntity getImage(int id) {
    DetachedCriteria criteria = DetachedCriteria.forClass(ImageEntity.class);
    criteria = criteria.add(Restrictions.eq("deleted", false));
    criteria = criteria.add(Restrictions.eq("id", id));
    @SuppressWarnings("unchecked")
    Iterable<ImageEntity> result = (Iterable<ImageEntity>) template.findByCriteria(criteria);
    for (ImageEntity iter : result) {
      return iter;
    }
    return null;
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
    template.update(image);
  }

}
