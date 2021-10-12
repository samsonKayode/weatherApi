package com.proj.weatherapp.models;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDto implements Serializable {

    private int id;
    private String name;
    private CoordDto coord;
    private String country;
    private int population;
    private int timezone;
    private long sunrise;
    private long sunset;
}
