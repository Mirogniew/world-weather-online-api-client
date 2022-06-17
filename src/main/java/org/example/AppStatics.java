package org.example;

public class AppStatics {
    public static final String MENU_PLACE = """
            How would you like to chose a place, for which you want to know the weather?
                     1. Choose by city
                     2. Choose by the geographical coordinates.
                     
                     
                     5. Exit.
            """;
    public static final String MENU_TIME = """
            For how many days would you like to know the weather?
                     1. See a weather for only today.
                     2. See a weather for more days.
                     
                     
                     5. Exit.
            """;
    public static final String CITY = "For which city do you want to know weather for?";
    public static final String COORDINATE = "What are your coordinates?";
    public static final String WRONG_INPUT = "I don't understand, please answer me again";
    public static final String EXIT_MESS = "Bye, hope to see you soon";
    public static final String MULTI_DAY = "For how many days do you want to know weather for?";
    public static final String KEY = "0c172e455111440c9ee114013221206";
    public static final String WWO_API_URL = "http://api.worldweatheronline.com/premium/v1/weather.ashx?key=%s&q=%s&num_of_days=%d&tp=3&format=json";

}