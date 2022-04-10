package com.zlesc.car;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Car {
  @Id
  @GeneratedValue
  private long id;
  private String brand;
  private String model;
  private double mileage;
  private double newprice;
  private double price;
  private double firstpayment;
  private float cc;
  private Date licensedate;
  private boolean bhairbag;
  private boolean bcentrearmrest;
  private boolean fhairbag;
  private boolean fairbag;
  private boolean fcentrearmrest;
  private boolean ppowerseat;
  private boolean spowerseat;
  private boolean afterradar;
  private boolean buttonstart;
  private boolean formerradar;
  private boolean gps;
  private boolean immobilizer;
  private boolean mfl;
  private boolean parkassist;
  private boolean turbo;
  private long u_id;
  
}
