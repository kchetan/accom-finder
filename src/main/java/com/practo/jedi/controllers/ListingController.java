package com.practo.jedi.controllers;

import com.practo.jedi.models.Image;
import com.practo.jedi.models.Listing;
import com.practo.jedi.models.ListingFilter;
import com.practo.jedi.service.ListingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/listings")
public class ListingController {
  private int pageSize = 3;

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  @Autowired
  private ListingService service;

  /**
   * Fetch all listings.
   * @param pageable {@link Pageable}
   * @return {@link ResponseEntity } {@link Listing}
   */
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Iterable<Listing>> getAll(Pageable pageable) {

    Iterable<Listing> dto = service.getAll(updatePageable(pageable, pageSize));
    ResponseEntity<Iterable<Listing>> re =
        new ResponseEntity<Iterable<Listing>>(dto, HttpStatus.CREATED);
    return re;
  }

  /**
   * Get a listing Controller.
   * @param id {@link Integer}
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Listing> getListing(@PathVariable int id) {
    Listing listingobj = service.get(id);
    ResponseEntity<Listing> re = new ResponseEntity<Listing>(listingobj, HttpStatus.OK);
    return re;
  }

  /**
   * Filters Controller.
   * @param filterObj {@link ListingFilter}
   * @param pageable {@link Pageable}
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public ResponseEntity<Iterable<Listing>> search(ListingFilter filterObj, Pageable pageable) {
    Iterable<Listing> dto = service.search(filterObj, updatePageable(pageable, pageSize));
    ResponseEntity<Iterable<Listing>> re =
        new ResponseEntity<Iterable<Listing>>(dto, HttpStatus.CREATED);
    return re;
  }


  /**
   * Create listing.
   * @param obj {@link Listing}
   * @return {@link ResponseEntity}
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Listing> create(@RequestBody Listing obj) {
    Listing listingobj = service.create(obj);
    ResponseEntity<Listing> re = new ResponseEntity<Listing>(listingobj, HttpStatus.CREATED);
    return re;
  }

  /**
   * Update listing.
   * @param id {@link Integer}
   * @param obj {@link Listing}
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Listing> update(@PathVariable int id, @RequestBody Listing obj) {
    Listing listingobj = service.update(obj, id);
    ResponseEntity<Listing> re = new ResponseEntity<Listing>(listingobj, HttpStatus.OK);
    return re;
  }

  /**
   * Delete Listing.
   * @param id {@link Integer}
   * @param response {@link HttpServletResponse}
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id, HttpServletResponse response) {
    service.delete(id);
    ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return re;
  }

  public static Pageable updatePageable(final Pageable source, final int size) {
    return new PageRequest(source.getPageNumber(), size, source.getSort());
  }

}

