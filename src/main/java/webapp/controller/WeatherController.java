package webapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import webapp.moedel.weather.Weather;
import webapp.service.WeatherService;


@Controller
@RequestMapping("/weather")
public class WeatherController {
	static Log log = LogFactory.getLog(WeatherController.class);
	@Autowired
	WeatherService service;
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String showFrom(Model model){
		log.info("showForm");
		return "weather/form";
	}
	
	@RequestMapping(value="/show",method=RequestMethod.POST)
	public String showWeather(Model model , String city){
		log.info("Show weather");
		log.info("city : " + city);
		Weather weather = service.getweather(city);
		model.addAttribute("weather", weather);
		return "weather/weather";
	}
}
