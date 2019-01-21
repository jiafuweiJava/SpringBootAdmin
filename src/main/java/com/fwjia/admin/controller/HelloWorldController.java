package com.fwjia.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.fwjia.admin.config.SystemProperties;
import com.fwjia.admin.entity.Demo;
import com.fwjia.admin.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * Spring Boot 测试
 * @author jiafuwei
 *
 */
/*@RestController的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了*/
/*Spring Boot默认是扫描@SpringBootApplication注解的类的同包以及子包下的类*/
@RestController
public class HelloWorldController {
	

    @RequestMapping("/hello")
    public String index(HttpServletRequest request) {
    	ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
    	//获取上下文
    	//ApplicationContext sac = RequestContextUtils.getWebApplicationContext(request);
    	SystemProperties neoProperties = ac.getBean(SystemProperties.class);
    	System.out.println(neoProperties.getDescription());
    	

        return "Hello World";
    }
    
    @RequestMapping("/getUser")
    public User getUser() {
        User user=new User();
        return user;
    }
    

    
   
}
