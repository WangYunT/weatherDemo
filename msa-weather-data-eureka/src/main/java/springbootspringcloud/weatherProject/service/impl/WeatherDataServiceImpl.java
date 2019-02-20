package springbootspringcloud.weatherProject.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

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
			// 2.缓存中没有的，抛出异常
			throw new RuntimeException("Don't has daya !");
		}

		try {
			weather = mapper.readValue(strBody, WeatherResponse.class);// json 反序列化获得数据
		} catch (IOException e) {
			logger.info("Error!", e);
		}
		return weather;
	}

}
