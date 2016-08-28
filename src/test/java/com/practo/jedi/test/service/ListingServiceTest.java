package com.practo.jedi.test.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.practo.jedi.models.Listing;
import com.practo.jedi.models.ListingFilter;
import com.practo.jedi.models.PropertyType;
import com.practo.jedi.run.Application;
import com.practo.jedi.service.ListingService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ListingServiceTest {

  @Autowired
  private ListingService service;

  @Test
  public void testGet() {
    // Get One
    Listing listingObj = service.get(1);
    assertNotNull(listingObj);
    assertEquals("Room available", listingObj.getTitle());
    assertEquals(1, listingObj.getPostedById());
    assertEquals(1, listingObj.getAddressId());
    assertEquals(2, listingObj.getPropertyId());
    assertEquals(3, listingObj.getNoBeds());
    assertEquals(8000, listingObj.getPrice());
    assertEquals("semi-furnished", listingObj.getFurnished());
    assertEquals("male", listingObj.getRoomFor());
  }


  @Test
  public void testCreate() {
    Listing listingObj = new Listing();
    listingObj.setTitle("2 bhk Room available");
    listingObj.setPostedById(2);
    listingObj.setAddressId(1);
    listingObj.setPropertyId(3);
    listingObj.setNoBeds(1);
    listingObj.setPrice(7500);
    listingObj.setFurnished("unfurnished");
    listingObj.setRoomFor("female");
    listingObj = service.create(listingObj);
    Listing dbListing = service.get(listingObj.getId());
    assertNotNull(dbListing);
    assertEquals("2 bhk Room available", dbListing.getTitle());
    assertEquals(2, dbListing.getPostedById());
    assertEquals(1, dbListing.getAddressId());
    assertEquals(3, dbListing.getPropertyId());
    assertEquals(1, dbListing.getNoBeds());
    assertEquals(7500, dbListing.getPrice());
    assertEquals("unfurnished", dbListing.getFurnished());
    assertEquals("female", dbListing.getRoomFor());
  }

  @Test
  public void testUpdate() {
    Listing listingObj = service.get(1);
    Date date = new Date();
    listingObj.setTitle("A room in 4 bhk available");
    listingObj.setPostedById(2);
    listingObj.setAddressId(2);
    listingObj.setPropertyId(3);
    listingObj.setNoBeds(4);
    listingObj.setPrice(1000);
    listingObj.setVacancyFor(1);
    listingObj.setPossesionDate(date);
    listingObj.setFurnished("fully-furnished");
    listingObj.setRoomFor("female");

    service.update(listingObj, 1);
    Listing dblistingObj = service.get(1);
    assertEquals("A room in 4 bhk available", dblistingObj.getTitle());

    assertEquals(date, dblistingObj.getPossesionDate());
    assertEquals(4, dblistingObj.getNoBeds());
    assertEquals(1, dblistingObj.getVacancyFor());
    assertEquals(1000, dblistingObj.getPrice());
    assertEquals("fully-furnished", dblistingObj.getFurnished());
    assertEquals("female", dblistingObj.getRoomFor());
    assertNotNull(dblistingObj.getAddressId());
    assertNotNull(dblistingObj.getPostedById());
    assertNotNull(dblistingObj.getPropertyId());
  }

  @Test
  public void testSearch() {
    // Filters (1,1,'Room available',1,2,3,1500,8000,1,'semi-furnished','male','2016-09-04
    // 23:24:26','2016-08-29 23:24:26',0,null);
    ListingFilter filterObj = new ListingFilter();
    filterObj.setArea("1000;1600");
    filterObj.setFurnished("semi-furnished|furnished");
    filterObj.setLocality("bile");
    filterObj.setNoBeds("3|4");
    filterObj.setPossessionDate("2016-12-12");
    filterObj.setPrice("6000;9000;");
    filterObj.setVacancyFor("1|2");
    filterObj.setRoomFor("male|female");
    filterObj.setPropertyType("2|1");

    ArrayList<Listing> trips =
        (ArrayList<Listing>) service.search(filterObj, new PageRequest(0, 2));
    assertNotNull(trips);
    assertEquals(1, trips.size());
  }
  
  @Test
  public void testGetAll() {
    Iterable<Listing> Obj = service.getAll(new PageRequest(0, 5));
    assertNotNull(Obj);
  }

  @Test
  public void testDelete() {
    service.delete(2);
    Listing listingObj = service.get(2);
    assertNull(listingObj);
  }
}
