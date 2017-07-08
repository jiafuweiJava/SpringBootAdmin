package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
/**
 * 加上 @ServletComponentScan是的spring能够扫描到我们自己编写的servlet和filter。
 * 监控查看地址 ：http://localhost:8080/druid/index.html
 * @author jifuwei
 *
 */
@SpringBootApplication
@ServletComponentScan
public class DemoApplication {
	/**
	 * Spring Boot默认是扫描@SpringBootApplication注解的类的同包以及子包下的类
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
