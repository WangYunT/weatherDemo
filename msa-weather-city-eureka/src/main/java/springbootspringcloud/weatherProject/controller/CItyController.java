package springbootspringcloud.weatherProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootspringcloud.weatherProject.service.CityDataService;
import springbootspringcloud.weatherProject.vo.City;

@RestController
@RequestMapping("/cities")
public class CItyController {
	
	@Autowired
	private CityDataService cityDataService;

	@GetMapping
	public List<City> listCity() throws Exception {
		return cityDataService.listCity();
	}
}
