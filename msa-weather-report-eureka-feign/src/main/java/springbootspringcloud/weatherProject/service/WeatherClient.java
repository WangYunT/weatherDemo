package springbootspringcloud.weatherProject.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import springbootspringcloud.weatherProject.vo.WeatherResponse;

/**
 * 
 * @author wy
 *
 */
@FeignClient("MSA-WEATHER-DATA-EUREKA")
public interface WeatherClient {

	@GetMapping("/weather/cityId/{cityId}")
	WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
