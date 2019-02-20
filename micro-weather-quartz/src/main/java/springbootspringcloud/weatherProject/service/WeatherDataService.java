package springbootspringcloud.weatherProject.service;

import springbootspringcloud.weatherProject.vo.WeatherResponse;

public interface WeatherDataService {
	
	/**
	 * 根据城市ID查询天气数据
	 * @param cityId
	 * @return
	 */
	WeatherResponse getDataByCityId(String cityId);
	
	/**
	 * 根据城市名称查询天气数据
	 * 
	 * @param cityId
	 * @return
	 */
	WeatherResponse getDataByCityName(String cityName);
	
	/**
	 * 根据城市id来同步天气
	 * @param cityId
	 */
	void syncDateByCityId(String cityId);
}
