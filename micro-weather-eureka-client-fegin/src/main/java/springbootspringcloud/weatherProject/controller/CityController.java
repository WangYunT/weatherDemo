package springbootspringcloud.weatherProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootspringcloud.weatherProject.service.CityClient;

@RestController
public class CityController {
	
	@Autowired
	private CityClient cityClient;
	
	@GetMapping("/cities")
	public String listCity() {
		//通过feign客户端来查找
		String body = cityClient.listCity();
		return body;
	}
}
