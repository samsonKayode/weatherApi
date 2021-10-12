package com.proj.weatherapp.api.resources.impl;

import com.proj.weatherapp.api.resources.WeatherApi;
import com.proj.weatherapp.constants.Units;
import com.proj.weatherapp.exceptions.InvalidUnitException;
import com.proj.weatherapp.exceptions.LimitExceededException;
import com.proj.weatherapp.models.ApiResponseData;
import com.proj.weatherapp.models.CityDto;
import com.proj.weatherapp.models.MainDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class WeatherApiImplTest {

    private int locationID=2332453;
    private String unit="METRIC";

    private CityDto cityDto;
    private MainDto mainDto;
    private ApiResponseData apiResponseData;

    @Mock
    private WeatherApi weatherApi;

    private  WeatherApi weatherApi1 = Mockito.mock(WeatherApi.class);

    @BeforeEach
    void setUp() {

        cityDto = new CityDto();
        cityDto.setId(2332453);
        cityDto.setName("Lagos State");
        cityDto.setCountry("NG");

        mainDto = new MainDto();
        mainDto.setFeels_like(32.22);
        mainDto.setGrnd_level(110);
        mainDto.setTemp_min(25);
        mainDto.setTemp(31);

        apiResponseData = new ApiResponseData();
        apiResponseData.setCod(200);
        apiResponseData.setCity(cityDto);
        apiResponseData.setList(null);
        apiResponseData.setMessage("0");
        apiResponseData.setCnt(40);
    }


    @Test
    void getFiveDaysWeatherDataWithUnit() {
        Mockito.when(weatherApi.getFiveDaysWeatherDataWithUnit(locationID, unit)).thenReturn(apiResponseData);
        assertThat(apiResponseData.getCod()).isEqualTo(200);
    }

    @Test
    void isUnitValid() {
        boolean valid =true;
        when(weatherApi.isUnitValid(unit)).thenReturn(valid);
        assertThat(valid).isTrue();
    }


}