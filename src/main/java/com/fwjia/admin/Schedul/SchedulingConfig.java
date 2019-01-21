package com.fwjia.admin.Schedul;

import javax.annotation.Resource;

import com.fwjia.admin.entity.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务
 * @author  fwjia
 * @email   jiafuwei_7@163.com
 * @date    2019.1.18
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(SchedulingConfig.class);



	
	@Scheduled(cron = "0/59 * * * * ?") // 每59秒执行一次
    public void scheduler() {
        LOGGER.debug("scheduler  go go  go");
    }
}
