package com.practo.jedi.dao;

import com.practo.jedi.entity.ImageEntity;

public interface ImageDao {

  public ImageEntity getImage(int id);

  public void addImage(ImageEntity image);

  public void updateImage(ImageEntity image);

  public void deleteImage(ImageEntity image);


}
