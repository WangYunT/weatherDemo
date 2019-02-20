package springbootspringcloud.weatherProject.service;

/**
 * Weather Data Collection Service
 * @author wy
 *
 */
public interface WeatherDataCollectionService {
	/**
	 * 根据城市id 同步天气信息
	 * @param cityId
	 */
	void syncDateByCityId(String cityId);
}
