package jto.processing.transit.wdc.service;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

import jto.processing.transit.wdc.model.Route;
import jto.processing.transit.wdc.model.RouteInformation;

public class RouteServiceImpl extends AbstractBusApiService implements RouteService {

  private static final Logger log = Logger.getLogger(RouteServiceImpl.class);

  private static final String REQUEST_URL = "http://api.wmata.com/Bus.svc/json/JRoutes?api_key=";

  @Override
  public List<Route> fetchRoutes() {
    log.info("fetching routes");
    HttpClient client = new HttpClient();
    HttpMethod method = new GetMethod(REQUEST_URL + API_KEY);
    try {
      client.executeMethod(method);
      String result = method.getResponseBodyAsString();
      RouteInformation routeInformation = getGson().fromJson(result, RouteInformation.class);
      return routeInformation.getRoutes();
    } catch (IOException e) {
      throw new RuntimeException("An exception occurred while fetching the Routes.", e);
    } finally {
      method.releaseConnection();
    }
  }
}
