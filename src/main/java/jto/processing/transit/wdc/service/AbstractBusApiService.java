package jto.processing.transit.wdc.service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AbstractBusApiService {

  protected static final String API_KEY = System.getProperty("apiKey");

  private Gson gson;

  protected Gson getGson() {
    if (null != gson) {
      return gson;
    }
    gson = new GsonBuilder()
        .serializeNulls()
        .excludeFieldsWithoutExposeAnnotation()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .create();

    return gson;
  }
}
