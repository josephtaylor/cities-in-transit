package jto.processing.transit.wdc.service;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import jto.processing.transit.wdc.model.BusPosition;

import static org.junit.Assert.assertNotNull;

public class BusPositionServiceImplTest {
  @Ignore
  @Test
  public void testFindLocationsByRoute() throws Exception {
    BusLocationService busLocationService = new BusLocationServiceImpl();
    List<BusPosition> locations = busLocationService.findLocationsByRoute("10A");
    assertNotNull(locations);
  }
}