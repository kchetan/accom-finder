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

  // public BooleanExpression noBedsPredicate(BooleanExpression predicate) {
  // QListingEntity b1 = QListingEntity.listingEntity;
  // String[] beds = noBeds.split("\\|");
  // // System.out.println(Arrays.toString(beds)+" - length");
  // List<Integer> collectionObj = new ArrayList<Integer>();
  // for (String each : beds) {
  // try {
  // collectionObj.add(Integer.parseInt(each));
  // } catch (Exception e) {
  // ;
  // }
  // }
  // predicate = predicate.and(b1.noBeds.in(collectionObj));
  // return predicate;
  // }

  // public BooleanExpression vacancyForPredicate(BooleanExpression predicate){
  // QListingEntity b1 = QListingEntity.listingEntity;
  // String[] vacancies = vacancyFor.split("\\|");
  // List<Integer> collectionObj = new ArrayList<Integer>();
  // for (String each : vacancies) {
  // try {
  // collectionObj.add(Integer.parseInt(each));
  // } catch (Exception e) {
  // ;
  // }
  // }
  // predicate = predicate.and(b1.vacancyFor.in(collectionObj));
  // return predicate;
  // }

  // public BooleanExpression propertyTypePredicate(BooleanExpression predicate){
  // QListingEntity b1 = QListingEntity.listingEntity;
  // String[] pTypes = propertyType.split("\\|");
  // List<String> collectionObj = new ArrayList<String>();
  // for (String each : pTypes) {
  // try {
  // collectionObj.add(each);
  // } catch (Exception e) {
  // ;
  // }
  // }
  // predicate = predicate.and(b1.propertyType.type.in(collectionObj));
  // return predicate;
  // }

  // public Predicate toPredicate() {
  // QListingEntity b1 = QListingEntity.listingEntity;
  // BooleanExpression predicate = b1.deleted.eq(false);
  // predicate = predicate.and(b1.area.between(min_area, max_area));
  // predicate = predicate.and(b1.price.between(min_price, max_price));
  // if (noBeds != null && noBeds != "") {
  // predicate = noBedsPredicate(predicate);
  // }
  // if (propertyType != null && propertyType != "") {
  // predicate = propertyTypePredicate(predicate);
  // }
  // if (vacancyFor != null && vacancyFor != "") {
  // predicate = vacancyForPredicate(predicate);
  // }
  // if (furnished != null && furnished != "") {
  // String[] furnish = furnished.split("\\|");
  // predicate = predicate.and(b1.furnished.in(furnish));
  // }
  // if (roomFor != null && roomFor != "") {
  // predicate = predicate.and(b1.roomFor.in(roomFor));
  // }
  // if (possessionDate != null && possessionDate != "") {
  // try {
  // DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
  // Date posDate = df.parse(possessionDate);
  // predicate = predicate.and(b1.possesionDate.loe(posDate));
  // } catch (ParseException e) {
  // ;
  // }
  // }
  // return predicate;
  // }

}
