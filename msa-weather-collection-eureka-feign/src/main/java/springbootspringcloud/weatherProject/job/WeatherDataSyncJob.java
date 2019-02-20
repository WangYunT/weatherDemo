package springbootspringcloud.weatherProject.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import springbootspringcloud.weatherProject.service.CityClient;
import springbootspringcloud.weatherProject.service.WeatherDataCollectionService;
import springbootspringcloud.weatherProject.vo.City;

public class WeatherDataSyncJob extends QuartzJobBean {
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

	@Autowired
	private WeatherDataCollectionService weatherDataCollectionService;
	
	@Autowired
	private CityClient cityClient;

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Weather data sync job. start");
		// 获取城市列表
		List<City> cityList = null;

		try {
			cityList = cityClient.listCity();
 		} catch (Exception e) {
			logger.info("WeatherDataSyncJob.Java  error ", e);
		}

		// 遍历城市ID获取天气
		for (City city : cityList) {
			String cityId = city.getCityId();
			logger.info("weather city id is :" + cityId);
			weatherDataCollectionService.syncDateByCityId(cityId);
		}
		logger.info("Weather data sync job. End");
	}

}
