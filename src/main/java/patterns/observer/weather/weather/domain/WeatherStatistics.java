package patterns.observer.weather.weather.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import patterns.observer.weather.weather.observer.Observer;

@Component
public class WeatherStatistics implements Observer, DisplayElements {

    private WeatherData weatherData;

    @Autowired
    public WeatherStatistics(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(WeatherData weatherData) {
        display();
    }

    @Override
    public void display() {
        maxTemp();
        minTemp();
        avgTemp();
    }

    private void maxTemp() {
        if (WeatherData.getWeatherList().size() >= 2) {
            System.out.println("Max temperature: " + WeatherData.getWeatherList().entrySet().stream().max((t1, t2) -> Float.compare(t1.getValue().getTemperature(), t2.getValue().getTemperature())).get().getValue());
        }
    }

    private void minTemp() {
        if (WeatherData.getWeatherList().size() >= 2) {
            System.out.println("Min temperature: " + WeatherData.getWeatherList().entrySet().stream().min((t1, t2) -> Float.compare(t1.getValue().getTemperature(), t2.getValue().getTemperature())).get().getValue());
        }
    }

    private void avgTemp() {
        if (WeatherData.getWeatherList().size() >= 2) {
            System.out.println("Average temperature: " + WeatherData.getWeatherList().values().stream().mapToDouble(WeatherData::getTemperature).average().getAsDouble());
        }
    }
}
