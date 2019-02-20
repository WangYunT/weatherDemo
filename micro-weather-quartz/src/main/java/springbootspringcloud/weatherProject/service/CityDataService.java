package springbootspringcloud.weatherProject.service;

import java.util.List;

import springbootspringcloud.weatherProject.vo.City;

/**
 * 城市数据服务接口
 * @author wy
 *
 */
public interface CityDataService {
	
	/**
	 * 获取 city 列表
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;

}
