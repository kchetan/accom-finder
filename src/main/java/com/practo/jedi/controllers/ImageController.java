package com.practo.jedi.controllers;

import com.practo.jedi.models.Image;
import com.practo.jedi.service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;

/**
 * This is the controller which handles all the api requests corresponding to Image table.
 * Handles the api requests for GET,POST,UPDATE,DELETE
 * 
 * @author chetan
 *
 */
@RestController
@RequestMapping("/api/image")
public class ImageController {
  @Autowired
  private ImageService service;

  /**
   * Get image controller.
   * @param id {@link Integer}
   * @return {@link ResponseEntity } {@link Image}
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Image> getImage(@PathVariable int id) {
    Image imageobj = service.get(id);
    ResponseEntity<Image> re = new ResponseEntity<Image>(imageobj, HttpStatus.OK);
    return re;
  }

  /**
   * Create Image from response body.
   * @param obj {@link Image}
   * @return {@link ResponseEntity } {@link Image}
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Image> create(@RequestBody Image obj) {
    Image imageobj = service.create(obj);
    ResponseEntity<Image> re = new ResponseEntity<Image>(imageobj, HttpStatus.CREATED);
    return re;
  }

  /**
   * Update Image object.
   * @param obj (Image)
   * @param id (int)
   * @return {@link ResponseEntity } {@link Image}
   */
  @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
  public ResponseEntity<Image> update(@RequestBody Image obj,@PathVariable int id) {
    Image imageobj = service.update(obj,id);
    ResponseEntity<Image> re = new ResponseEntity<Image>(imageobj, HttpStatus.OK);
    return re;
  }

  /**
   * Delete.
   * @param id (int)
   * @param response (HttpServletResponse)
   * @return {@link ResponseEntity } {@link Boolean}
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id, HttpServletResponse response) {
    service.delete(id);
    ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return re;
  }

}

