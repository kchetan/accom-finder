package com.practo.jedi.run;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

// import log4j2test.MyClass;

@ComponentScan(basePackages = {"com.practo.jedi"})
@EnableJpaRepositories(basePackages = {"com.practo.jedi.dao"})
@EntityScan("com.practo.jedi.entity")
@ImportResource("classpath:hibernate.xml")
@EnableAutoConfiguration
@EnableTransactionManagement
@Controller
public class Application extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String method(HttpServletResponse httpServletResponse) {
    return "redirect:" + "http://docs.accommodationfinder.apiary.io/";
  }

  /**
   * Spring Boot Main application.
   * @param args (String array)
   * @throws Exception ()
   */
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
    // MyClass chetan = new MyClass();
    // chetan.logWithTag();
    // chetan.logException();
    // chetan.logSimpleMessage();
  }
}
