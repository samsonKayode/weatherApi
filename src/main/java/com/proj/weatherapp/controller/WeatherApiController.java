package com.proj.weatherapp.controller;

import com.proj.weatherapp.constants.Units;
import com.proj.weatherapp.exceptions.InvalidUnitException;
import com.proj.weatherapp.models.ApiResponseData;
import com.proj.weatherapp.service.WeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
@RequestMapping("/v1/weather")
public class WeatherApiController {

    @Autowired
    WeatherApiService weatherApiService;

    @GetMapping("/summary")
    public ResponseEntity<ApiResponseData> getFiveDaysWeatherDataWithUnit(@RequestParam (value = "locationID", required = true) int locationID,
                                                           @RequestParam String unit) throws InvalidUnitException {

        ApiResponseData response = weatherApiService.getFiveDaysWeatherDataWithUnit(locationID, unit);

        return ResponseEntity.ok().body(response);
    }
}
