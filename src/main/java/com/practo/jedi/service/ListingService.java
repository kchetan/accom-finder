package com.practo.jedi.service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;

import com.practo.jedi.models.Listing;
import com.practo.jedi.models.ListingFilter;

public interface ListingService {

  Listing get(Integer id);

  @Transactional
  Listing create(Listing d);

  @Transactional
  Listing update(Listing d, int id);

  @Transactional
  void delete(Integer id);

  @Transactional
  Iterable<Listing> getAll(Pageable pageable);

  @Transactional
  Iterable<Listing> search(ListingFilter filterObj, Pageable pageable);

}

