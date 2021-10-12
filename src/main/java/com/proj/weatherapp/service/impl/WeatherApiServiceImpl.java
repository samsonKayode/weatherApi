package com.proj.weatherapp.service.impl;

import com.proj.weatherapp.exceptions.InvalidUnitException;
import com.proj.weatherapp.models.ApiResponseData;
import com.proj.weatherapp.api.resources.WeatherApi;
import com.proj.weatherapp.service.WeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "weatherApi")
public class WeatherApiServiceImpl implements WeatherApiService {

    @Autowired
    private WeatherApi weatherApi;

    public WeatherApiServiceImpl(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    @Override
    @Cacheable(key = "{#locationID, #units}")
    public ApiResponseData getFiveDaysWeatherDataWithUnit(int locationID, String units) throws InvalidUnitException {
        return weatherApi.getFiveDaysWeatherDataWithUnit(locationID, units);
    }
}
