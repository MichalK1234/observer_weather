package patterns.observer.weather.weather.domain;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import org.springframework.stereotype.Component;
import patterns.observer.weather.weather.observer.Observer;
import patterns.observer.weather.weather.observer.Subject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@Component
public class WeatherData implements Subject {

    private static Map<LocalDateTime, WeatherData> weatherList = Maps.newLinkedHashMap();
    private List<Observer> observers;
    private Float temperature;
    private Float humidity;
    private Float pressure;

    public WeatherData() {
        observers = Lists.newArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (o != null) {
            observers.remove(o);
        }
    }

    public WeatherData(Float temperature, Float humidity, Float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    @Override
    public void notifyObservers() {
        if (observers != null) {
            observers.forEach(o -> o.update(new WeatherData(temperature, humidity, pressure)));
        }
    }

    @Override
    public String toString() {
        return "temperature: " + temperature +
                " humidity: " + humidity +
                " pressure: " + pressure;
    }

    public static Map<LocalDateTime, WeatherData> getWeatherList() {
        return weatherList;
    }

    public void addWeather(Float temperature, Float pressure, Float humidity) {
        setTemperature(temperature);
        setHumidity(humidity);
        setPressure(pressure);
        weatherList.put(LocalDateTime.now(), new WeatherData(temperature, pressure, humidity));
        notifyObservers();
    }
}
