package com.practo.jedi.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practo.jedi.models.PropertyType;
import com.practo.jedi.run.Application;
import com.practo.jedi.service.PropertyTypeService;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class PropertyTypeControllerTest {


  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

 
  @Autowired
  private PropertyTypeService service;

  private RestTemplate restTemplate = new TestRestTemplate();

  
  @Test
  public void testGetPropertyType() {
    int id = 1;
    PropertyType apiResponse = restTemplate.getForObject("http://localhost:8080/propertytype/" + id, PropertyType.class);
    PropertyType PropertyType = service.get(id);
    //System.out.println(apiResponse.getType());
    assertNotNull("Expected non null object",apiResponse);
    assertEquals(PropertyType.getType(), apiResponse.getType());
    assertEquals(PropertyType.getId(), apiResponse.getId());
  }
  
  @SuppressWarnings("unused")
  @Test
  public void testGetAllPropertyType() {
    Iterable<PropertyType> apiResponse = restTemplate.getForObject("http://localhost:8080/propertytype", Iterable.class);
    Iterable<PropertyType> propertyType = service.getAll();
    //System.out.println(apiResponse.getType());
    assertNotNull("Expected non null object",apiResponse);
    int size1 = 0,size2 =0;
    for (Object each:apiResponse){
      size1+=1;
    }
    for (Object each:propertyType){
      size2+=1;
    }
    assertEquals(size1, size2);
    
  }
}
