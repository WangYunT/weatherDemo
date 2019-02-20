package springbootspringcloud.weatherProject.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息的VO类
 * 
 * 从这个接口可以拿到返回模板：
 * 步骤1：拿到所有城市列表信息：http://flash.weather.com.cn/wmaps/xml/china.xml
 * 步骤2：通过城市id获得天气数据，json数据：http://wthrcdn.etouch.cn/weather_mini?citykey=101010100
 * 		 或者通过城市名字获得天气数据，json数据：http://wthrcdn.etouch.cn/weather_mini?city=北京
 *
 */
public class Weather implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String city;
	private String ganmao;
	private String wendu;
	
	private Yesterday yesterday;
	private List<Forecast>  forecast;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getGanmao() {
		return ganmao;
	}
	public void setGanmao(String ganmao) {
		this.ganmao = ganmao;
	}
	public String getWendu() {
		return wendu;
	}
	public void setWendu(String wendu) {
		this.wendu = wendu;
	}
	public Yesterday getYesterday() {
		return yesterday;
	}
	public void setYesterday(Yesterday yesterday) {
		this.yesterday = yesterday;
	}
	public List<Forecast> getForecast() {
		return forecast;
	}
	public void setForecast(List<Forecast> forecast) {
		this.forecast = forecast;
	}
	

}
