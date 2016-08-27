package com.practo.jedi.models;

public class ListingFilter {
  private String noBeds = null;
  private float min_area = 0;
  private float max_area = Float.MAX_VALUE;
  private Integer min_price = 0;
  private Integer max_price = Integer.MAX_VALUE;
  private String furnished = null;
  private String propertyType = null;
  private String roomFor = null;
  private String possessionDate = null;
  private String vacancyFor = null;
  private String area;
  private String price;
  private String sortby;
  private String locality;
  private String plotNo;
  private String title;
  private String propertyName;
  private String[] images;
  
  public String[] getImages() {
    return images;
  }

  public void setImages(String[] images) {
    this.images = images;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

 
  

  public String getLocality() {
    return locality;
  }

  public void setLocality(String locality) {
    this.locality = locality;
  }

  public String getSortby() {
    return sortby;
  }

  public void setSortby(String sortby) {
    this.sortby = sortby;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getVacancyFor() {
    return vacancyFor;
  }

  public void setVacancyFor(String vacancyFor) {
    this.vacancyFor = vacancyFor;
  }

  public String getNoBeds() {
    return noBeds;
  }

  public void setNoBeds(String noBeds) {
    this.noBeds = noBeds;
  }

  public float getMin_area() {
    return min_area;
  }

  public void setMin_area(float min_area) {
    this.min_area = min_area;
  }

  public float getMax_area() {
    return max_area;
  }

  public void setMax_area(float max_area) {
    this.max_area = max_area;
  }

  public Integer getMin_price() {
    return min_price;
  }

  public void setMin_price(Integer min_price) {
    this.min_price = min_price;
  }

  public Integer getMax_price() {
    return max_price;
  }

  public void setMax_price(Integer max_price) {
    this.max_price = max_price;
  }

  public String getFurnished() {
    return furnished;
  }

  public void setFurnished(String furnished) {
    this.furnished = furnished;
  }

  public String getPropertyType() {
    return propertyType;
  }

  public void setPropertyType(String propertyType) {
    this.propertyType = propertyType;
  }

  public String getRoomFor() {
    return roomFor;
  }

  public void setRoomFor(String roomFor) {
    this.roomFor = roomFor;
  }

  public String getPossessionDate() {
    return possessionDate;
  }

  public void setPossessionDate(String possessionDate) {
    this.possessionDate = possessionDate;
  }

}
