package com.practo.jedi.dao;

import com.practo.jedi.entity.AddressEntity;

public interface AddressDao {

  public AddressEntity getAddress(int id);

  public void addAddress(AddressEntity address);

  public void updateAddress(AddressEntity address);

  public void deleteAddress(AddressEntity address);


}
