package com.example.Schedul;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.po.Demo;
import com.example.service.DemoService;

/**
 * 定时任务
 * @author jiafuwei
 *
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {
	@Resource
    private DemoService demoService;
	
	@Scheduled(cron = "0/59 * * * * ?") // 每59秒执行一次
    public void scheduler() {
		Demo demo = demoService.getById(1);
        System.out.println(">>>>>>>>> SchedulingConfig.scheduler()"+demo.getEmail());
    }
}
