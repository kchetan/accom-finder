package com.practo.jedi.web.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practo.jedi.models.Listing;
import com.practo.jedi.models.ListingFilter;
import com.practo.jedi.service.ListingService;
import com.practo.jedi.service.PropertyTypeService;

@Controller
public class JspController {

  @Autowired
  private PropertyTypeService propService;
  @Autowired
  private ListingService listingService;

  String[] noBeds = {"1", "2", "3", "4"};
  String[] vacancyFor = {"1", "2", "3", "4"};

  String[] sortby = {"posted on - asc","posted on - desc","price - asc","price - desc"};

  private int pageSize = 3;

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public static Pageable updatePageable(final Pageable source, final int size) {
    return new PageRequest(source.getPageNumber(), size, source.getSort());
  }


  @RequestMapping(value = {"/index","/"})
  public String test(Model model) {

    model.addAttribute("propertyType", propService.getAll());
    model.addAttribute("noBeds", noBeds);
    model.addAttribute("vacancyFor", vacancyFor);
    return "index";
  }

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public String search(Model model, ListingFilter filterObj, Pageable pageable) {
    pageable = updatePageable(pageable, pageSize);
    model.addAttribute("listings",
        listingService.search(filterObj, pageable));
    model.addAttribute("vacancyFor", vacancyFor);
    model.addAttribute("noBeds", noBeds);
    model.addAttribute("propertyType", propService.getAll());
    model.addAttribute("activeFilters", filterObj);
    model.addAttribute("sortby", sortby);
    
    //System.out.println(pageable.getPageNumber() + " " + pageable.getPageSize());
    return "listings";
  }
  
  @RequestMapping(value = "/listing/{id}", method = RequestMethod.GET)
  public String getListing(Model model,@PathVariable int id) {
    Listing listingobj = listingService.get(id);
    model.addAttribute("listing", listingobj);
    model.addAttribute("propertyType", propService.getAll());
    model.addAttribute("noBeds", noBeds);
    model.addAttribute("vacancyFor", vacancyFor);
    return "listing_details";
  }

  @RequestMapping(value = "/apiary", method = RequestMethod.GET)
  public String method(HttpServletResponse httpServletResponse) {
    return "redirect:" + "http://docs.accommodationfinder.apiary.io/";
  }

}
