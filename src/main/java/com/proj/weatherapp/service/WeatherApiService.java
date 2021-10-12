package com.proj.weatherapp.service;

import com.proj.weatherapp.constants.Units;
import com.proj.weatherapp.models.ApiResponseData;

public interface WeatherApiService {

    public ApiResponseData getFiveDaysWeatherDataWithUnit(int locationID, String units);
}
