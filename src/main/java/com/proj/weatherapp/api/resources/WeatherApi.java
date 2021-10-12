package com.proj.weatherapp.api.resources;

import com.proj.weatherapp.constants.Units;
import com.proj.weatherapp.exceptions.InvalidUnitException;
import com.proj.weatherapp.exceptions.LimitExceededException;
import com.proj.weatherapp.models.ApiResponseData;
import org.springframework.stereotype.Component;

@Component
public interface WeatherApi {

    public ApiResponseData getFiveDaysWeatherDataWithUnit(int locationID, String units);

    public boolean isUnitValid(String unit);
}
