package patterns.observer.weather.weather.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patterns.observer.weather.weather.domain.WeatherData;

@Service
public class WeatherServiceImpl implements WeatherService {

    private WeatherData weatherData;

    @Autowired
    public WeatherServiceImpl(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void addToWeatherList(Float temperature, Float pressure, Float humidity) {
        weatherData.addWeather(temperature, pressure, humidity);
    }
}
