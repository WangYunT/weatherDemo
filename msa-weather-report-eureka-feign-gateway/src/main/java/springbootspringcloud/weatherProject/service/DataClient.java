package springbootspringcloud.weatherProject.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import springbootspringcloud.weatherProject.vo.City;
import springbootspringcloud.weatherProject.vo.WeatherResponse;
/**
 * 
 * @author wy
 *
 */
@FeignClient("msa-weather-city-eureka")
public interface DataClient {
	
	/**
	 * 获取城市列表
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/city/cities")
	List<City> listCity() throws Exception;
	
	/**
	 * 根据城市ID查询天气数据
	 */
	@GetMapping("/data/weather/cityId/{cityId}")
	WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
