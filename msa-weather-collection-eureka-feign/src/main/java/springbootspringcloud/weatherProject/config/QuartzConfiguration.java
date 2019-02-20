package springbootspringcloud.weatherProject.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springbootspringcloud.weatherProject.job.WeatherDataSyncJob;

/**
 * 自动同步第三方数据信息到缓存中
 * 此处需要注意添加注释。bean的注入
 * @author wy
 *
 */

@Configuration
public class QuartzConfiguration {
	
	private static final int TIME = 1800;//半小时更新

	// JobDetail
	@Bean
	public JobDetail weatherDataSyncJobDetail() {
		return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJobDetail").storeDurably().build();
	}
	// Trigger
	@Bean
	public Trigger weatherDataSyncTrigger() {
		
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(TIME).repeatForever();
		
		return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
	}
}
