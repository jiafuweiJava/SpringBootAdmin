package com.fwjia.admin.Schedul;

import javax.annotation.Resource;

import com.fwjia.admin.po.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.fwjia.admin.service.DemoService;

/**
 * 定时任务
 * @author jiafuwei
 *
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(SchedulingConfig.class);


    @Resource
    private DemoService demoService;
	
	@Scheduled(cron = "0/59 * * * * ?") // 每59秒执行一次
    public void scheduler() {
		Demo demo = demoService.getById(1);
		if(demo!=null){
            LOGGER.debug(">>>>>>>>> SchedulingConfig.scheduler()"+demo.getEmail());
        }else{
            LOGGER.error("demo is null");
        }
    }
}
