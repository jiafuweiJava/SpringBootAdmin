package com.fwjia.admin.controller.background;

import com.fwjia.admin.controller.BaseController;
import com.fwjia.admin.core.AjaxMessageEntity;
import com.fwjia.admin.core.AjaxMessageResult;
import com.fwjia.admin.core.page.PageResult;
import com.fwjia.admin.entity.User;
import com.fwjia.admin.service.IUserService;
import com.fwjia.admin.service.specification.SimpleSpecificationBuilder;
import com.fwjia.admin.service.specification.SpecificationOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  fwjia
 * @email   jiafuwei_7@163.com
 * @date    2019.1.18
 */
@Controller
@Scope("prototype")
@RequestMapping(value="/user")
public class UserController extends BaseController {


    @Autowired
    private IUserService userService;

    @RequestMapping("/user/list")
    public String console(Model model){
        return "user/user/list";
    }



    @RequestMapping(value = "/query-user-list.json")
    @ResponseBody
    public AjaxMessageEntity<PageResult> queryUserList(int page, int limit) {

        SimpleSpecificationBuilder<User> builder = new SimpleSpecificationBuilder<User>();
        String searchText = request.getParameter("searchText");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("nickName", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<User> pageData = userService.findAll(builder.generateSpecification(), getPageRequest());


        //声明返回的json实体
        AjaxMessageEntity <PageResult>ajaxMessageEntity=new AjaxMessageEntity<>();

        PageResult pageResult = new PageResult();
        pageResult.setCount(pageData.getTotalElements());
        pageResult.setData(pageData.getContent());

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
