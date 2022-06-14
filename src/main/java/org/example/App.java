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
            System.out.printf("""
                    What would you like to do?
                             1. Choose a city
                             2. Write the geographical coordinates. 
                             3. See a weather for only today.
                             4. See a weather for more days.
                             5. Look at the content of DataBase.
                             6. Exit.
                    """);
            Scanner scan = new Scanner(System.in);
            String choice = scan.next();
            switch (choice) {
                case "1":
                    System.out.printf("For which city do you want to know weather for?\n");
                    answer = new Scanner(System.in);
                    city = answer.next();
                    break;
                case "2":
                    System.out.printf("Which location do you want to know weather for?\n");
                    answer = new Scanner(System.in);
                    city = answer.next();
                    break;
                case "3":
                    num_of_days = "1";
                    break;
                case "4":
                    System.out.printf("For how many days do you want to know weather for?\n");
                    answer = new Scanner(System.in);
                    num_of_days = answer.next();
                    try {
                        Integer.parseInt(num_of_days);
                    } catch (NumberFormatException e) {
                        System.out.printf("I understand only numbers, please answer me again\n\n");
                        showWeather = false;
                    }
                    break;
                case "5":
                    System.out.println("Sorry, for the time being, database is empty.\n\n");
                    showWeather = false;
                    break;
                case "6":
                    System.out.printf("Bye, hope to see you soon");
                    showWeather = false;
                    isRunning = false;
                    break;
                default:
                    System.out.printf("I don't understand, please answer me again\n\n");
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
                    MyRequest myResponse = new ObjectMapper().readValue(string, MyRequest.class);
                    String body = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(myResponse);
                    System.out.println(body);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
