package patterns.observer.weather.weather.observer;

import patterns.observer.weather.weather.domain.WeatherData;

public interface Observer {
    public void update(WeatherData weatherData);
}
