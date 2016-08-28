package com.practo.jedi.web.controllers;



import com.practo.jedi.models.Address;
import com.practo.jedi.models.Listing;
import com.practo.jedi.models.ListingFilter;
import com.practo.jedi.models.PropertyType;
import com.practo.jedi.models.User;
import com.practo.jedi.service.AddressService;
import com.practo.jedi.service.ListingService;
import com.practo.jedi.service.MailerService;
import com.practo.jedi.service.PropertyTypeService;
import com.practo.jedi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class JspController {

  @Autowired
  private MailerService smtpMailSender;

  @Autowired
  private PropertyTypeService propService;
  @Autowired
  private ListingService listingService;

  @Autowired
  private UserService userService;

  @Autowired
  private AddressService addressService;

  String[] noBeds = {"1", "2", "3", "4"};
  String[] vacancyFor = {"1", "2", "3", "4"};

  String[] sortby = {"posted on - asc", "posted on - desc", "price - asc", "price - desc"};

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


  @RequestMapping(value = {"/index", "/"})
  public String index(Model model, HttpSession session) {
    model.addAttribute("session", session.getAttribute("id"));
    model.addAttribute("propertyType", propService.getAll());
    model.addAttribute("noBeds", noBeds);
    model.addAttribute("vacancyFor", vacancyFor);
    return "index";
  }

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public String search(Model model, ListingFilter filterObj, Pageable pageable) {
    pageable = updatePageable(pageable, pageSize);
    model.addAttribute("listings", listingService.search(filterObj, pageable));
    model.addAttribute("vacancyFor", vacancyFor);
    model.addAttribute("noBeds", noBeds);
    model.addAttribute("propertyType", propService.getAll());
    model.addAttribute("activeFilters", filterObj);
    model.addAttribute("sortby", sortby);

    // System.out.println(pageable.getPageNumber() + " " + pageable.getPageSize());
    return "listings";
  }

  @RequestMapping(value = "/listing/{id}", method = RequestMethod.GET)
  public String getListing(Model model, @PathVariable int id) {
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

  @RequestMapping(value = "/newproperty", method = RequestMethod.GET)
  public String newproperty(Model model, HttpSession session) {
    if (session.getAttribute("id") == null) {
      return "redirect:/";
    }
    model.addAttribute("propertyType", propService.getAll());
    model.addAttribute("noBeds", noBeds);
    model.addAttribute("vacancyFor", vacancyFor);
    return "newproperty";
  }

  @RequestMapping(value = "/submitProperty", method = RequestMethod.POST)
  public String submitproperty(Model model, ListingFilter listingObj, String[] images,
      HttpSession session) {
    if (session.getAttribute("id") == null) {
      return "redirect:/";
    }
    Listing listing = new Listing();
    try {

      // ------ IMAge upload to S3
      // --------

      listing.setTitle(listingObj.getTitle());
      listing.setNoBeds(Integer.parseInt(listingObj.getNoBeds()));
      listing.setFurnished(listingObj.getFurnished());
      listing.setRoomFor(listingObj.getRoomFor());
      listing.setVacancyFor(Integer.parseInt(listingObj.getVacancyFor()));
      listing.setArea(Float.parseFloat(listingObj.getArea()));
      listing.setPrice(Integer.parseInt(listingObj.getPrice()));
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      Date posDate = df.parse(listingObj.getPossessionDate());
      listing.setPossesionDate(posDate);
      ///// -------------------------
      User user = userService.getUserByEmail((String) session.getAttribute("email"));
      listing.setUser(user.EntityObj());

      PropertyType ptype = propService.get(Integer.parseInt(listingObj.getPropertyType()));
      listing.setPropertyType(ptype.EntityObj());


      Address addr = new Address();
      addr.setPropertyName(listingObj.getPropertyName());
      addr.setPlotNo(listingObj.getPlotNo());
      addr.setLocality(listingObj.getLocality());

      addressService.create(addr);

      listing.setAddress(addr.EntityObj());

      listing.setPropertyType(ptype.EntityObj());


      listingService.create(listing);
    } catch (Exception err) {
      err.printStackTrace();
      return "redirect:/";
    }

    return "redirect:/listing/" + listing.getId();
  }

  @RequestMapping(value = "/contactOwner", method = RequestMethod.POST)
  public String contactOwner(Model model, String name, String email, String mobile, String body,
      String listingId, HttpSession session) throws MessagingException {
    Listing listingObj = listingService.get(Integer.parseInt(listingId));
    smtpMailSender.send(listingObj.getUser().getEmail(), "Regarding Listing on Accom finder",
        body + "<br >" + "ListingId (for reference): " + listingId
            + " <br><b> Contacted By :<b><br>" + "email: " + email + "<br> Mobile: " + mobile);
    smtpMailSender.send(email, "Greetings From AccomFinder",
        "Thank You for using AccomFinder <br>  You have requested an interest on a Listing "
            + "ListingId (for reference): " + listingId + "<br > <br > Contacted Owner <br>"
            + "Name: " + listingObj.getUser().getName() + "<br> Mobile: " + mobile);
    model.addAttribute("message", "Contacted By Email");

    return "";
  }

  @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
  public void loginUser(Model model, String id, String email, String name, HttpSession session) {
    session.setAttribute("id", id);
    session.setAttribute("email", email);
    session.setAttribute("name", name);
    User user = userService.getUserByEmail((String) session.getAttribute("email"));
    if (user.getEmail() == null) {
      User createuser = new User();
      createuser.setEmail((String) session.getAttribute("email"));
      createuser.setName((String) session.getAttribute("name"));
      userService.create(createuser);
    }
  }

  @RequestMapping(value = "/logoutUser", method = RequestMethod.POST)
  public void logoutUser(Model model, HttpSession session) {

    session.invalidate();
  }

  @RequestMapping(value = "/test", method = RequestMethod.POST)
  public void dummy(Model model) {

  }



}
