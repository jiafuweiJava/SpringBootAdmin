package com.fwjia.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {
    @RequestMapping("/page")
    public String page3(Model model){
        model.addAttribute("userName","张三");
        return "hello";
    }

    /**
     * 跳转首页
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
        return "index";
    }

    /**
     * 跳转到404页面
     * @param model
     * @return
     */
    @RequestMapping("/404")
    public String to404(Model model){
        return "template/tips/404";
    }

    /**
     * 跳转到500页面
     * @param model
     * @return
     */
    @RequestMapping("/500")
    public String to500(Model model){
        return "template/tips/500";
    }
    
}
