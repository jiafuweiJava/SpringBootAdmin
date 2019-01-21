package com.fwjia.admin.core.exception;

import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.fwjia.admin.core.AjaxMessageEntity;
import com.fwjia.admin.core.AjaxMessageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;


/**
 * 全局异常处理类
 * @author  fwjia
 * @email   jiafuwei_7@163.com
 * @date    2019.1.18
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private final static BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

    private final static TemplateHashModel staticModels = wrapper.getStaticModels();

    /**
     * 处理所有的异常
     * @param request  HttpServletRequest
     * @param response  HttpServletResponse
     * @param  ex   Exception
     * @return  ModelAndView
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request,HttpServletResponse response, Exception ex){
        LOGGER.error("---------------------------全局异常处理---------------"+ex.getMessage(), ex);
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer=null;
        //如果是页面请求
        if (!(request.getHeader("accept").contains("application/json")||(request.getHeader("X-Requested-With")!= null && request
                .getHeader("X-Requested-With").contains("XMLHttpRequest") ))) {
            // 如果不是异步请求
            LOGGER.error("请求页面出现异常,跳转到错误页面",ex);
            ModelAndView modelAndView=new ModelAndView("error");
            return modelAndView;
        }else {
            //如果是json请求
            // 初始化返回值对象
            AjaxMessageEntity<Map> ajaxMessageEntity = new AjaxMessageEntity<Map>();
            response.setContentType("application/json;charset=UTF-8");
            try {
                writer = response.getWriter();
                LOGGER.error("请求json出现异常",ex);
                ajaxMessageEntity.setMessager(AjaxMessageResult.FAIL_ONE, "error");
                writer.write(JSON.toJSONString(ajaxMessageEntity));
                writer.flush();
            } catch (Exception e) {
                LOGGER.error("请求出现异常",e);
                ajaxMessageEntity.setMessager(AjaxMessageResult.FAIL_ONE, "error");
                writer.write(JSON.toJSONString(ajaxMessageEntity));
                writer.flush();
            } finally{
                if(writer!=null){
                    writer.close();
                }
            }
            return null;
        }
    }

    /**
     * 注册freemarker页面可以调用的类
     *
     * @param  packageName
     * @return TemplateHashModel
     */
    private static TemplateHashModel registerTmplateModel(String packageName) {
        TemplateHashModel fileStatics = null;
        try {
            fileStatics = (TemplateHashModel) staticModels.get(packageName);
        } catch (TemplateModelException e) {
            LOGGER.error("请求出现异常",e);
        }
        return fileStatics;
    }


}