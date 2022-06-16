package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.example.WWO.MyResponse;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.util.logging.Level.WARNING;
import static kotlin.io.ConsoleKt.readLine;
import static org.example.AppStatics.*;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            run(scan);
        } catch (InputMismatchException e) {
            logger.log(WARNING, "You should use only integers!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void run(Scanner scan) {
        String city;
        int daysNumber;
        int choice;
        while (true) {
            System.out.println(MENU_PLACE);
            choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println(CITY);
                    city = scan.next();
                }
                case 2 -> {
                    System.out.println(COORDINATE);
                    city = scan.next();
                }
                case 5 -> {
                    System.out.println(EXIT_MESS);
                    return;
                }
                default -> {
                    System.out.println(WRONG_INPUT);
                    continue;
                }
            }
            System.out.println(MENU_TIME);
            choice = scan.nextInt();
            switch (choice) {
                case 1 -> daysNumber = 1;
                case 2 -> {
                    System.out.println(MULTI_DAY);
                    daysNumber = scan.nextInt();
                }
                case 5 -> {
                    System.out.println(EXIT_MESS);
                    return;
                }
                default -> {
                    System.out.println(WRONG_INPUT);
                    continue;
                }
            }
            String response = sendRequest(city, daysNumber);
            System.out.println(MyResponse.parseToResponseJson(response));
            System.out.printf("%n%nPress any key to continue...");
            scan.next();
        }
    }

    private static String sendRequest(String city, int daysNumber) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        try (Response response = client.newCall(getRequest(city, daysNumber)).execute()) {
            return response.body().string();
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    private static Request getRequest(String city, int daysNumber) {
        return new Request.Builder()
                .url(String.format(WWO_API_URL, city, daysNumber))
                .get()
                .build();
    }
}
