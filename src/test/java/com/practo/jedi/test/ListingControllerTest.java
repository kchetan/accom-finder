package com.practo.jedi.test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practo.jedi.models.Listing;
import com.practo.jedi.run.Application;
import com.practo.jedi.service.ListingService;

/**
 * @author chetan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class ListingControllerTest {
  
  private int  pagesize = 3;

  public int getPagesize() {
    return pagesize;
  }


  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  @Autowired
  private ListingService service;

  private RestTemplate restTemplate = new TestRestTemplate();


  @Test
  public void testGetListing() {
    int id = 1;
    Listing apiResponse =
        restTemplate.getForObject("http://localhost:8080/listings/" + id, Listing.class);
    Listing listing = service.get(id);
    // System.out.println(apiResponse.getTitle());
    if (listing != null) {
      assertNotNull("Expected non null object", apiResponse);
      assertEquals(listing.getId(), apiResponse.getId());
      assertEquals(listing.getTitle(), apiResponse.getTitle());
    }

  }

  @SuppressWarnings("unused")
  @Test
  public void testGetAllListing() {
    Iterable<Listing> apiResponse =
        restTemplate.getForObject("http://localhost:8080/listings", Iterable.class);
    Pageable page = new PageRequest(0, this.pagesize, null);
    Iterable<Listing> listing = service.getAll(page);
    // System.out.println(apiResponse.getType());
    assertNotNull("Expected non null object", apiResponse);
    int size1 = 0, size2 = 0;
    for (Object each : apiResponse) {
      size1 += 1;
    }
    for (Object each : listing) {
      size2 += 1;
    }
    assertEquals(size1, size2);

  }

  @Test
  public void testcreateListing() {

  }
}
