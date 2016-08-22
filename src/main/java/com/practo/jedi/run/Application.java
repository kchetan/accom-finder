package com.practo.jedi.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

// import log4j2test.MyClass;

@ComponentScan(basePackages = {"com.practo.jedi"})
@EnableJpaRepositories(basePackages = {"com.practo.jedi.dao"})
@EntityScan("com.practo.jedi.entity")
@RestController
@EnableAutoConfiguration
public class Application {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
    // MyClass chetan = new MyClass();
    // chetan.logWithTag();
    // chetan.logException();
    // chetan.logSimpleMessage();
  }
}
