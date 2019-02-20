package springbootspringcloud.weatherProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import springbootspringcloud.weatherProject.service.CityDataService;
import springbootspringcloud.weatherProject.service.WeatherReportService;

@RestController
@RequestMapping("/report")
public class WeatherReportController {

	@Autowired
	private WeatherReportService weatherReportService;
	
	@Autowired
	private CityDataService cityDataService;
	
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId,Model model) throws Exception {
		model.addAttribute("title","天气预报 哈");
		model.addAttribute("cityId",cityId);
		model.addAttribute("cityList",cityDataService.listCity());
		model.addAttribute("report",weatherReportService.getDataByCityId(cityId));
		
		return new ModelAndView("weather/report","reportModel",model);
	}
}
