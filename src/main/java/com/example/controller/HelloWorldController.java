package com.example.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.po.Demo;
import com.example.config.NeoProperties;
import com.example.po.User;
import com.example.service.DemoService;

/**
 * Spring Boot 测试
 * @author jiafuwei
 *
 */
/*@RestController的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了*/
/*Spring Boot默认是扫描@SpringBootApplication注解的类的同包以及子包下的类*/
@RestController
public class HelloWorldController {
	
	@Resource
    private DemoService demoService;
	
    @RequestMapping("/hello")
    public String index(HttpServletRequest request) {
    	ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
    	//获取上下文
    	//ApplicationContext sac = RequestContextUtils.getWebApplicationContext(request);
    	NeoProperties neoProperties = ac.getBean(NeoProperties.class);
    	System.out.println(neoProperties.getDescription());
    	
    	//demoService.save(new Demo("abc", "abc@qq.com"));
    	
        return "Hello World";
    }
    
    @RequestMapping("/getUser")
    public User getUser() {
        User user=new User();
        /*user.setName("小明");
        user.setPassword("123456");*/
        return user;
    }
    
    @RequestMapping("/getById")
    public Demo getById(long id){
       return demoService.getById(id);
    }
    
   
}
