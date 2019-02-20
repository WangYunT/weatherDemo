package springbootspringcloud.weatherProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import springbootspringcloud.weatherProject.service.CityClient;

@RestController
public class CityController {
	
	@Autowired
	private CityClient cityClient;
	
	@GetMapping("/cities")
	@HystrixCommand(fallbackMethod="defaultCities")
	public String listCity() {
		//通过feign客户端来查找
		String body = cityClient.listCity();
		return body;
	}
	
	public String defaultCities() {
		return "listCity is down~";
	}
}
