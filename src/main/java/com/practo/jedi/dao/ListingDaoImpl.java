package com.practo.jedi.dao;

import com.practo.jedi.entity.ListingEntity;
import com.practo.jedi.models.ListingFilter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

@Repository
public class ListingDaoImpl implements ListingDao {

  // @Autowired
  // private SessionFactory sessionFactory;

  @Autowired
  private HibernateTemplate template;


  @Transactional
  public ListingEntity getListing(int id) {
    ListingEntity res = template.load(ListingEntity.class, id);
    return res;
  }


  @Transactional
  public void addListing(ListingEntity listing) {
    template.save(listing);
  }

  @Transactional
  public void updateListing(ListingEntity listing) {
    template.update(listing);
  }

  @Transactional
  public void deleteListing(ListingEntity listing) {
    template.delete(listing);
  }


  @Transactional
  public Iterable<ListingEntity> getListings(Pageable pageable) {
    return (Iterable<ListingEntity>) template.findByCriteria(
        DetachedCriteria.forClass(ListingEntity.class), pageable.getOffset(),
        pageable.getPageSize());
  }

  /**
   * Criteria for area.
   * 
   * @param filter {@link ListingFilter}
   * @param criteria {@link DetachedCriteria}
   * @return {@link DetachedCriteria}
   */
  @Transactional
  public DetachedCriteria areaCriteria(ListingFilter filter, DetachedCriteria criteria) {
    String[] area = filter.getArea().split(";");
    // System.out.println(Arrays.toString(beds)+" - length");
    List<Float> collectionObj = new ArrayList<Float>();
    for (String each : area) {
      try {
        collectionObj.add(Float.parseFloat(each));
        System.out.println(collectionObj.get(0));

      } catch (Exception exp) {
        ;
      }
    }
    criteria =
        criteria.add(Restrictions.between("area", collectionObj.get(0), collectionObj.get(1)));
    return criteria;
  }

  /**
   * Criteria for price.
   * 
   * @param filter {@link ListingFilter}
   * @param criteria {@link DetachedCriteria}
   * @return {@link DetachedCriteria}
   */
  @Transactional
  public DetachedCriteria priceCriteria(ListingFilter filter, DetachedCriteria criteria) {
    String[] price = filter.getPrice().split(";");
    // System.out.println(Arrays.toString(beds)+" - length");
    List<Integer> collectionObj = new ArrayList<Integer>();
    for (String each : price) {
      try {
        collectionObj.add(Integer.parseInt(each));
      } catch (Exception exp) {
        ;
      }
    }
    criteria =
        criteria.add(Restrictions.between("price", collectionObj.get(0), collectionObj.get(1)));
    return criteria;
  }

  @Transactional
  public Iterable<ListingEntity> filter(ListingFilter filter, Pageable pageable) {
    DetachedCriteria criteria = DetachedCriteria.forClass(ListingEntity.class);
    criteria = criteria.add(Restrictions.eq("deleted", false));

    if (filter.getArea() != null && filter.getArea() != "") {
      criteria = areaCriteria(filter, criteria);
    }
    if (filter.getPrice() != null && filter.getPrice() != "") {
      criteria = priceCriteria(filter, criteria);
    }
    if (filter.getNoBeds() != null && filter.getNoBeds() != "") {
      criteria = noBedsCriteria(filter, criteria);
    }
    if (filter.getPropertyType() != null && filter.getPropertyType() != "") {
      criteria = propertyTypeCriteria(filter, criteria);
    }

    if (filter.getVacancyFor() != null && filter.getVacancyFor() != "") {
      criteria = vacancyForCriteria(filter, criteria);
    }
    if (filter.getFurnished() != null && filter.getFurnished() != "") {
      String[] furnish = filter.getFurnished().split("\\|");
      criteria = criteria.add(Restrictions.in("furnished", furnish));
    }
    if (filter.getRoomFor() != null && filter.getRoomFor() != "") {
      String[] roomFor = filter.getRoomFor().split("\\|");
      criteria = criteria.add(Restrictions.in("furnished", roomFor));
    }
    if (filter.getPossessionDate() != null && filter.getPossessionDate() != "") {
      try {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date posDate = df.parse(filter.getPossessionDate());
        criteria = criteria.add(Restrictions.le("possesionDate", posDate));
      } catch (ParseException exp) {
        ;
      }
    }
    return (Iterable<ListingEntity>) template.findByCriteria(criteria, pageable.getOffset(),
        pageable.getPageSize());
  }


  /**
   * Criteria for noBeds.
   * 
   * @param filter {@link ListingFilter}
   * @param criteria {@link DetachedCriteria}
   * @return {@link DetachedCriteria}
   */
  @Transactional
  public DetachedCriteria noBedsCriteria(ListingFilter filter, DetachedCriteria criteria) {
    String[] beds = filter.getNoBeds().split("\\|");
    // System.out.println(Arrays.toString(beds)+" - length");
    List<Integer> collectionObj = new ArrayList<Integer>();
    for (String each : beds) {
      try {
        collectionObj.add(Integer.parseInt(each));
      } catch (Exception exp) {
        ;
      }
    }
    criteria = criteria.add(Restrictions.in("noBeds", collectionObj));
    return criteria;
  }

  /**
   * Criteria for vacancyFor.
   * 
   * @param filter {@link ListingFilter}
   * @param criteria {@link DetachedCriteria}
   * @return {@link DetachedCriteria}
   */
  @Transactional
  public DetachedCriteria vacancyForCriteria(ListingFilter filter, DetachedCriteria criteria) {
    String[] vacancies = filter.getVacancyFor().split("\\|");
    List<Integer> collectionObj = new ArrayList<Integer>();
    for (String each : vacancies) {
      try {
        collectionObj.add(Integer.parseInt(each));
      } catch (Exception exp) {
        ;
      }
    }
    criteria = criteria.add(Restrictions.in("vacancyFor", collectionObj));
    return criteria;
  }

  /**
   * Criteria for PropertType.
   * 
   * @param filter {@link ListingFilter}
   * @param criteria {@link DetachedCriteria}
   * @return {@link DetachedCriteria}
   */
  @Transactional
  public DetachedCriteria propertyTypeCriteria(ListingFilter filter, DetachedCriteria criteria) {
    String[] propType = filter.getPropertyType().split("\\|");
    List<Integer> collectionObj = new ArrayList<Integer>();
    for (String each : propType) {
      try {
        collectionObj.add(Integer.parseInt(each));
      } catch (Exception exp) {
        ;
      }
    }
    criteria = criteria.add(Restrictions.in("propertyType.id", collectionObj));
    return criteria;
  }



}
