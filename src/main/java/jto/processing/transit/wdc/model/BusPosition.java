package jto.processing.transit.wdc.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class BusPosition implements Serializable {

  private static final long serialVersionUID = -8662872592479997560L;

  @Expose
  public Double lat;

  @Expose
  public Double lon;

  public Double getLat() {
    return lat;
  }

  public Double getLon() {
    return lon;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public void setLon(Double lon) {
    this.lon = lon;
  }
}
