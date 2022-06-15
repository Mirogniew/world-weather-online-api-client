package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;

import okhttp3.*;
import org.example.WWO.MyRequest;

public class App {
    public static void main(String[] args) {
        boolean isRunning = true;
        Scanner answer;
        String city = "Cracow", num_of_days = "1";
        while (isRunning) {
            boolean showWeather = true;
            System.out.print("""
                    What would you like to do?
                             1. Choose a city
                             2. Write the geographical coordinates. 
                             3. See a weather for only today.
                             4. See a weather for more days.
                             5. Exit.
                    """);
            Scanner scan = new Scanner(System.in);
            String choice = scan.next();
            switch (choice) {
                case "1":
                    System.out.println("For which city do you want to know weather for?");
                    city = scan.next();
                    break;
                case "2":
                    System.out.println("Which location do you want to know weather for?");
                    city = scan.next();
                    break;
                case "3":
                    num_of_days = "1";
                    break;
                case "4":
                    System.out.println("For how many days do you want to know weather for?");
                    num_of_days = scan.next();
                    try {
                        Integer.parseInt(num_of_days);
                    } catch (NumberFormatException e) {
                        System.out.println("I understand only numbers, please answer me again");
                        showWeather = false;
                    }
                    break;
                case "5":
                    System.out.println("Bye, hope to see you soon");
                    showWeather = false;
                    isRunning = false;
                    break;
                default:
                    System.out.println("I don't understand, please answer me again");
                    showWeather = false;
                    break;
            }

            if (showWeather) {
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                Request request = new Request.Builder()
                        .url("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=0c172e455111440c9ee114013221206&q="
                                + city + "&num_of_days=" + num_of_days + "&tp=3&format=json")
                        .get()
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    String string = response.body().string();
                    ObjectMapper mapper = new ObjectMapper();
                    MyRequest myResponse = mapper.readValue(string, MyRequest.class);
                    String body = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(myResponse);
                    System.out.println(body);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                scan.close();
            }
        }
    }
}
