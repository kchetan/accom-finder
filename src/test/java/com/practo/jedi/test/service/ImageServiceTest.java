
package com.practo.jedi.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.practo.jedi.models.Image;
import com.practo.jedi.run.Application;
import com.practo.jedi.service.ImageService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ImageServiceTest {

  @Autowired
  private ImageService service;

  @Test
  public void testGet() {
    // Get One
    Image imageObj = service.get(1);
    assertNotNull(imageObj);
    assertEquals("/accomfinder/lol", imageObj.getImagePath());
  }

  @Test
  public void testCreate() {
    Image imageObj = new Image();
    imageObj.setImagePath("http://google.com/abd/asd.jpg");
    imageObj.setListingId(1);
    imageObj = service.create(imageObj);
    Image dbImageObj = service.get(imageObj.getId());
    assertNotNull(dbImageObj);
    assertEquals("http://google.com/abd/asd.jpg", dbImageObj.getImagePath());
  }

  @Test
  public void testDelete() {
    service.delete(2);
    Image imageObj = service.get(2);
    assertNull(imageObj);
  }
}
