package springbootspringcloud.weatherProject.service.impl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import springbootspringcloud.weatherProject.service.WeatherDataService;
import springbootspringcloud.weatherProject.vo.WeatherResponse;

/**
 * WeatherDataService 实现
 * 
 * @author wy
 *
 */

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

	private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

	private static final long TIME_OUT = 1800L;// 超时设置为30min

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

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
	 * 
	 * @param uri
	 * @return
	 */
	private WeatherResponse doGetWeather(String uri) {

		String key = uri;
		String strBody = null;
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse weather = null;
		// 1.先查缓存，缓存的取缓存中的数据
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		if (stringRedisTemplate.hasKey(key)) {
			logger.info("Redis has data");
			strBody = ops.get(key);
		} else {
			logger.info("Redis don't data");
			// 2.缓存中没有的，我们再去第三方服务请求数据
			ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

			if (response.getStatusCodeValue() == 200) {
				strBody = response.getBody();
			}
			// 3.数据写入缓存
			ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
		}

		try {
			weather = mapper.readValue(strBody, WeatherResponse.class);// json 反序列化获得数据
		} catch (IOException e) {
			logger.info("Error!", e);
		}
		return weather;
	}

	@Override
	public void syncDateByCityId(String cityId) {
		String uri = WEATHER_URI + "citykey=" + cityId;
		this.saveWeatherData(uri);
	}
	
	/**
	 * 把天气数据放入缓存中
	 * @param uri
	 */
	private void saveWeatherData(String uri) {
		String key = uri;
		String strBody = null;
		
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

		// 调用服务接口来获取
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

		if (response.getStatusCodeValue() == 200) {
			strBody = response.getBody();
		}
		// 3.数据写入缓存
		ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);

	}
}
