package com.proj.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RainDto implements Serializable {

    @JsonProperty(value = "3h")
    private double threeHourly;

}
