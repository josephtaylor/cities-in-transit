package jto.processing.transit.wdc.service;

import java.util.List;

import jto.processing.transit.wdc.model.BusPosition;

public interface BusLocationService {
  List<BusPosition> findLocationsByRoute(String routeId);
}
