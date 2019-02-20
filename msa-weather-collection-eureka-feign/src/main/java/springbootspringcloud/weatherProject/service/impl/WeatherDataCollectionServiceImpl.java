package springbootspringcloud.weatherProject.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import springbootspringcloud.weatherProject.service.WeatherDataCollectionService;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {
	
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	
	private static final long TIME_OUT = 1800L;// 超时设置为30min
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
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
