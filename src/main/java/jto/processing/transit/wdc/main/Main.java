package jto.processing.transit.wdc.main;

import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jto.processing.transit.wdc.model.BusPosition;
import jto.processing.transit.wdc.model.Route;
import jto.processing.transit.wdc.service.BusLocationService;
import jto.processing.transit.wdc.service.BusLocationServiceImpl;
import jto.processing.transit.wdc.service.RouteService;
import jto.processing.transit.wdc.service.RouteServiceImpl;

public class Main {

  private static final Logger log = Logger.getLogger(Main.class);

  public static void main(String[] args) {
    if (null == System.getProperty("apiKey")) {
      log.error("Please provide an apiKey system argument");
      System.exit(-1);
    }

    PrintWriter printWriter = null;
    try {
      printWriter = new PrintWriter(
          new BufferedWriter(new FileWriter("wdc.txt", true))
      );
    } catch (IOException e) {
      log.error("Error opening file", e);
      System.exit(-1);
    }
    try {
      RouteService routeService = new RouteServiceImpl();
      List<Route> routeList = routeService.fetchRoutes();

      BusLocationService busLocationService = new BusLocationServiceImpl();

      for (Route route : routeList) {
        List<BusPosition>
            busPositionList = busLocationService.findLocationsByRoute(route.getRouteID());
        for (BusPosition busPosition : busPositionList) {
          writeLocation(busPosition, printWriter);
        }
        try {
          Thread.sleep(250L);
        } catch (InterruptedException e) {
          log.error("Something happened while sleeping.", e);
        }
      }
    } finally {
      printWriter.close();
    }
  }

  private static void writeLocation(BusPosition busPosition, PrintWriter printWriter) {
    StringBuilder location = new StringBuilder();
    location.append(busPosition.getLat()).append(",");
    location.append(busPosition.getLon()).append("\n");
    printWriter.print(location.toString());
  }
}
