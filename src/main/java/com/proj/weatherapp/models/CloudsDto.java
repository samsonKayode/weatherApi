package com.proj.weatherapp.models;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CloudsDto implements Serializable {

    private int all;
}
