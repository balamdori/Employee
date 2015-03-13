package webapp.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.stereotype.Service;

import webapp.exception.URLRuntimeException;
import webapp.moedel.weather.Current;
import webapp.moedel.weather.Forecast;
import webapp.moedel.weather.Weather;

@Service
public class WeatherService {
	static Log log = LogFactory.getLog(WeatherService.class);
	SAXBuilder jdom = new SAXBuilder();;
	String url = "http://weather.service.msn.com/data.aspx?culture=ko-KR&weasearchstr=";

	Current getCurrent(Element current) {
		Current c = new Current();
		c.setTemperature(current.getAttributeValue("temperature"));
		c.setSkycode(current.getAttributeValue("skycode"));
		c.setSkytext(current.getAttributeValue("skytext"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			c.setDate(df.parse(current.getAttributeValue("date")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.setObservationtime(current.getAttributeValue("observationtime"));
		c.setObservationpoint(current.getAttributeValue("observationpoint"));
		c.setFeelslike(current.getAttributeValue("feelslike"));
		c.setHumidity(current.getAttributeValue("humidity"));
		c.setWinddisplay(current.getAttributeValue("winddisplay"));
		c.setDay(current.getAttributeValue("day"));
		c.setShortday(current.getAttributeValue("shortday"));
		c.setWindspeed(current.getAttributeValue("windspeed"));

		return c;
	}

	List<Forecast> getForecast(Element weather) {
		List<Forecast> forecasts = new ArrayList<Forecast>();
		List<Element> ws = weather.getChildren();
		for (Element e : ws) {
//			log.info("low = " + e.getAttributeValue("low"));
//			log.info("e.getchild : " + e.getName());
			if (e.getName().equals("forecast")) {
				Forecast f = new Forecast();
				f.setLow(Integer.parseInt(e.getAttributeValue("low")));
				f.setHigh(Integer.parseInt(e.getAttributeValue("high")));
				f.setSkycodeday(e.getAttributeValue("skycodeday"));
				f.setSkytextday(e.getAttributeValue("skytextday"));
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					f.setDate(df.parse(e.getAttributeValue("date")));
				} catch (ParseException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				f.setDay(e.getAttributeValue("day"));
				f.setShortday(e.getAttributeValue("shortday"));
				f.setPrecip(Integer.parseInt(e.getAttributeValue("precip")));

				forecasts.add(f);
			}
		}
		return forecasts;
	}

	public Weather getweather(String city) {
		// log.info("=======================");
		// log.info("getweather : "+city);
		// log.info("=======================");

		String urlcity = url + city;
		Weather w = null;
		try {
			URL u = new URL(urlcity);
			InputStream in = u.openStream();
			Document doc = jdom.build(in);
			Element weatherdata = doc.getRootElement();
			Element weather = weatherdata.getChild("weather");
			Element current = weather.getChild("current");

			w = new Weather();
			Current c = getCurrent(current);
			List<Forecast> forecast = getForecast(weather);
			w.setCurrent(c);
			w.setForecasts(forecast);
//			log.info("skytext : " + current.getAttributeValue("skytext"));
//			log.info("date : " + c.getDate());

			XMLOutputter out = new XMLOutputter();
			out.setFormat(Format.getPrettyFormat());
			out.output(doc, System.out);
		} catch (IOException e) {
			throw new URLRuntimeException(urlcity, e);
		} catch (JDOMException e) {
			// throw new JDOMException("Build Error", e);
		}
		return w;
	}

}
