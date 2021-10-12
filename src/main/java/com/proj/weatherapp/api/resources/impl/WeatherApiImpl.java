package com.proj.weatherapp.api.resources.impl;

import com.proj.weatherapp.api.resources.WeatherApi;
import com.proj.weatherapp.constants.Units;
import com.proj.weatherapp.exceptions.ConnectionError;
import com.proj.weatherapp.exceptions.InternalError;
import com.proj.weatherapp.exceptions.InvalidUnitException;
import com.proj.weatherapp.exceptions.LimitExceededException;
import com.proj.weatherapp.models.ApiResponseData;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class WeatherApiImpl implements WeatherApi {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weatherApi.api.id}")
    String apiID;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ApiResponseData getFiveDaysWeatherDataWithUnit(int locationID, String units) {

        boolean valid = isUnitValid(units);
        if(valid==false){
            log.error("The unit: {}, provided is not supported ", units);
            throw new InvalidUnitException("The unit: "+units+" provided is not supported ", HttpStatus.NOT_ACCEPTABLE);
        }else {

            String URL = "http://api.openweathermap.org/data/2.5/forecast?id=" + locationID + "&mode=json&appid=" + apiID + "&units=" + units;
            try {
                log.info("calling openWeather api with URL: {}", URL);
                ResponseEntity<ApiResponseData> response = restTemplate.getForEntity(URL, ApiResponseData.class);

                ApiResponseData apiResponseData = response.getBody();
                //Check if api call limit has been reached.. Based on the api doc, the cod parameter returns 429
                if (apiResponseData.getCod() == 429) {
                    log.error("Api limit has been exceeded");
                    throw new LimitExceededException("Our service is currently being restarted, please try again in few minutes", response.getStatusCode());
                }

                //check if the status is 200..
                else if (response.getStatusCode() == HttpStatus.OK) {

                    return response.getBody();
                } else {
                    log.error("Could not retrieve response: {}", response.getStatusCode());
                    throw new ConnectionError("", response.getStatusCode());
                }
            } catch (Exception e) {
                log.error("error occurred. Error message: {}", e);
                throw new InternalError("Error connecting to weatherAPI server", HttpStatus.BAD_GATEWAY);
            }
        }
    }

    //check if the unit provided is valid
    @Override
    public boolean isUnitValid(String unit) {

        boolean valid=true;
        for (Units u : Units.values()) {
            if(u.name().equalsIgnoreCase(unit)){
                valid = true;
            }else{
                valid=false;
            }
        }
        return valid;
    }
}
