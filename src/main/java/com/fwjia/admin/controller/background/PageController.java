package com.fwjia.admin.controller.background;

import com.fwjia.admin.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author  fwjia
 * @email   jiafuwei_7@163.com
 * @date    2019.1.18
 */
@Controller
public class PageController extends BaseController {
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
