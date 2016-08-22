package com.practo.jedi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JspController {

  @RequestMapping("/")
    public String test(ModelAndView modelAndView) {
        
        return "index";
  }
    
}