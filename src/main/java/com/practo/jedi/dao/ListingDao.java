package com.practo.jedi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.practo.jedi.entity.ListingEntity;

@Transactional
@Repository
public interface ListingDao extends PagingAndSortingRepository<ListingEntity, Integer>,
    QueryDslPredicateExecutor<ListingEntity> {

  /**
   * This method will find an User instance in the database by its email. Note that this method is
   * not implemented and its working code will be automatically generated from its signature by
   * Spring Data JPA.
   */

  List<ListingEntity> findByRoomFor(String value);

}
