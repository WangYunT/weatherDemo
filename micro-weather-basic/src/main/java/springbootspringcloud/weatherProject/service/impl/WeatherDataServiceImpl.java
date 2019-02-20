package springbootspringcloud.weatherProject.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import springbootspringcloud.weatherProject.service.WeatherDataService;
import springbootspringcloud.weatherProject.vo.WeatherResponse;

/**
 * WeatherDataService 实现
 * @author wy
 *
 */

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		
		String uri = WEATHER_URI + "citykey=" + cityId;
		return this.doGetWeather(uri);
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {

		String uri = WEATHER_URI + "city=" + cityName;
		
		return this.doGetWeather(uri);
	}
	
	/**
	 * 请求天气数据的公共方法
	 * @param uri
	 * @return
	 */
	private WeatherResponse doGetWeather(String uri) {
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		String strBody = null;
		if (response.getStatusCodeValue() == 200) {
			strBody = response.getBody();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse weather = null;

		try {
			weather = mapper.readValue(strBody, WeatherResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return weather;
	}
	
}
