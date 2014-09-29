package jto.processing.transit.wdc.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Route implements Serializable {

  private static final long serialVersionUID = 1L;

  @Expose
  private String name;

  @Expose
  private String routeID;

  public String getName() {
    return name;
  }

  public String getRouteID() {
    return routeID;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRouteId(String routeID) {
    this.routeID = routeID;
  }

}
