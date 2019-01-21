package com.fwjia.admin.controller.background;

import com.fwjia.admin.controller.BaseController;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author  fwjia
 * @email   jiafuwei_7@163.com
 * @date    2019.1.18
 */
@Controller
@Scope("prototype")
@RequestMapping(value="/home")
public class HomeController extends BaseController {

    @RequestMapping("/console")
    public String console(Model model){
        return "home/console";
    }


    @RequestMapping("/homepage1")
    public String homepage1(Model model){
        return "home/homepage1";
    }

    @RequestMapping("/homepage2")
    public String index(Model model){
        return "home/homepage2";
    }

}
