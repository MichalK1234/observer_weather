package patterns.observer.weather.weather.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import patterns.observer.weather.weather.observer.Observer;

@Component
public class WeatherForecast implements Observer, DisplayElements {

    private WeatherData weatherData;

    @Autowired
    public WeatherForecast(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        if (WeatherData.getWeatherList().size() >= 2) {
            Float prevTemp = WeatherData.getWeatherList().values().stream().limit(2).findFirst().get().getTemperature();
            System.out.println("Previous temperture: " + prevTemp);
            if (prevTemp > weatherData.getTemperature()) {
                System.out.println("Tomorrow will be colder than today.");
            } else if (prevTemp < weatherData.getTemperature()) {
                System.out.println("Tomorrow will be hotter than today.");
            } else {
                System.out.println("Tomorrow will be the same temperature as today");
            }
        }
    }

    @Override
    public void update(WeatherData weatherData) {
        display();
    }
}
