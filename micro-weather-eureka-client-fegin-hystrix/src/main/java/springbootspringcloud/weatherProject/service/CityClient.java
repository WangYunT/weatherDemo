package springbootspringcloud.weatherProject.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("msa-weather-city-eureka")//括号中要指明服务的地址
public interface CityClient {
	
	@GetMapping("/cities")
	String listCity();
}
