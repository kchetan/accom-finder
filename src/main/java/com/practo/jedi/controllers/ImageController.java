package com.practo.jedi.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.models.Image;
import com.practo.jedi.service.ImageService;

@RestController
@RequestMapping("/image")
public class ImageController {
  @Autowired
  private ImageService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Image> getImage(@PathVariable int id) {
    Image imageobj = service.get(id);
    ResponseEntity<Image> re = new ResponseEntity<Image>(imageobj, HttpStatus.OK);
    return re;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Image> create(@RequestBody Image obj) {
    Image imageobj = service.create(obj);
    ResponseEntity<Image> re = new ResponseEntity<Image>(imageobj, HttpStatus.CREATED);
    return re;
  }

  @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
  public ResponseEntity<Image> update(@RequestBody Image obj,@PathVariable int id) {
    Image imageobj = service.update(obj,id);
    ResponseEntity<Image> re = new ResponseEntity<Image>(imageobj, HttpStatus.OK);
    return re;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id, HttpServletResponse response) {
    service.delete(id);
    ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return re;
  }

}

