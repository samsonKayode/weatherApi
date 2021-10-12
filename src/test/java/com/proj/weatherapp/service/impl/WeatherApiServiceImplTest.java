package com.proj.weatherapp.service.impl;

import com.proj.weatherapp.models.ApiResponseData;
import com.proj.weatherapp.models.CityDto;
import com.proj.weatherapp.api.resources.WeatherApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WeatherApiServiceImplTest {

    @Mock
    WeatherApi weatherApi;

    private int locationID=2332453;
    private String unit="METRIC";

    private WeatherApiServiceImpl weatherApiService;

    private ApiResponseData apiResponseData;
    private CityDto cityDto;

    @BeforeEach
    void setUp(){
        weatherApiService = new WeatherApiServiceImpl(weatherApi);

        cityDto = new CityDto();
        cityDto.setId(2332453);
        cityDto.setName("Lagos State");
        cityDto.setCountry("NG");

        apiResponseData = new ApiResponseData();
        apiResponseData.setCod(200);
        apiResponseData.setCity(cityDto);
        apiResponseData.setList(null);
        apiResponseData.setMessage("0");
        apiResponseData.setCnt(40);
    }

    @Test
    void getFiveDaysWeatherDataWithUnit() {

        //when
        weatherApi.getFiveDaysWeatherDataWithUnit(locationID, unit);
        //then
        verify(weatherApi, times(1)).getFiveDaysWeatherDataWithUnit(locationID, unit);

    }
}