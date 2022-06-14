package org.example.WWO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Astronomy {
    public String sunrise;
    public String sunset;
    public String moon_phase;
    public String moonrise;
    public String moonset;
}
