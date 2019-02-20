package springbootspringcloud.weatherProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootspringcloud.weatherProject.service.WeatherDataService;
import springbootspringcloud.weatherProject.service.WeatherReportService;
import springbootspringcloud.weatherProject.vo.Weather;
import springbootspringcloud.weatherProject.vo.WeatherResponse;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	
	@Autowired
	private WeatherDataService weatherDataService;
	
	@Override
	public Weather getDataByCityId(String cityId) {
		WeatherResponse resp = weatherDataService.getDataByCityId(cityId);
		return resp.getData();
	}

}
