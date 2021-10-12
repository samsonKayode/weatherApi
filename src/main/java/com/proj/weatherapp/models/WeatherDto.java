package com.proj.weatherapp.models;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto implements Serializable {

    private int id;
    private String main;
    private String description;
    private String icon;
}
