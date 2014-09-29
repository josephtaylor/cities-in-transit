package jto.processing.transit.wdc.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class RouteInformation implements Serializable {

  private static final long serialVersionUID = 1L;

  @Expose
  private List<Route> routes;

  public List<Route> getRoutes() {
    return routes;
  }

  public void setRoutes(List<Route> routes) {
    this.routes = routes;
  }
}
