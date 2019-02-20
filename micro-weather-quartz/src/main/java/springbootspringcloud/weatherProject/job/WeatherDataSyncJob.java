package springbootspringcloud.weatherProject.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import springbootspringcloud.weatherProject.service.CityDataService;
import springbootspringcloud.weatherProject.service.WeatherDataService;
import springbootspringcloud.weatherProject.vo.City;

public class WeatherDataSyncJob extends QuartzJobBean {
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

	@Autowired
	private CityDataService cityDataService;

	@Autowired
	private WeatherDataService weatherDataService;

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Weather data sync job. start");
		// 获取城市列表
		List<City> cityList = null;

		try {
			cityList = cityDataService.listCity();
		} catch (Exception e) {

			logger.info("WeatherDataSyncJob.Java  error ", e);
		}

		// 遍历城市ID获取天气
		for (City city : cityList) {
			String cityId = city.getCityId();
			logger.info("weather city id is :" + cityId);
			weatherDataService.syncDateByCityId(cityId);
		}
		logger.info("Weather data sync job. End");
	}

}
