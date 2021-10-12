package com.proj.weatherapp.models;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WindDto implements Serializable {

    private double speed;
    private int deg;
    private double gust;
}
