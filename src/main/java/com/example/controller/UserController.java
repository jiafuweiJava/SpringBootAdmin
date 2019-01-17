package com.example.controller;

import com.example.core.AjaxMessageEntity;
import com.example.core.AjaxMessageResult;
import com.example.core.page.PageResult;
import com.example.po.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
@RequestMapping(value="/user")
public class UserController {

    @RequestMapping("/user/list")
    public String console(Model model){
        return "user/user/list";
    }



    @RequestMapping(value = "/query-user-list.json")
    @ResponseBody
    public AjaxMessageEntity<PageResult> queryUserList(int page, int limit) {
        //声明返回的json实体
        AjaxMessageEntity <PageResult>ajaxMessageEntity=new AjaxMessageEntity<>();
        // 查询
        List<User> list = new ArrayList<>();

        for (int i = 1; i <30 ; i++) {
            User user = new User();
            user.setEmail("aaaa@qq.com");
            user.setId(i);
            user.setAvatar("https://wx4.sinaimg.cn/mw1024/5db11ff4gy1fmx4keaw9pj20dw08caa4.jpg");
            user.setIp("127.0.0.1");
            user.setJoinTime("20181010");
            user.setPhone("13366666666");
            user.setSex("男");
            user.setUserName("展示");
            list.add(user);
        }

        PageResult pageResult = new PageResult();
        pageResult.setCount(100L);
        pageResult.setData(list);

        ajaxMessageEntity.setData(pageResult);
        ajaxMessageEntity.setMessager(AjaxMessageResult.SUCCESS, "ok");
        return ajaxMessageEntity;
    }


    @RequestMapping("/administrators")
    public String homepage1(Model model){
        return "user/administrators/list";
    }

    @RequestMapping("/administrators/role")
    public String index(Model model){
        return "user/administrators/role";
    }

}
