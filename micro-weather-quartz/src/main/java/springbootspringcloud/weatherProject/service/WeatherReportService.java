package springbootspringcloud.weatherProject.service;
/**
 * Weather Report Service
 * @author wy
 *
 */

import springbootspringcloud.weatherProject.vo.Weather;

public interface WeatherReportService {
	/**
	 * 根据城市Id查询天气信息
	 * @param cityId
	 * @return
	 */
	Weather getDataByCityId(String cityId);
}
