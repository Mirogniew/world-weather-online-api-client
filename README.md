![weatherBanner](https://map.worldweatheronline.com/assets/images/world_weather_online.jpg)

# World Weather Online API Client

As the name suggests, it is an application that allows it's user to check the weather for his/hers location of choice.

### Firstly there is a choice of a location:
```console
How would you like to chose a place, for which you want to know the weather?
                     1. Choose by city
                     2. Choose by the geographical coordinates.


                     5. Exit.
```

### And after that there is a choice of how many days does the user want to know the weather for:
```console
            For how many days would you like to know the weather?
                     1. See a weather for only today.
                     2. See a weather for more days.


                     5. Exit.
```


### Response comes in a form of a JSON.
```json
{
  "data" : {
    "weather" : [ {
      "date" : "2022-06-17",
      "avgtempC" : "16",
      "maxtempC" : "22",
      "mintempC" : "11",
      "astronomy" : [ {
        "sunrise" : "04:30 AM",
        "sunset" : "08:52 PM",
        "moon_phase" : "Waning Gibbous",
        "moonrise" : "No moonrise",
        "moonset" : "07:23 AM"
      } ]
    } ]
  }
}
```
App was written in JDK17.

There is a possibility, that the access key will expire - if that's the case, new key may be found on "https://map.worldweatheronline.com/assets/images/world_weather_online.jpg".
To use new key, it has to be pasted into string "KEY" in class "AppStatics"
