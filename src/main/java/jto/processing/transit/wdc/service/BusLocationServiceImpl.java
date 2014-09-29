package jto.processing.transit.wdc.service;

import com.google.gson.JsonSyntaxException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

import jto.processing.transit.wdc.model.BusInformation;
import jto.processing.transit.wdc.model.BusPosition;

public class BusLocationServiceImpl extends AbstractBusApiService implements BusLocationService {

  private static final Logger log = Logger.getLogger(BusLocationServiceImpl.class);

  private static final String
      REQUEST_URL_BASE =
      "http://api.wmata.com/Bus.svc/json/JBusPositions?routeId=";

  private static final String REUQEST_URL_MIDDLE = "&includingVariations=true&api_key=";

  private String createRequestUrl(String routeId) {
    StringBuilder requestUrl = new StringBuilder();
    requestUrl.append(REQUEST_URL_BASE);
    requestUrl.append(routeId);
    requestUrl.append(REUQEST_URL_MIDDLE);
    requestUrl.append(API_KEY);

    return requestUrl.toString();
  }

  @Override
  public List<BusPosition> findLocationsByRoute(String routeId) {
    log.info("Finding bus locations for " + routeId);
    String requestUrl = createRequestUrl(routeId);
    HttpClient client = new HttpClient();
    HttpMethod httpMethod = new GetMethod(requestUrl);
    String response = "";
    try {
      client.executeMethod(httpMethod);
      response = httpMethod.getResponseBodyAsString();
      BusInformation busInformation = getGson().fromJson(response, BusInformation.class);
      return busInformation.getBusPositions();
    } catch (IOException e) {
      throw new RuntimeException("An exception occurred while trying to fetch location data.", e);
    } catch (JsonSyntaxException jse) {
      throw new RuntimeException("Failed to parse json: " + response + " from " + requestUrl);
    } finally {
      httpMethod.releaseConnection();
    }
  }
}
