package patterns.observer.weather.weather.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import patterns.observer.weather.weather.observer.Observer;

@Component
public class CurrentWeather implements Observer, DisplayElements {

    private WeatherData weatherData;

    @Autowired
    public CurrentWeather(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(WeatherData weatherData) {
        display();
    }

    @Override
    public void display() {
        System.out.println("Current weather: \n" + weatherData);
    }
}
