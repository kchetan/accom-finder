
package com.practo.jedi.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.practo.jedi.models.Address;
import com.practo.jedi.run.Application;
import com.practo.jedi.service.AddressService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AddressServiceTest {

  @Autowired
  private AddressService service;

  @Test
  public void testGet() {
    // Get One
    Address addressObj = service.get(1);
    assertNotNull(addressObj);
    assertEquals("L 605", addressObj.getPlotNo());
    assertEquals("Raj Lake View", addressObj.getPropertyName());
    assertEquals("Bilekahalli", addressObj.getLocality());
  }


  @Test
  public void testCreate() {
    Address addressObj = new Address();
    addressObj.setPlotNo("221");
    addressObj.setPropertyName("Kalyani magnum");
    addressObj.setLocality("Bilekahalli");
    addressObj = service.create(addressObj);
    Address dbAddressObj = service.get(addressObj.getId());
    assertNotNull(dbAddressObj);
    assertEquals("221", dbAddressObj.getPlotNo());
    assertEquals("Kalyani magnum", dbAddressObj.getPropertyName());
    assertEquals("Bilekahalli", dbAddressObj.getLocality());
  }

  @Test
  public void testUpdate() {
    Address addressObj = service.get(1);
    addressObj.setPlotNo("222");
    addressObj.setPropertyName("Kalyani magnum");
    addressObj.setLocality("Bilekahalli");

    service.update(addressObj, 1);

    Address dbAddressObj = service.get(1);
    assertNotNull(dbAddressObj);
    assertEquals("222", dbAddressObj.getPlotNo());
    assertEquals("Kalyani magnum", dbAddressObj.getPropertyName());
    assertEquals("Bilekahalli", dbAddressObj.getLocality());
  }

  @Test
  public void testDelete() {
    service.delete(2);
    Address addressObj = service.get(2);
    assertNull(addressObj);
  }
}
