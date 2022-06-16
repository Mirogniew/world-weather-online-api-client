package org.example.WWO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Level;
import java.util.logging.Logger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyResponse {
    private static final Logger logger = Logger.getLogger(MyResponse.class.getName());
    public MyData data;

    public static String parseToResponseJson(String bodyString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            MyResponse myResponse = mapper.readValue(bodyString, MyResponse.class);
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(myResponse);
        } catch (JsonProcessingException e) {
            logger.log(Level.WARNING, e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
