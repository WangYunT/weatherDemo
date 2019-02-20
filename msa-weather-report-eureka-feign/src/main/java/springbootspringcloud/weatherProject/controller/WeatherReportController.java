package springbootspringcloud.weatherProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import springbootspringcloud.weatherProject.service.CityClient;
import springbootspringcloud.weatherProject.service.WeatherReportService;
import springbootspringcloud.weatherProject.vo.City;

@RestController
@RequestMapping("/report")
public class WeatherReportController {

	@Autowired
	private WeatherReportService weatherReportService;

	@Autowired
	private CityClient cityClient;

	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {

		List<City> cityList = new ArrayList<>();

		try {
			cityList = cityClient.listCity();
		} catch (Exception e) {

		}
		model.addAttribute("title", "天气预报展示");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));

		return new ModelAndView("weather/report", "reportModel", model);
	}
}
