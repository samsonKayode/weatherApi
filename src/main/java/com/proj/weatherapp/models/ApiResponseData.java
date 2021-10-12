package com.proj.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseData implements Serializable {

    private int cod;
    private String message;
    private int cnt;
    private List<ListDataDto> list;
    private CityDto city;
}
