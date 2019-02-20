package springbootspringcloud.weatherProject.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import springbootspringcloud.weatherProject.service.CityDataService;
import springbootspringcloud.weatherProject.util.XmlBuilder;
import springbootspringcloud.weatherProject.vo.City;
import springbootspringcloud.weatherProject.vo.CityList;

@Service
public class CityDataServiceImpl implements CityDataService {

	@Override
	public List<City> listCity() throws Exception {
		// 读取xml文件
		Resource resource = new ClassPathResource("cityList.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = br.readLine()) != null) {
			buffer.append(line);
		}

		br.close(); // 关流
		// xml文件转为java对象
		CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());

		return cityList.getCityList();
	}

}
