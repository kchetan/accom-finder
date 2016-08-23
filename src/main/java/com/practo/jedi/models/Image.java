package com.practo.jedi.models;

import javax.transaction.Transactional;

import com.practo.jedi.entity.ImageEntity;

public class Image {
  private String imagePath;
  private int id;

  public Image() {}

  public Image(String imagePath) {
    this.imagePath = imagePath;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  @Override
  public String toString() {
    return "Image [path=" + imagePath + "]";
  }

  @Transactional
  public ImageEntity EntityObj() {
    // System.out.println("came get");
    ImageEntity et = new ImageEntity();
    et.setImagePath(getImagePath());
    if (new Integer(getId()) != null)
      et.setId(getId());
    return et;
  }

  @Transactional
  public void mergeEntity(ImageEntity e) {
    if (e != null) {
      setImagePath(e.getImagePath());
      setId(e.getId());
      // System.out.println("end merge");
    }
  }

  @Transactional
  public ImageEntity UpdateEntity(ImageEntity et) {
    et.setImagePath(getImagePath());
    et.setId(getId());
    return et;
  }
}
