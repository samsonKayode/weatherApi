package com.proj.weatherapp.controller;

import com.proj.weatherapp.models.ApiResponseData;
import com.proj.weatherapp.models.CityDto;
import com.proj.weatherapp.models.MainDto;
import com.proj.weatherapp.service.WeatherApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@WebMvcTest(WeatherApiController.class)
class WeatherApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherApiService weatherApiService;

    private int locationID=2332453;
    private String unit="METRIC";

    private CityDto cityDto;
    private MainDto mainDto;
    private ApiResponseData apiResponseData;

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
    void getFiveDaysWeatherDataWithUnit() throws Exception {
        when(weatherApiService.getFiveDaysWeatherDataWithUnit(locationID, unit)).thenReturn(apiResponseData);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/weather/summary?locationID=" + locationID+"&unit="+unit))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.cod").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cnt").value(40));
    }

}