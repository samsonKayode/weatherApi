package com.proj.weatherapp.models;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListDataDto implements Serializable {

    private long dt;
    private MainDto main;
    private List<WeatherDto> weather;
    private CloudsDto clouds;
    private WindDto wind;
    private int visibility;
    private double pop;
    private RainDto rain;
    private SysDto sys;
    private String dt_txt;

}
