package patterns.observer.weather.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import patterns.observer.weather.weather.model.WeatherServiceImpl;

@Controller
@RequestMapping("/")
public class WeatherController {

    private WeatherServiceImpl service;

    @Autowired
    public WeatherController(WeatherServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public String getWeather() {
        return "weather";
    }

    @PostMapping
    public String postNewWeather(@RequestParam("temperature") Float temperature, @RequestParam("humidity") Float humidity, @RequestParam("pressure") Float pressure) {
        if (temperature != null || humidity != null || pressure != null) {
            service.addToWeatherList(temperature, pressure, humidity);
        }
        return "redirect:/";
    }
}
