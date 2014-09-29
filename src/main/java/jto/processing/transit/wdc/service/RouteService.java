package jto.processing.transit.wdc.service;

import java.util.List;

import jto.processing.transit.wdc.model.Route;

public interface RouteService {
  List<Route> fetchRoutes();
}
