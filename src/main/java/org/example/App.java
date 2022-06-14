package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;

import okhttp3.*;
import org.example.WWO.MyRequest;

public class App {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=0c172e455111440c9ee114013221206&q=Warsaw&num_of_days=1&tp=3&format=json")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            MyRequest myResponse = new ObjectMapper().readValue(string, MyRequest.class);
            String body = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(myResponse);
            System.out.println(body);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
