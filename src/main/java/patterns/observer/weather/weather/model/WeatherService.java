package patterns.observer.weather.weather.model;

public interface WeatherService {
    void addToWeatherList(Float temperature, Float pressure, Float humidity);
}
