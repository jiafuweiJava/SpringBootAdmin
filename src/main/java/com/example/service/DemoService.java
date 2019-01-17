package com.example.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DemoDao;
import com.example.po.Demo;
import com.example.po.DemoRepository;

/**
 * 提供Demo服务类.
 * @author fwjia
 *
 */
@Service
public class DemoService {
	
	@Resource
    private DemoRepository demoRepository;
	
	@Resource
    private DemoDao demoDao;
	
	@Transactional
    public void save(Demo demo){
       demoRepository.save(demo);
    }
	
	public Demo getById(long id){
        //demoRepository.findOne(id);//在demoRepository可以直接使用findOne进行获取.
        return demoDao.getById(id);
 }
	
}
