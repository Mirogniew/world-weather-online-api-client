package org.example.WWO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    public String date;
    public String avgtempC;
    public String maxtempC;
    public String mintempC;
    public List<Astronomy> astronomy;
}
