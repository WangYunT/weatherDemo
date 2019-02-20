package springbootspringcloud.weatherProject.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import springbootspringcloud.weatherProject.vo.City;
/**
 * 
 * @author wy
 *
 */
@FeignClient("MSA-WEATHER-CITY-EUREKA")
public interface CityClient {
	
	@GetMapping("/cities")
	List<City> listCity() throws Exception;
}
