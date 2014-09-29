package jto.processing.transit.wdc.service;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import jto.processing.transit.wdc.model.Route;

import static org.junit.Assert.assertNotNull;

public class RouteServiceImplTest {
  @Ignore
  @Test
  public void testFetchRoutes() {
    RouteService routeService = new RouteServiceImpl();
    List<Route> routes = routeService.fetchRoutes();
    assertNotNull(routes);
  }
}