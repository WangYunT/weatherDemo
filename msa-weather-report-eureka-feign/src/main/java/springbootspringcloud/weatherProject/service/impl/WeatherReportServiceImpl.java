package springbootspringcloud.weatherProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootspringcloud.weatherProject.service.WeatherClient;
import springbootspringcloud.weatherProject.service.WeatherReportService;
import springbootspringcloud.weatherProject.vo.Weather;
import springbootspringcloud.weatherProject.vo.WeatherResponse;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	
	@Autowired
	private WeatherClient weatherClient;
	
	@Override
	public Weather getDataByCityId(String cityId) {
		//由天气数据API微服务来提供数据
		WeatherResponse resp = weatherClient.getDataByCityId(cityId);
		Weather data = resp.getData();
		return data;
	}

}
