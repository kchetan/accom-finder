package com.practo.jedi.dao;

import com.practo.jedi.entity.AddressEntity;

/**
 * This is the data access object interface for Address table.
 * 
 * @author chetan
 *
 */
public interface AddressDao {

  public AddressEntity getAddress(int id);

  public void addAddress(AddressEntity address);

  public void updateAddress(AddressEntity address);

  public void deleteAddress(AddressEntity address);


}
