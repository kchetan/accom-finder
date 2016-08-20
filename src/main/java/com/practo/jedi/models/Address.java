package com.practo.jedi.models;

import com.practo.jedi.entity.AddressEntity;

public class Address {
  private String locality;
  private String plotNo;
  private String propertyName;

  public Address() {}


  public Address(String locality, String plotNo, String propertyName) {
    super();
    this.locality = locality;
    this.plotNo = plotNo;
    this.propertyName = propertyName;
  }

  public String getLocality() {
    return locality;
  }

  public void setLocality(String locality) {
    this.locality = locality;
  }

  public String getPlotNo() {
    return plotNo;
  }

  public void setPlotNo(String plotNo) {
    this.plotNo = plotNo;
  }

  public String getPropertyName() {
    return propertyName;
  }

  public void setPropertyName(String propertyName) {
    this.propertyName = propertyName;
  }

  private int id;



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Address";
  }

  public AddressEntity EntityObj() {
    // System.out.println("came get");
    AddressEntity et = new AddressEntity();
    et.setPlotNo(getPlotNo());
    et.setLocality(getLocality());
    et.setPropertyName(getPropertyName());
    if (new Integer(getId()) != null)
      et.setId(getId());
    return et;
  }

  public void mergeEntity(AddressEntity e) {
    if (e != null) {
      setPlotNo(e.getPlotNo());
      setLocality(e.getLocality());
      setPropertyName(e.getPropertyName());
      setId(e.getId());
      // System.out.println("end merge");
    }
  }
}
