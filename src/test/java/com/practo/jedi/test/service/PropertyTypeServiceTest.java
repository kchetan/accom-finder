package com.practo.jedi.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.practo.jedi.models.PropertyType;
import com.practo.jedi.run.Application;
import com.practo.jedi.service.PropertyTypeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PropertyTypeServiceTest {

  @Autowired
  private PropertyTypeService service;

  @Test
  public void testGet() {
    // Get One
    PropertyType propType = service.get(1);
    assertNotNull(propType);
    assertEquals("Apartment", propType.getType());
  }


  @Test
  public void testCreate() {
    PropertyType propType = new PropertyType();
    propType.setType("Property");
    propType = service.create(propType);
    PropertyType dbPropertyType = service.get(propType.getId());
    assertNotNull(dbPropertyType);
    assertEquals("Property", dbPropertyType.getType());
  }

  @Test
  public void testUpdate() {
    PropertyType propType = service.get(3);
    propType.setType("update");

    service.update(propType, 3);

    PropertyType dbPropertyType = service.get(3);
    assertNotNull(dbPropertyType);
    assertEquals("update", dbPropertyType.getType());
  }


  @Test
  public void testDelete() {
    service.delete(2);
    PropertyType propType = service.get(2);
    assertNull(propType);
  }
}
