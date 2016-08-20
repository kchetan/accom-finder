package com.practo.jedi.models;

import com.practo.jedi.entity.PropertyTypeEntity;

public class PropertyType {
  private String type;
  private int id;

  public PropertyType() {}

  public PropertyType(String type) {
    this.type = type;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Ptype [name=" + type + "]";
  }
  
  public PropertyTypeEntity EntityObj() {
    //System.out.println("came get");
    PropertyTypeEntity et = new PropertyTypeEntity();
    et.setType(getType());
    if (new Integer(getId()) != null)
      et.setId(getId());
    return et;
  }

  public void mergeEntity(PropertyTypeEntity e) {
    if (e != null) {
      setType(e.getType());
      setId(e.getId());
      // System.out.println("end merge");
    }
  }
}
