package jto.processing.transit.wdc.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class BusInformation implements Serializable {

  private static final long serialVersionUID = -3869366078149570156L;

  @Expose
  List<BusPosition> busPositions;

  public List<BusPosition> getBusPositions() {
    return busPositions;
  }

  public void setBusPositions(List<BusPosition> busPositions) {
    this.busPositions = busPositions;
  }
}
