package com.practo.jedi.web.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JspController {

  @RequestMapping("/index")
  public String test(ModelAndView modelAndView) {
    return "index";
  }
  
  @RequestMapping(value = "/apiary", method = RequestMethod.GET)
  public String method(HttpServletResponse httpServletResponse) {
    return "redirect:" + "http://docs.accommodationfinder.apiary.io/";
  }

}
